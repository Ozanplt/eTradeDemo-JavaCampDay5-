package eTradeDemo.dataAccess.abstracts;

import java.util.List;

import eTradeDemo.entities.concretes.User;

public interface UserDao {
	void add(User user);

	void delete(User user);

	void update(User user);

	public List<User> getAll();
}
