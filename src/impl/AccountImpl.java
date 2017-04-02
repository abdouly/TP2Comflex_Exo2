package impl;

import interfaces.IAdmin;
import definitionsComposants.ComposantAccount;

public class AccountImpl extends ComposantAccount{
	Account account;
	@Override
	protected IAdmin make_unAccount() {
		account = new Account();
		return account;
	}

}
