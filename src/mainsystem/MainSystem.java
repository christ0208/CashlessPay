package mainsystem;

import java.util.Vector;

import commands.CallbackInterface;
import handlers.AddNewMembershipHandler;
import handlers.DepositMoneyHandler;
import handlers.DoPaymentHandler;
import handlers.VerifyMembershipHandler;

public class MainSystem {
	private Vector<CallbackInterface> handlers = new Vector<CallbackInterface>();

	public MainSystem() {
		// TODO Auto-generated constructor stub
		initializeHandlers();
	}
	
	private void initializeHandlers() {
		handlers.add(new AddNewMembershipHandler());
		handlers.add(new VerifyMembershipHandler());
		handlers.add(new DepositMoneyHandler());
		handlers.add(new DoPaymentHandler());
	}
	
	public static void main(String[] args) {
		// Tried Design Pattern:
		// 1. Singleton: for saving membership data in vector
		// 2. Chain of Responsibility
		// 3. Command
		// 4. Factory: for create new object of Membership and VerifiedMembership
		new MainSystem();
	}

}
