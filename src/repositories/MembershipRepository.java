package repositories;

import java.util.Vector;

import components.Membership;

public class MembershipRepository extends BaseRepository{
	private static MembershipRepository membershipRepository = new MembershipRepository();
	private Vector<Membership> memberships = new Vector<Membership>();
	
	public static MembershipRepository getInstance(){
		return membershipRepository;
	}
	
	@Override
	public void printAll() {
		if(memberships.isEmpty()) {
			System.out.println("No memberships registered!");
			return;
		}
		
		for (Membership membership : memberships) {
			System.out.printf("| %36s | %15s | %15s | %12s | %13d |", membership.getId(), membership.getName(), membership.getPhoneNumber(), membership.getTotalSavings());
		}
	}
	
	@Override
	public void insert(Object newObject) {
		if(newObject instanceof Membership)
			memberships.add((Membership) newObject);
	}
}
