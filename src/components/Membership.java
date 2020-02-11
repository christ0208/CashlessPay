package components;

import accessors.MembershipAccessors;
import mutators.MembershipMutators;
import services.GenerateUUIDService;

public class Membership implements MembershipAccessors, MembershipMutators{
	protected String id;
	protected String name;
	protected String email;
	protected String phoneNumber;
	protected Integer totalSavings;
	
	public Membership() {
	}
	
	public Membership(String name, String email, String phoneNumber) {
		this.id = GenerateUUIDService.generate();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.totalSavings = 100000;
	}
	
	public Membership(Membership membership) {
		this.id = membership.getId();
		this.name = membership.getName();
		this.email = membership.getEmail();
		this.phoneNumber = membership.getPhoneNumber();
		this.totalSavings = membership.getTotalSavings();
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String getEmail() {
		return this.email;
	}
	@Override
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	@Override
	public Integer getTotalSavings() {
		return this.totalSavings;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
