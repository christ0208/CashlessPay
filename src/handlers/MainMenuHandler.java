package handlers;

import java.util.Scanner;
import java.util.Vector;

import commands.CallbackInterface;

public class MainMenuHandler implements CallbackInterface{
	private Scanner scan = new Scanner(System.in);
	private Vector<CallbackInterface> handlers = new Vector<CallbackInterface>();
	private ShowAllMembershipHandler showAllMembershipHandler = new ShowAllMembershipHandler();
	
	private final int EXIT_MENU = 4; 

	@Override
	public void execute() {
		initializeHandlers();
		showMainMenu();
	}

	private void initializeHandlers() {
		handlers.add(new RegisterNewMembershipHandler());
		handlers.add(new VerifyMembershipHandler());
		handlers.add(new ManageMoneyHandler());
	}
	
	private void showMainMenu() {
		int input = 0;
		do {
			showAllMemberships();
			showMainMenuOptions();
			input = scanNumber();
			redirection(input);
		}while(input != EXIT_MENU);
	}
	
	private void showMainMenuOptions() {
		System.out.println("1. Register New Membership");
		System.out.println("2. Verify Membership");
		System.out.println("3. Manage Money");
		System.out.println("4. Exit");
		System.out.print("Choose >> ");
	}
	
	private void showAllMemberships() {
		showAllMembershipHandler.execute();
	}
	
	private int scanNumber() {
		int input = 0;
		try {
			input = scan.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			input = -1;
		}
		scan.nextLine();
		return input;
	}
	
	private void redirection(int input) {
		if(input == EXIT_MENU) return;
		else if(input < 1 || input > EXIT_MENU) return;
		
		handlers.get(input - 1).execute();
	}
	
}
