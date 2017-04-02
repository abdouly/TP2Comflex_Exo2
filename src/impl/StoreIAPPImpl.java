package impl;

import interfaces.IAPP;
import definitionsComposants.ComposantStoreIAPP;

public class StoreIAPPImpl extends ComposantStoreIAPP{
	private Store store;
	@Override
	protected IAPP make_unStoreIAPP() {
		store = new Store();
		return store;
	}

	@Override
	protected void start(){
		super.start();
		store.initBank(requires().uneBank());
		store.initICommande(requires().unProviderCommande());
		store.initIInfosProvider(requires().unProviderInfos());
	}


}
