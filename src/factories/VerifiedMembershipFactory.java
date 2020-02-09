package factories;

import components.Membership;
import components.VerifiedMembership;

public class VerifiedMembershipFactory implements BaseFactory{
	private static VerifiedMembershipFactory verifiedMembershipFactory = new VerifiedMembershipFactory();
	
	public static VerifiedMembershipFactory getInstance() {
		return verifiedMembershipFactory;
	}

	@Override
	public Membership makeMembership(String name, String email, String phoneNumber) {
		// TODO Auto-generated method stub
		return new VerifiedMembership(name, email, phoneNumber);
	}
	
}
