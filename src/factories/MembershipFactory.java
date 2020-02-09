package factories;

import components.Membership;

public class MembershipFactory implements BaseFactory{

	@Override
	public Membership makeMembership(String name, String email, String phoneNumber) {
		// TODO Auto-generated method stub
		return new Membership(name, email, phoneNumber);
	}
	
}
