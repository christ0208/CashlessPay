package handlers;

import java.util.Scanner;

import commands.CallbackInterface;
import components.Membership;
import components.User;
import components.VerifiedMembership;
import repositories.MembershipRepository;
import utils.ClearScreen;

public class DepositMoneyHandler implements CallbackInterface {
	private Scanner scan = new Scanner(System.in);
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	@Override
	public void execute() {
		clearScreen.clear();
		if(membershipRepository.totalData() == 0) {
			System.out.println("There's no membership registered");
			scan.nextLine();
			return;
		}
		
		String email = askEmail();
		Membership membership = membershipRepository.getByEmail(email);
		if(membership == null) {
			System.out.println("Membership not found");
			scan.nextLine();
			return;
		}
		
		showMembership(membership);
		String answer = askConfirmation();
		
		if(answer.equals("Yes")) {
			int added = askAddSaving();
			membership.increaseTotalSavings(added);
			
			if(membership instanceof VerifiedMembership)
				((VerifiedMembership) membership).increaseTotalPoints(added);
			
			System.out.println("Success add deposit money");
			scan.nextLine();
		}
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
	
	private void showMembership(Membership membership) {
		System.out.println("Member ID: " + membership.getId());
		System.out.println("Total Savings: Rp. " + membership.getTotalSavings());
		if(membership instanceof VerifiedMembership)
			System.out.println("Total Points: Rp. " + ((VerifiedMembership) membership).getTotalPoints());
		else
			System.out.println("Total Points: -");
		System.out.println("Users: ");
		System.out.printf("| %-2s | %-15s | %-25s | %-14s |\n", "No", "Name", "Email", "Phone Number");
		int index = 1;
		for (User currUser : membership.getUsers()) {
			System.out.printf("| %-2d | %-15s | %-25s | %-14s |\n", index++, currUser.getName(), currUser.getEmail(), currUser.getPhoneNumber());
		}
		System.out.println("");
	}
	
	private String askEmail() {
		String input = "";
		do {
			System.out.print("Input email of membership [must not empty]: ");
			input = scan.nextLine();
		}while(input.equals(""));
		return input;
	}
	
	private String askConfirmation() {
		String answer = "";
		do {
			System.out.print("Are you sure this is your data [Yes | No]? ");
			answer = scan.nextLine();
		}while(!answer.equals("Yes") && !answer.equals("No"));
		return answer;
	}
	
	private int askAddSaving() {
		int input = 0;
		do {
			System.out.print("Input amount of money you want to deposit [more than 0]: ");
			input = scanNumber();
		}while(input < 1);
		return input;
	}

}
