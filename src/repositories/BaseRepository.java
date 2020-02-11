package repositories;

import components.Membership;

public abstract class BaseRepository {
	
	public abstract void printAll();
	public abstract boolean findIndex(int index);
	public abstract Membership getByIndex(int index);
	public abstract Membership getById(String id);
	public abstract int totalData();
	public abstract void insert(Object newObject);
	public abstract boolean remove(int index);
	public abstract boolean remove(Object object);

}
