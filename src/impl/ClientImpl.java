package impl;

import definitionsComposants.ComposantClient;

public class ClientImpl extends ComposantClient{
	private Client c;
	
	@Override
	protected Runnable make_unClient() {
		c = new Client();
		return c;
	}

	@Override
	protected void start(){
		super.start();
		c.initStoreIAF(requires().unStoreIAF());
		c.initStoreIAPP(requires().unStoreIAPP());
	}
	
}
