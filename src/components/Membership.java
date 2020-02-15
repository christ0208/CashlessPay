package components;

import accessors.MembershipAccessors;
import mutators.MembershipMutators;
import services.GenerateUUIDService;

public class Membership implements MembershipAccessors, MembershipMutators{
	protected String id;
	protected User user;
	protected Integer totalSavings;
	
	public Membership() {
	}
	
	public Membership(String name, String email, String phoneNumber) {
		this.user = new User(name, email, phoneNumber);
		
		this.id = GenerateUUIDService.generate();
		this.totalSavings = 100000;
	}
	
	public Membership(Membership membership) {
		this.user = new User(membership.getUser().getName(), membership.getUser().getEmail(), membership.getUser().getPhoneNumber());
		
		this.id = membership.getId();
		this.totalSavings = membership.getTotalSavings();
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	public User getUser() {
		return this.user;
	}
	@Override
	public Integer getTotalSavings() {
		return this.totalSavings;
	}
	
	@Override
	public void decreaseTotalSavings(Integer amount) {
		this.totalSavings -= amount;
	}
	@Override
	public void increaseTotalSavings(Integer amount) {
		this.totalSavings += amount;
	}
	
}
