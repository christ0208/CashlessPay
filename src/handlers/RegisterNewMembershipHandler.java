package handlers;

import java.util.Scanner;
import java.util.Vector;

import commands.CallbackInterface;
import components.User;
import factories.MembershipFactory;
import factories.UserFactory;
import repositories.MembershipRepository;
import utils.ClearScreen;
import validators.EmailValidator;

public class RegisterNewMembershipHandler implements CallbackInterface {
	private Scanner scan = new Scanner(System.in);
	private MembershipRepository membershipRepository = MembershipRepository.getInstance();
	private MembershipFactory membershipFactory = MembershipFactory.getInstance();
	private UserFactory userFactory = UserFactory.getInstance();
	private EmailValidator emailValidator = new EmailValidator();
	private ClearScreen clearScreen = ClearScreen.getInstance();
	
	private Vector<User> users;
	
	@Override
	public void execute() {
		clearScreen.clear();
		users = new Vector<User>();
		int userAmount = askUserAmount();
		for (int i = 1; i <= userAmount; i++) {
			System.out.println("User " + i);
			String name = askName();
			String email = askEmail();
			String phoneNumber = askPhoneNumber();
			users.add(userFactory.create(name, email, phoneNumber));
		}
		
		membershipRepository.insert(membershipFactory.create(users));
		System.out.println("Success register new membership");
		scan.nextLine();
	}
	
	private int askUserAmount() {
		int input = 0;
		do {
			System.out.print("Input number of users in the membership [1-5]: ");
			input = scanNumber();
		}while(input < 1 || input > 5);
		return input;
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
		}while(!emailValidator.validate(input) || membershipRepository.getByEmail(input) != null || findEmailInTempStorage(users, input));
		return input;
	}
	
	private String askPhoneNumber() {
		String input = "";
		do {
			System.out.print("Input member's phone number [12-14 characters, starts with '+62']: ");
			input = scan.nextLine();
		}while(!input.startsWith("+62") || input.length() < 12 || input.length() > 14 || membershipRepository.getByPhoneNumber(input) != null);
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
	
	private boolean findEmailInTempStorage(Vector<User> users, String email) {
		for (User user : users) {
			if(email.equals(user.getEmail())) return true;
		}
		
		return false;
	}

}
