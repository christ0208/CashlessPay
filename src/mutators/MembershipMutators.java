package mutators;

public interface MembershipMutators {
	public void setName(String name);
	public void setEmail(String email);
	public void setPhoneNumber(String phoneNumber);
	public void decreaseTotalSavings(Integer amount);
	public void increaseTotalSavings(Integer amount);
}
