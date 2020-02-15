package handlers;

import java.util.Scanner;
import java.util.Vector;

import commands.CallbackInterface;
import components.Membership;
import components.VerifiedMembership;
import repositories.MembershipRepository;
import utils.ClearScreen;

public class VerifyMembershipHandler implements CallbackInterface {
	private Scanner scan = new Scanner(System.in);
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	@Override
	public void execute() {
		clearScreen.clear();
		
		if(membershipRepository.totalData() == 0) {
			System.out.println("There is no membership registered");
			scan.nextLine();
			return;
		}
		
		String email = askEmail();
		
		Membership membership = membershipRepository.getByEmail(email);
		if(membership == null) {
			System.out.println("Membership not found");
			scan.nextLine();
			return;
		} else if(membership instanceof VerifiedMembership) {
			System.out.println("This membership already verified");
			scan.nextLine();
			return;
		}
		
		showMembership(membership);
		String answer = askConfirmation();
		
		if(answer.equals("Yes")) {
			membershipRepository.verifyUser(membership);
			System.out.println("Verify Membership Success");
			scan.nextLine();
		}
	}
	
	private void showMembership(Membership membership) {
		System.out.printf("| %-36s | %-15s | %-25s | %-14s | %-13s |\n", "Member ID", "Name", "Email", "Phone Number", "Total Savings");
		System.out.printf("| %-36s | %-15s | %-25s | %-14s | %-13d |\n", membership.getId(), membership.getUser().getName(), membership.getUser().getEmail(), membership.getUser().getPhoneNumber(), membership.getTotalSavings());
	}
	
	private String askEmail() {
		String input = "";
		do {
			System.out.print("Input email of membership you want to verify [must not empty]: ");
			input = scan.nextLine();
		}while(input.equals(""));
		return input;
	}
	
	private String askConfirmation() {
		String input = "";
		do {
			System.out.print("Are you sure this is your data [Yes | No]? ");
			input = scan.nextLine();
		}while(!input.equals("Yes") && !input.equals("No"));
		
		return input;
	}

}
