package impl;

import interfaces.ITB;
import definitionsComposants.ComposantBank;

public class BankImpl extends ComposantBank{
	private Bank bank;
	
	@Override
	protected ITB make_uneBank() {
		// TODO Auto-generated method stub
		bank = new Bank();
		return bank;
	}

	@Override 
	protected void start(){
		super.start();
		bank.initEstore(requires().estore());
		bank.initBob(requires().bob());
		bank.initAnne(requires().anne());
	}
}
