package mainsystem;

import handlers.MainMenuHandler;

public class MainSystem {

	public MainSystem() {
		(new MainMenuHandler()).execute();
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
