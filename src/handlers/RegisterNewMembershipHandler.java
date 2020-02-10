package handlers;

import java.util.Scanner;

import commands.CallbackInterface;
import factories.MembershipFactory;
import repositories.MembershipRepository;
import validators.EmailValidator;

public class RegisterNewMembershipHandler implements CallbackInterface {
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private MembershipFactory membershipFactory = MembershipFactory.getInstance();
	private EmailValidator emailValidator = new EmailValidator();
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public void execute() {
		String name = askName();
		String email = askEmail();
		String phoneNumber = askPhoneNumber();
		
		membershipRepository.insert(membershipFactory.makeMembership(name, email, phoneNumber));
		System.out.println("Success register new membership");
		scan.nextLine();
	}
	
	private String askName() {
		String input = "";
		do {
			System.out.println("Input member's name [min. 5 characters]: ");
			input = scan.nextLine();
		}while(input.length() < 5);
		return input;
	}
	
	private String askEmail() {
		String input = "";
		do {
			System.out.println("Input member's email [Must be in email format, i.e. test.ing@test.com]: ");
			input = scan.nextLine();
		}while(!emailValidator.validate(input));
		return input;
	}
	
	private String askPhoneNumber() {
		String input = "";
		do {
			System.out.println("Input member's phone number [10-12 characters, starts with '+62']: ");
			input = scan.nextLine();
		}while(!input.startsWith("+62") || input.length() < 10 || input.length() > 12);
		return input;
	}

}
