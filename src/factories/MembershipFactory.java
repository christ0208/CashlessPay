package factories;

import java.util.Vector;

import components.Membership;
import components.User;

public class MembershipFactory implements BaseFactory{
	private static MembershipFactory membershipFactory = new MembershipFactory();
	
	public static MembershipFactory getInstance() {
		return membershipFactory;
	}

	@Override
	public Membership create(Vector<User> users) {
		// TODO Auto-generated method stub
		return new Membership(users);
	}
	
}
