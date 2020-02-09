package handlers;

import commands.CallbackInterface;

public class DepositMoneyHandler implements CallbackInterface {

	@Override
	public void execute() {
		System.out.println("Deposit Money");
	}

}
