package handlers;

import commands.CallbackInterface;
import repositories.MembershipRepository;

public class ShowAllMembershipHandler implements CallbackInterface{
	private MembershipRepository membershipRepo = MembershipRepository.getInstance();

	@Override
	public void execute() {
		membershipRepo.printAll();
	}

}
