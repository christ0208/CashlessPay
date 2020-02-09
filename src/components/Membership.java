package components;

import accessors.MembershipAccessors;
import mutators.MembershipMutators;

public class Membership implements MembershipAccessors, MembershipMutators{
	private String name;
	private String email;
	private String phoneNumber;
	private Integer totalSavings;
	
	public Membership() {
	}
	
	public Membership(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return this.phoneNumber;
	}
	@Override
	public Integer getTotalSavings() {
		// TODO Auto-generated method stub
		return this.totalSavings;
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}
	@Override
	public void setPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		this.phoneNumber = phoneNumber;
	}
	@Override
	public void decreaseTotalSavings(Integer amount) {
		// TODO Auto-generated method stub
		this.totalSavings -= amount;
	}
	@Override
	public void increaseTotalSavings(Integer amount) {
		// TODO Auto-generated method stub
		this.totalSavings += amount;
	}
	
	
}
