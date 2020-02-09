package handlers;

import commands.CallbackInterface;

public class DoPaymentHandler implements CallbackInterface {

	@Override
	public void execute() {
		System.out.println("Do Payment");
	}

}
