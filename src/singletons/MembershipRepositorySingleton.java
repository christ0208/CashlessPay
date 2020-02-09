package singletons;

import java.util.Vector;

import components.Membership;

public class MembershipRepositorySingleton {
	private static Vector<Membership> memberships = new Vector<Membership>();
	
	public static Vector<Membership> getInstance(){
		return memberships;
	}
}
