package factories;

import components.Membership;

public interface BaseFactory {
	public Membership makeMembership(String name, String email, String phoneNumber);
}
