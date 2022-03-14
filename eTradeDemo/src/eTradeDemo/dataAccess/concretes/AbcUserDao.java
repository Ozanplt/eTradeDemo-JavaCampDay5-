package eTradeDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.entities.concretes.User;

public class AbcUserDao implements UserDao{
	List<User> users;
	

	public AbcUserDao() {
		users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullanici eklendi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("Kullanici silindi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public void update(User user) {
		//şuan simülasyon, güncellenecek.
		System.out.println("Kullanici güncellendi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
