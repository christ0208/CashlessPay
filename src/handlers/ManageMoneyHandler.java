package handlers;

import java.util.Scanner;
import java.util.Vector;

import commands.CallbackInterface;
import utils.ClearScreen;

public class ManageMoneyHandler implements CallbackInterface{
	private Scanner scan = new Scanner(System.in);
	private Vector<CallbackInterface> handlers = new Vector<CallbackInterface>();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	private final int EXIT_MENU = 3;

	public ManageMoneyHandler() {
		handlers.add(new DepositMoneyHandler());
		handlers.add(new DoPaymentHandler());
	}
	
	@Override
	public void execute() {
		showMenu();
	}
	
	public void showMenu() {
		int input = 0;
		do {
			clearScreen.clear();
			showMenuOptions();
			input = scanNumber();
			redirection(input);
		}while(input < 1 || input > EXIT_MENU);
	}
	
	public void showMenuOptions() {
		System.out.println("Manage Money");
		System.out.println("============");
		System.out.println("1. Deposit Money");
		System.out.println("2. Do Payment");
		System.out.println("3. Exit");
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
