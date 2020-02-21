package factories;

import components.User;

public class UserFactory {
	private static UserFactory userFactory = new UserFactory();
	
	public static UserFactory getInstance() {
		return userFactory;
	}
	
	
	public User create(String name, String email, String phoneNumber) {
		return new User(name, email, phoneNumber);
	}

}
