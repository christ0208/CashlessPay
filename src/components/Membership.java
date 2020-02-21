package components;

import java.util.Vector;

import accessors.MembershipAccessors;
import mutators.MembershipMutators;
import services.GenerateUUIDService;

public class Membership implements MembershipAccessors, MembershipMutators{
	protected String id;
	protected Vector<User> users;
	protected Integer totalSavings;
	
	public Membership() {
	}
	
	public Membership(Vector<User> users) {
		this.users = users;
		
		this.id = GenerateUUIDService.generate();
		this.totalSavings = 100000;
	}
	
	public Membership(Membership membership) {
		this.users = membership.users;
		
		this.id = membership.getId();
		this.totalSavings = membership.getTotalSavings();
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	public Vector<User> getUsers() {
		return this.users;
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
