package definitionsComposants;

import interfaces.IAdmin;
import interfaces.ITB;

@SuppressWarnings("all")
public abstract class ComposantBank {
  public interface Requires {
    /**
     * This can be called by the implementation to access this required port.
     * 
     */
    public IAdmin estore();
    
    /**
     * This can be called by the implementation to access this required port.
     * 
     */
    public IAdmin anne();
    
    /**
     * This can be called by the implementation to access this required port.
     * 
     */
    public IAdmin bob();
  }
  
  public interface Component extends ComposantBank.Provides {
  }
  
  public interface Provides {
    /**
     * This can be called to access the provided port.
     * 
     */
    public ITB uneBank();
  }
  
  public interface Parts {
  }
  
  public static class ComponentImpl implements ComposantBank.Component, ComposantBank.Parts {
    private final ComposantBank.Requires bridge;
    
    private final ComposantBank implementation;
    
    public void start() {
      this.implementation.start();
      this.implementation.started = true;
    }
    
    protected void initParts() {
      
    }
    
    protected void init_uneBank() {
      assert this.uneBank == null: "This is a bug.";
      this.uneBank = this.implementation.make_uneBank();
      if (this.uneBank == null) {
      	throw new RuntimeException("make_uneBank() in definitionsComposants.ComposantBank shall not return null.");
      }
    }
    
    protected void initProvidedPorts() {
      init_uneBank();
    }
    
    public ComponentImpl(final ComposantBank implem, final ComposantBank.Requires b, final boolean doInits) {
      this.bridge = b;
      this.implementation = implem;
      
      assert implem.selfComponent == null: "This is a bug.";
      implem.selfComponent = this;
      
      // prevent them to be called twice if we are in
      // a specialized component: only the last of the
      // hierarchy will call them after everything is initialised
      if (doInits) {
      	initParts();
      	initProvidedPorts();
      }
    }
    
    private ITB uneBank;
    
    public ITB uneBank() {
      return this.uneBank;
    }
  }
  
  /**
   * Used to check that two components are not created from the same implementation,
   * that the component has been started to call requires(), provides() and parts()
   * and that the component is not started by hand.
   * 
   */
  private boolean init = false;;
  
  /**
   * Used to check that the component is not started by hand.
   * 
   */
  private boolean started = false;;
  
  private ComposantBank.ComponentImpl selfComponent;
  
  /**
   * Can be overridden by the implementation.
   * It will be called automatically after the component has been instantiated.
   * 
   */
  protected void start() {
    if (!this.init || this.started) {
    	throw new RuntimeException("start() should not be called by hand: to create a new component, use newComponent().");
    }
  }
  
  /**
   * This can be called by the implementation to access the provided ports.
   * 
   */
  protected ComposantBank.Provides provides() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("provides() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * This should be overridden by the implementation to define the provided port.
   * This will be called once during the construction of the component to initialize the port.
   * 
   */
  protected abstract ITB make_uneBank();
  
  /**
   * This can be called by the implementation to access the required ports.
   * 
   */
  protected ComposantBank.Requires requires() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("requires() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if requires() is needed to initialise the component.");
    }
    return this.selfComponent.bridge;
  }
  
  /**
   * This can be called by the implementation to access the parts and their provided ports.
   * 
   */
  protected ComposantBank.Parts parts() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("parts() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * Not meant to be used to manually instantiate components (except for testing).
   * 
   */
  public synchronized ComposantBank.Component _newComponent(final ComposantBank.Requires b, final boolean start) {
    if (this.init) {
    	throw new RuntimeException("This instance of ComposantBank has already been used to create a component, use another one.");
    }
    this.init = true;
    ComposantBank.ComponentImpl  _comp = new ComposantBank.ComponentImpl(this, b, true);
    if (start) {
    	_comp.start();
    }
    return _comp;
  }
}
