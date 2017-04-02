package impl;

import interfaces.IAF;
import definitionsComposants.ComposantStoreIAF;

public class StoreIAFImpl extends ComposantStoreIAF{
	private Store store;
	
	@Override
	protected IAF make_unStoreIAF() {
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
