package eTradeDemo.business.abstracts;

import java.util.List;

import eTradeDemo.entities.concretes.User;

public interface UserService {
	void add(User user);

	void delete(User user);

	void update(User user);

	List<User> getAll();

	void login(String email, String password);
}
