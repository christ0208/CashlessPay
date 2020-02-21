package accessors;

import java.util.Vector;

import components.User;

public interface MembershipAccessors {
	public String getId();
	public Vector<User> getUsers();
	public Integer getTotalSavings();
}
