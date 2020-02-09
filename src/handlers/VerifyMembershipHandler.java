package handlers;

import commands.CallbackInterface;

public class VerifyMembershipHandler implements CallbackInterface {

	@Override
	public void execute() {
		System.out.println("Verify Membership");
	}

}
