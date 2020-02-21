package handlers;

import java.util.Scanner;

import commands.CallbackInterface;
import repositories.MembershipRepository;
import utils.ClearScreen;

public class ShowAllMembershipHandler implements CallbackInterface{
	private Scanner scan = new Scanner(System.in); 
	private MembershipRepository membershipRepo = MembershipRepository.getInstance();
	ClearScreen clrscr = new ClearScreen();

	@Override
	public void execute() {
		clrscr.clear();
		membershipRepo.printAll();
		scan.nextLine();
	}

}
