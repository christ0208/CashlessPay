package factories;

import java.util.Vector;

import components.Membership;
import components.User;

public interface BaseFactory {
	public Membership create(Vector<User> users);
}
