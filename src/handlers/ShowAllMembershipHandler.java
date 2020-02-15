package handlers;

import java.util.Scanner;

import commands.CallbackInterface;
import repositories.MembershipRepository;

public class ShowAllMembershipHandler implements CallbackInterface{
	private Scanner scan = new Scanner(System.in); 
	private MembershipRepository membershipRepo = MembershipRepository.getInstance();

	@Override
	public void execute() {
		membershipRepo.printAll();
		scan.nextLine();
	}

}
