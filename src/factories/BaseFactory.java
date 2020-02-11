package factories;

import components.Membership;

public interface BaseFactory {
	public Membership create(String name, String email, String phoneNumber);
}
