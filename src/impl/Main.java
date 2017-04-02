package impl;

import definitionsComposants.ComposantCommandeComposite;

public class Main {

	public static void main(String[] args) {
		ComposantCommandeComposite.Component c = (new CommandeCompositeImp().newComponent());
		c.leClient().run();
	}

}
