package factories;

import components.Membership;

public class MembershipFactory implements BaseFactory{
	private static MembershipFactory membershipFactory = new MembershipFactory();
	
	public static MembershipFactory getInstance() {
		return membershipFactory;
	}

	@Override
	public Membership create(String name, String email, String phoneNumber) {
		// TODO Auto-generated method stub
		return new Membership(name, email, phoneNumber);
	}
	
}
