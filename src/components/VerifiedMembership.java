package components;

import java.util.Vector;

import accessors.VerifiedMembershipAccessors;
import mutators.VerifiedMembershipMutators;

public class VerifiedMembership extends Membership implements VerifiedMembershipAccessors, VerifiedMembershipMutators{
	private Integer totalPoints;

	public VerifiedMembership(Vector<User> users) {
		super(users);
	}
	
	public VerifiedMembership(Membership membership) {
		super(membership);
		this.totalPoints = 0;
	}
	
	@Override
	public Integer getTotalPoints() {
		return this.totalPoints;
	}
	@Override
	public Integer convertTotalPointsToTotalPrice() {
		return this.totalPoints * 100;
	}

	@Override
	public void increaseTotalPoints(Integer addedSavings) {
		this.totalPoints += (int) Math.round(addedSavings * 0.5 / 100);
	}
	@Override
	public void decreaseTotalPoints(Integer price) {
		this.totalPoints -= Math.round(price / 100);
	}
	@Override
	public void increaseTotalSavings(Integer amount) {
		// TODO Auto-generated method stub
		super.increaseTotalSavings(amount);
		this.increaseTotalPoints(amount);
	}
	
}
