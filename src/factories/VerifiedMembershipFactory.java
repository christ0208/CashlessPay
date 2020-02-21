package factories;

import java.util.Vector;

import components.Membership;
import components.User;
import components.VerifiedMembership;

public class VerifiedMembershipFactory implements BaseFactory{
	private static VerifiedMembershipFactory verifiedMembershipFactory = new VerifiedMembershipFactory();
	
	public static VerifiedMembershipFactory getInstance() {
		return verifiedMembershipFactory;
	}

	@Override
	public Membership create(Vector<User> users) {
		// TODO Auto-generated method stub
		return new VerifiedMembership(users);
	}
	
	public VerifiedMembership create(Membership membership) {
		return new VerifiedMembership(membership);
	}
	
}
