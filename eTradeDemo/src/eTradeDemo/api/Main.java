package eTradeDemo.api;

import eTradeDemo.business.concretes.UserManager;
import eTradeDemo.core.concretes.LoggerManagerAdapter;
import eTradeDemo.dataAccess.concretes.AbcUserDao;
import eTradeDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1=new User(1,"Ozan","Polat","ozanpolat@outlook.com","123123123");
		UserManager userManager = new UserManager(new AbcUserDao(), new LoggerManagerAdapter());
		userManager.add(user1);
		
		
		userManager.login("ozanpolat@outlook.com", "123123123");

	}

}
