package impl;

import definitionsComposants.ComposantAccount;
import definitionsComposants.ComposantBank;
import definitionsComposants.ComposantClient;
import definitionsComposants.ComposantCommandeComposite;
import definitionsComposants.ComposantProviderCommande;
import definitionsComposants.ComposantProviderInfos;
import definitionsComposants.ComposantStoreIAF;
import definitionsComposants.ComposantStoreIAPP;

public class CommandeCompositeImp extends ComposantCommandeComposite{

	@Override
	protected ComposantClient make_client() {
		// TODO Auto-generated method stub
		return new ClientImpl();
	}

	@Override
	protected ComposantStoreIAF make_storeIAF() {
		// TODO Auto-generated method stub
		return new StoreIAFImpl();
	}

	@Override
	protected ComposantStoreIAPP make_storeIAPP() {
		// TODO Auto-generated method stub
		return new StoreIAPPImpl();
	}

	@Override
	protected ComposantBank make_bank() {
		// TODO Auto-generated method stub
		return new BankImpl();
	}

	@Override
	protected ComposantAccount make_account() {
		// TODO Auto-generated method stub
		return new AccountImpl();
	}

	@Override
	protected ComposantProviderCommande make_providerCommande() {
		// TODO Auto-generated method stub
		return new ProviderCommandeImpl();
	}

	@Override
	protected ComposantProviderInfos make_providerInfos() {
		// TODO Auto-generated method stub
		return new ProviderInfosImpl();
	}

}
