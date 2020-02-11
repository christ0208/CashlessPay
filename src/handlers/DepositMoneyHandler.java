package handlers;

import java.util.Scanner;

import commands.CallbackInterface;
import components.Membership;
import components.VerifiedMembership;
import repositories.MembershipRepository;
import utils.ClearScreen;

public class DepositMoneyHandler implements CallbackInterface {
	private Scanner scan = new Scanner(System.in);
	private ShowAllMembershipHandler showAllMembershipHandler = new ShowAllMembershipHandler();
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	@Override
	public void execute() {
		clearScreen.clear();
		if(membershipRepository.totalData() == 0) {
			System.out.println("");
		}
		
		showAllMemberships();
		int index = askIndex();
		int added = askAddSaving();
		
		Membership selectedMembership = membershipRepository.getByIndex(index);
		selectedMembership.increaseTotalSavings(added);
		
		if(selectedMembership instanceof VerifiedMembership)
			((VerifiedMembership) selectedMembership).increaseTotalPoints(added);
		
		System.out.println("Success add deposit money");
		scan.nextLine();
	}
	
	private void showAllMemberships() {
		showAllMembershipHandler.execute();
	}
	
	private int askIndex() {
		int input = 0;
		do {
			System.out.printf("Input index that you want to deposit money to [1-%d]: ", membershipRepository.totalData());
			input = scanNumber();
		}while(!membershipRepository.findIndex(input));
		return input;
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
	
	private int askAddSaving() {
		int input = 0;
		do {
			System.out.print("Input amount of money you want to deposit [more than 0]: ");
			input = scanNumber();
		}while(input < 1);
		return input;
	}

}
