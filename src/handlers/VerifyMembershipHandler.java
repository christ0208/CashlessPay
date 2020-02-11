package handlers;

import java.util.Scanner;
import java.util.Vector;

import commands.CallbackInterface;
import components.Membership;
import repositories.MembershipRepository;
import utils.ClearScreen;

public class VerifyMembershipHandler implements CallbackInterface {
	private Scanner scan = new Scanner(System.in);
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	@Override
	public void execute() {
		clearScreen.clear();
		Vector<Membership> unverifiedMemberships = showUnverifiedMemberships();
		
		if(unverifiedMemberships.isEmpty()) {
			System.out.println("There's no unverified memberships");
			scan.nextLine();
			return;
		}
		
		int input = 0;
		do {
			System.out.printf("Input index you want to verify [1-%d]: ", unverifiedMemberships.size());
			input = scanNumber();
		}while(input < 1 || input > unverifiedMemberships.size());
		
		membershipRepository.verifyUser(unverifiedMemberships.get(input - 1));
		System.out.println("Verify Membership Success");
		scan.nextLine();
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
	
	private Vector<Membership> showUnverifiedMemberships() {
		Vector<Membership> unverifiedMemberships = membershipRepository.getUnverifiedUser();
		
		if(unverifiedMemberships.isEmpty()) return new Vector<Membership>();
		
		System.out.printf("| %-36s | %-15s | %-25s | %-12s | %-13s |\n", "No", "Name", "Email", "Phone Number", "Total Savings");
		for (Membership membership : unverifiedMemberships) {
			System.out.printf("| %-36s | %-15s | %-25s | %-12s | %-13d |\n", membership.getId(), membership.getName(), membership.getEmail(), membership.getPhoneNumber(), membership.getTotalSavings());
		}
		return unverifiedMemberships;
	}

}
