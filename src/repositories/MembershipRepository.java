package repositories;

import java.util.Vector;

import components.Membership;
import components.VerifiedMembership;
import factories.VerifiedMembershipFactory;

public class MembershipRepository extends BaseRepository{
	private static MembershipRepository membershipRepository = new MembershipRepository();
	private Vector<Membership> memberships = new Vector<Membership>();
	
	public MembershipRepository() {
		memberships.add(new Membership("testing aa", "testing.aa@gmail.com", "+62612312321"));
		memberships.add(new Membership("testing bb", "testing.bb@gmail.com", "+6212121221"));
		memberships.add(new Membership("testing cc", "testing.cc@gmail.com", "+6200201020"));
	}
	
	public static MembershipRepository getInstance(){
		return membershipRepository;
	}
	
	public void verifyUser(Membership selectedMembership) {
		Membership movedMembership = this.getById(selectedMembership.getId());
		
		VerifiedMembershipFactory verifiedMembershipFactory = VerifiedMembershipFactory.getInstance();
		
		VerifiedMembership verifiedMembership = verifiedMembershipFactory.create(movedMembership);
		this.insert(verifiedMembership);
		this.remove(movedMembership);
	}
	
	public Vector<Membership> getUnverifiedUser() {
		Vector<Membership> unverifiedMemberships = new Vector<Membership>();
		
		for (Membership membership : memberships) {
			if(!(membership instanceof VerifiedMembership))
				unverifiedMemberships.add(membership);
		}
		
		return unverifiedMemberships;
	}
	
	@Override
	public void printAll() {
		if(memberships.isEmpty()) {
			System.out.println("No memberships registered!");
			return;
		}
		
		System.out.printf("| %-36s | %-15s | %-25s | %-14s | %-13s | %-12s |\n", "Member ID", "Name", "Email", "Phone Number", "Total Savings", "Total Points");
		for (Membership membership : memberships) {
			if(membership instanceof VerifiedMembership)
				System.out.printf("| %-36s | %-15s | %-25s | %-14s | %-13d | %-12d |\n", membership.getId(), membership.getUser().getName(), membership.getUser().getEmail(), membership.getUser().getPhoneNumber(), membership.getTotalSavings(), ((VerifiedMembership) membership).getTotalPoints());
			else
				System.out.printf("| %-36s | %-15s | %-25s | %-14s | %-13d | %-12s |\n", membership.getId(), membership.getUser().getName(), membership.getUser().getEmail(), membership.getUser().getPhoneNumber(), membership.getTotalSavings(), "-");
		}
	}
	
	@Override
	public boolean findIndex(int index) {
		if(index < 1 || index > memberships.size()) return false;
		
		return true;
	}
	
	@Override
	public Membership getByIndex(int index) {
		return memberships.get(index - 1);
	}
	
	public Membership getById(String id) {
		for (Membership membership : memberships) {
			if(membership.getId().equals(id)) return membership;
		}
		
		return null;
	}
	
	public Membership getByEmail(String email) {
		for (Membership membership : memberships) {
			if(membership.getUser().getEmail().equals(email)) return membership;
		}
		
		return null;
	}
	
	public Membership getByPhoneNumber(String phoneNumber) {
		for (Membership membership : memberships) {
			if(membership.getUser().getPhoneNumber().equals(phoneNumber)) return membership;
		}
		
		return null;
	}
	
	@Override
	public int totalData() {
		return memberships.size();
	}
	
	@Override
	public void insert(Object newObject) {
		if(newObject instanceof Membership)
			memberships.add((Membership) newObject);
	}
	
	@Override
	public boolean remove(int index) {
		if(!this.findIndex(index)) return false;
		
		memberships.remove(index);
		return true;
	}
	
	@Override
	public boolean remove(Object object) {
		if(this.getById(((Membership) object).getId()) == null) return false;
		
		memberships.remove(object);
		return true;
	}
}
