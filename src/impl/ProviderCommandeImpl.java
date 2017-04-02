package impl;

import interfaces.ICommande;
import definitionsComposants.ComposantProviderCommande;

public class ProviderCommandeImpl extends ComposantProviderCommande{
	private Provider provider;
	
	@Override
	protected ICommande make_unProviderCommande() {
		provider = new Provider();
		return provider;
	}

}
