package handlers;

import java.util.Scanner;

import commands.CallbackInterface;
import components.Membership;
import components.VerifiedMembership;
import repositories.MembershipRepository;
import utils.ClearScreen;

public class DoPaymentHandler implements CallbackInterface {
	private Scanner scan = new Scanner(System.in);
	private ShowAllMembershipHandler showAllMembershipHandler = new ShowAllMembershipHandler();
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	@Override
	public void execute() {
		clearScreen.clear();
		showAllMemberships();
		
		int index = askIndex();
		Membership membership = membershipRepository.getByIndex(index);
		String paymentType = "";
		
		int paid = 0;
		if(membership instanceof VerifiedMembership && ((VerifiedMembership) membership).getTotalPoints() < 1) {
			System.out.println("Points are not enough");
		} else if(membership instanceof VerifiedMembership) {
			paymentType = askPaymentType();
			if(paymentType.equals("Points")){
				paid = askPaid(membership, paymentType);
				((VerifiedMembership) membership).decreaseTotalPoints(paid);
				System.out.println("Payment success, your current points are " + ((VerifiedMembership) membership).getTotalPoints());
			}
			else{
				paid = askPaid(membership);
				membership.decreaseTotalSavings(paid);
				System.out.println("Payment success, your current savings are " + membership.getTotalSavings());
			}
		} else if(membership.getTotalSavings() < 1) {
			System.out.println("Savings are not enough");
		} else {
			paid = askPaid(membership);
			membership.decreaseTotalSavings(paid);
			System.out.println("Payment success, your current savings are " + membership.getTotalSavings());
		}
		scan.nextLine();
	}
	
	private void showAllMemberships() {
		showAllMembershipHandler.execute();
	}
	
	private int askIndex() {
		int input = 0;
		do{
			System.out.printf("Input index you want to select [1-%d]: ", membershipRepository.totalData());
			input = scanNumber();
		}while(input < 1 || input > membershipRepository.totalData());
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
	
	private String askPaymentType() {
		String input = "";
		do {
			System.out.print("Input payment type [Cash | Points]: ");
			input = scan.nextLine();
		}while(!input.equals("Cash") && !input.equals("Points"));
		return input;
	}
	
	private int askPaid(Membership membership) {
		int input = 0;
		do {
			System.out.printf("Input amount you want to pay [1-%d]: ", membership.getTotalSavings());
			input = scanNumber();
		}while(input < 1 || input > membership.getTotalSavings());
		return input;
	}
	
	private int askPaid(Membership membership, String paymentType) {
		int input = 0;
		do {
			System.out.printf("Input amount you want to pay [1-%d]: ", ((VerifiedMembership) membership).getTotalPoints() * 100);
			input = scanNumber();
		}while(input < 1 || input > ((VerifiedMembership) membership).getTotalPoints() * 100);
		return input;
	}

}
