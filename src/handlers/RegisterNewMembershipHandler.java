package handlers;

import java.util.Scanner;

import commands.CallbackInterface;
import factories.MembershipFactory;
import repositories.MembershipRepository;
import utils.ClearScreen;
import validators.EmailValidator;

public class RegisterNewMembershipHandler implements CallbackInterface {
	private Scanner scan = new Scanner(System.in);
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private MembershipFactory membershipFactory = MembershipFactory.getInstance();
	private EmailValidator emailValidator = new EmailValidator();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	@Override
	public void execute() {
		clearScreen.clear();
		String name = askName();
		String email = askEmail();
		String phoneNumber = askPhoneNumber();
		
		membershipRepository.insert(membershipFactory.create(name, email, phoneNumber));
		System.out.println("Success register new membership");
		scan.nextLine();
	}
	
	private String askName() {
		String input = "";
		do {
			System.out.print("Input member's name [min. 5 characters]: ");
			input = scan.nextLine();
		}while(input.length() < 5);
		return input;
	}
	
	private String askEmail() {
		String input = "";
		do {
			System.out.print("Input member's email [Must be in email format, i.e. test.ing@test.com]: ");
			input = scan.nextLine();
		}while(!emailValidator.validate(input) || membershipRepository.getByEmail(input) != null);
		return input;
	}
	
	private String askPhoneNumber() {
		String input = "";
		do {
			System.out.print("Input member's phone number [10-12 characters, starts with '+62']: ");
			input = scan.nextLine();
		}while(!input.startsWith("+62") || input.length() < 12 || input.length() > 14 || membershipRepository.getByPhoneNumber(input) != null);
		return input;
	}

}
