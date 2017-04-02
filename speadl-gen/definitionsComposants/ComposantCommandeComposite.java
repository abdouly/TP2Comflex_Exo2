package definitionsComposants;

import definitionsComposants.ComposantAccount;
import definitionsComposants.ComposantBank;
import definitionsComposants.ComposantClient;
import definitionsComposants.ComposantProviderCommande;
import definitionsComposants.ComposantProviderInfos;
import definitionsComposants.ComposantStoreIAF;
import definitionsComposants.ComposantStoreIAPP;
import interfaces.IAF;
import interfaces.IAPP;
import interfaces.IAdmin;
import interfaces.ICommande;
import interfaces.IInfosProvider;
import interfaces.ITB;

@SuppressWarnings("all")
public abstract class ComposantCommandeComposite {
  public interface Requires {
  }
  
  public interface Component extends ComposantCommandeComposite.Provides {
  }
  
  public interface Provides {
    /**
     * This can be called to access the provided port.
     * 
     */
    public Runnable leClient();
  }
  
  public interface Parts {
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public ComposantClient.Component client();
    
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public ComposantStoreIAF.Component storeIAF();
    
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public ComposantStoreIAPP.Component storeIAPP();
    
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public ComposantBank.Component bank();
    
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public ComposantAccount.Component account();
    
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public ComposantProviderCommande.Component providerCommande();
    
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public ComposantProviderInfos.Component providerInfos();
  }
  
  public static class ComponentImpl implements ComposantCommandeComposite.Component, ComposantCommandeComposite.Parts {
    private final ComposantCommandeComposite.Requires bridge;
    
    private final ComposantCommandeComposite implementation;
    
    public void start() {
      assert this.client != null: "This is a bug.";
      ((ComposantClient.ComponentImpl) this.client).start();
      assert this.storeIAF != null: "This is a bug.";
      ((ComposantStoreIAF.ComponentImpl) this.storeIAF).start();
      assert this.storeIAPP != null: "This is a bug.";
      ((ComposantStoreIAPP.ComponentImpl) this.storeIAPP).start();
      assert this.bank != null: "This is a bug.";
      ((ComposantBank.ComponentImpl) this.bank).start();
      assert this.account != null: "This is a bug.";
      ((ComposantAccount.ComponentImpl) this.account).start();
      assert this.providerCommande != null: "This is a bug.";
      ((ComposantProviderCommande.ComponentImpl) this.providerCommande).start();
      assert this.providerInfos != null: "This is a bug.";
      ((ComposantProviderInfos.ComponentImpl) this.providerInfos).start();
      this.implementation.start();
      this.implementation.started = true;
    }
    
    private void init_client() {
      assert this.client == null: "This is a bug.";
      assert this.implem_client == null: "This is a bug.";
      this.implem_client = this.implementation.make_client();
      if (this.implem_client == null) {
      	throw new RuntimeException("make_client() in definitionsComposants.ComposantCommandeComposite should not return null.");
      }
      this.client = this.implem_client._newComponent(new BridgeImpl_client(), false);
    }
    
    private void init_storeIAF() {
      assert this.storeIAF == null: "This is a bug.";
      assert this.implem_storeIAF == null: "This is a bug.";
      this.implem_storeIAF = this.implementation.make_storeIAF();
      if (this.implem_storeIAF == null) {
      	throw new RuntimeException("make_storeIAF() in definitionsComposants.ComposantCommandeComposite should not return null.");
      }
      this.storeIAF = this.implem_storeIAF._newComponent(new BridgeImpl_storeIAF(), false);
    }
    
    private void init_storeIAPP() {
      assert this.storeIAPP == null: "This is a bug.";
      assert this.implem_storeIAPP == null: "This is a bug.";
      this.implem_storeIAPP = this.implementation.make_storeIAPP();
      if (this.implem_storeIAPP == null) {
      	throw new RuntimeException("make_storeIAPP() in definitionsComposants.ComposantCommandeComposite should not return null.");
      }
      this.storeIAPP = this.implem_storeIAPP._newComponent(new BridgeImpl_storeIAPP(), false);
    }
    
