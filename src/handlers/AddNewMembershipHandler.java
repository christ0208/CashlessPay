package handlers;

import commands.CallbackInterface;

public class AddNewMembershipHandler implements CallbackInterface {

	@Override
	public void execute() {
		System.out.println("Add new Membership");
	}

}
