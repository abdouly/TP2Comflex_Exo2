package impl;

import interfaces.IInfosProvider;
import definitionsComposants.ComposantProviderInfos;

public class ProviderInfosImpl extends ComposantProviderInfos{
	private Provider provider;
	
	@Override
	protected IInfosProvider make_unProviderInfos() {
		provider = new Provider();
		return provider;
	}

}