    private void init_bank() {
      assert this.bank == null: "This is a bug.";
      assert this.implem_bank == null: "This is a bug.";
      this.implem_bank = this.implementation.make_bank();
      if (this.implem_bank == null) {
      	throw new RuntimeException("make_bank() in definitionsComposants.ComposantCommandeComposite should not return null.");
      }
      this.bank = this.implem_bank._newComponent(new BridgeImpl_bank(), false);
    }
    
    private void init_account() {
      assert this.account == null: "This is a bug.";
      assert this.implem_account == null: "This is a bug.";
      this.implem_account = this.implementation.make_account();
      if (this.implem_account == null) {
      	throw new RuntimeException("make_account() in definitionsComposants.ComposantCommandeComposite should not return null.");
      }
      this.account = this.implem_account._newComponent(new BridgeImpl_account(), false);
    }
    
    private void init_providerCommande() {
      assert this.providerCommande == null: "This is a bug.";
      assert this.implem_providerCommande == null: "This is a bug.";
      this.implem_providerCommande = this.implementation.make_providerCommande();
      if (this.implem_providerCommande == null) {
      	throw new RuntimeException("make_providerCommande() in definitionsComposants.ComposantCommandeComposite should not return null.");
      }
      this.providerCommande = this.implem_providerCommande._newComponent(new BridgeImpl_providerCommande(), false);
    }
    
    private void init_providerInfos() {
      assert this.providerInfos == null: "This is a bug.";
      assert this.implem_providerInfos == null: "This is a bug.";
      this.implem_providerInfos = this.implementation.make_providerInfos();
      if (this.implem_providerInfos == null) {
      	throw new RuntimeException("make_providerInfos() in definitionsComposants.ComposantCommandeComposite should not return null.");
      }
      this.providerInfos = this.implem_providerInfos._newComponent(new BridgeImpl_providerInfos(), false);
    }
    
    protected void initParts() {
      init_client();
      init_storeIAF();
      init_storeIAPP();
      init_bank();
      init_account();
      init_providerCommande();
      init_providerInfos();
    }
    
    protected void init_leClient() {
      // nothing to do here
    }
    
    protected void initProvidedPorts() {
      init_leClient();
    }
    
