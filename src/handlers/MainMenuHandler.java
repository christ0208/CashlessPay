package handlers;

import java.util.Scanner;
import java.util.Vector;

import commands.CallbackInterface;
import utils.ClearScreen;

public class MainMenuHandler implements CallbackInterface{
	private Scanner scan = new Scanner(System.in);
	private Vector<CallbackInterface> handlers = new Vector<CallbackInterface>();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	private final int EXIT_MENU = 5; 

	@Override
	public void execute() {
		initializeHandlers();
		showMainMenu();
	}

	private void initializeHandlers() {
		handlers.add(new RegisterNewMembershipHandler());
		handlers.add(new ShowAllMembershipHandler());
		handlers.add(new VerifyMembershipHandler());
		handlers.add(new DepositMoneyHandler());
	}
	
	private void showMainMenu() {
		int input = 0;
		do {
			clearScreen.clear();
			showMainMenuOptions();
			input = scanNumber();
			redirection(input);
		}while(input != EXIT_MENU);
	}
	
	private void showMainMenuOptions() {
		System.out.println("");
		System.out.println(".|'''',            '||    '||`                   '||'''|,            "); 
		System.out.println("||                  ||     ||                     ||   ||            "); 
		System.out.println("||      '''|. ('''' ||''|, || .|''|,(''''(''''    ||...|'''|.'||  ||`"); 
		System.out.println("||     .|''||  `'') ||  || || ||..|| `'') `'')    ||   .|''|| `|..|| "); 
		System.out.println("`|....'`|..||.`...'.||  ||.||.`|... `...'`...'   .||   `|..||.    || "); 
		System.out.println("                                                               ,  |' "); 
		System.out.println("                                                                ''   "); 
		System.out.println("=====================================================================");
		System.out.println("1. Register New Membership");
		System.out.println("2. Show All Membership");
		System.out.println("3. Verify Membership");
		System.out.println("4. Deposit Money");
		System.out.println("5. Exit");
		System.out.print("Choose >> ");
	}
	
	private int scanNumber() {
		int input = 0;
		try {
			input = scan.nextInt();
		} catch (Exception e) {
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