    public ComponentImpl(final ComposantCommandeComposite implem, final ComposantCommandeComposite.Requires b, final boolean doInits) {
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
    
    public Runnable leClient() {
      return this.client().
      unClient()
      ;
    }
    
    private ComposantClient.Component client;
    
    private ComposantClient implem_client;
    
    private final class BridgeImpl_client implements ComposantClient.Requires {
      public final IAF unStoreIAF() {
        return ComposantCommandeComposite.ComponentImpl.this.storeIAF().
        unStoreIAF()
        ;
      }
      
      public final IAPP unStoreIAPP() {
        return ComposantCommandeComposite.ComponentImpl.this.storeIAPP().
        unStoreIAPP()
        ;
      }
    }
    
    public final ComposantClient.Component client() {
      return this.client;
    }
    
    private ComposantStoreIAF.Component storeIAF;
    
    private ComposantStoreIAF implem_storeIAF;
    
    private final class BridgeImpl_storeIAF implements ComposantStoreIAF.Requires {
      public final ITB uneBank() {
        return ComposantCommandeComposite.ComponentImpl.this.bank().
        uneBank()
        ;
      }
      
      public final ICommande unProviderCommande() {
        return ComposantCommandeComposite.ComponentImpl.this.providerCommande().
        unProviderCommande()
        ;
      }
      
      public final IInfosProvider unProviderInfos() {
        return ComposantCommandeComposite.ComponentImpl.this.providerInfos().
        unProviderInfos()
        ;
      }
    }
    
    public final ComposantStoreIAF.Component storeIAF() {
      return this.storeIAF;
    }
    
    private ComposantStoreIAPP.Component storeIAPP;
    
    private ComposantStoreIAPP implem_storeIAPP;
    
    private final class BridgeImpl_storeIAPP implements ComposantStoreIAPP.Requires {
      public final ITB uneBank() {
        return ComposantCommandeComposite.ComponentImpl.this.bank().
        uneBank()
        ;
      }
      
      public final ICommande unProviderCommande() {
        return ComposantCommandeComposite.ComponentImpl.this.providerCommande().
        unProviderCommande()
        ;
      }
      
      public final IInfosProvider unProviderInfos() {
        return ComposantCommandeComposite.ComponentImpl.this.providerInfos().
        unProviderInfos()
        ;
      }
    }
    
    public final ComposantStoreIAPP.Component storeIAPP() {
      return this.storeIAPP;
    }
    
    private ComposantBank.Component bank;
    
    private ComposantBank implem_bank;
    
    private final class BridgeImpl_bank implements ComposantBank.Requires {
      public final IAdmin estore() {
        return ComposantCommandeComposite.ComponentImpl.this.account().
        unAccount()
        ;
      }
      
      public final IAdmin anne() {
        return ComposantCommandeComposite.ComponentImpl.this.account().
        unAccount()
        ;
      }
      
      public final IAdmin bob() {
        return ComposantCommandeComposite.ComponentImpl.this.account().
        unAccount()
        ;
      }
    }
    
    public final ComposantBank.Component bank() {
      return this.bank;
    }
    
    private ComposantAccount.Component account;
    
    private ComposantAccount implem_account;
    
    private final class BridgeImpl_account implements ComposantAccount.Requires {
    }
    
    public final ComposantAccount.Component account() {
      return this.account;
    }
    
    private ComposantProviderCommande.Component providerCommande;
    
    private ComposantProviderCommande implem_providerCommande;
    
    private final class BridgeImpl_providerCommande implements ComposantProviderCommande.Requires {
    }
    
    public final ComposantProviderCommande.Component providerCommande() {
      return this.providerCommande;
    }
    
    private ComposantProviderInfos.Component providerInfos;
    
    private ComposantProviderInfos implem_providerInfos;
    
    private final class BridgeImpl_providerInfos implements ComposantProviderInfos.Requires {
    }
    
    public final ComposantProviderInfos.Component providerInfos() {
      return this.providerInfos;
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
  
  private ComposantCommandeComposite.ComponentImpl selfComponent;
  
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
  protected ComposantCommandeComposite.Provides provides() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("provides() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * This can be called by the implementation to access the required ports.
   * 
   */
  protected ComposantCommandeComposite.Requires requires() {
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
  protected ComposantCommandeComposite.Parts parts() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("parts() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract ComposantClient make_client();
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract ComposantStoreIAF make_storeIAF();
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract ComposantStoreIAPP make_storeIAPP();
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract ComposantBank make_bank();
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract ComposantAccount make_account();
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract ComposantProviderCommande make_providerCommande();
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract ComposantProviderInfos make_providerInfos();
  
  /**
   * Not meant to be used to manually instantiate components (except for testing).
   * 
   */
  public synchronized ComposantCommandeComposite.Component _newComponent(final ComposantCommandeComposite.Requires b, final boolean start) {
    if (this.init) {
    	throw new RuntimeException("This instance of ComposantCommandeComposite has already been used to create a component, use another one.");
    }
    this.init = true;
    ComposantCommandeComposite.ComponentImpl  _comp = new ComposantCommandeComposite.ComponentImpl(this, b, true);
    if (start) {
    	_comp.start();
    }
    return _comp;
  }
  
  /**
   * Use to instantiate a component from this implementation.
   * 
   */
  public ComposantCommandeComposite.Component newComponent() {
    return this._newComponent(new ComposantCommandeComposite.Requires() {}, true);
  }
}
