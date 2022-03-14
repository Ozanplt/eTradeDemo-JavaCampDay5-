package eTradeDemo.business.concretes;

import java.util.List;


import eTradeDemo.business.abstracts.UserService;
import eTradeDemo.core.abstracts.LoggerService;
import eTradeDemo.core.concretes.LoggerManagerAdapter;
import eTradeDemo.core.concretes.OutlookVerificationManagerAdapter;
import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	private LoggerService loggerService;

	public UserManager(UserDao userDao, LoggerService loggerService) {
		super();
		this.userDao = userDao;
		this.loggerService = loggerService;
	}

	@Override
	public void add(User user) {
		if (userInformationIsEmpty(user) && userCharacterLength(user) && userIsRegistered(user)
				&& emailVerificationControl(user.getEmail())) {
			loggerService.log("Verification email was sent. Please verify it");
			if (loggerService.emailVerification(user.getEmail())) {
				loggerService.log("Registered to system successfully");
				userDao.add(user);
			} else {
				loggerService.log("Registration is failed");

			}
		}
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void login(String email, String password) {
		boolean check = false;
		for (User user : userDao.getAll()) {
			if (user.getEmail() == email && user.getPassword() == password) {
				check = true;
				break;
			}
		}
		if (check) {
			System.out.println("Logged to system. Email and Password are matched");
		} else {
			System.out.println("Email or password is incorrect");
		}

	}

	boolean userInformationIsEmpty(User user) {
		if (!user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		} else {
			System.out.println("Please fill email and password");
			return false;
		}
	}

	boolean userCharacterLength(User user) {
		if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2 && user.getPassword().length() >= 6) {
			return true;
		} else {
			System.out.println(
					"Firstname and Lastname must be 2 character at least. Password must be 6 character at least");
			return false;
		}
	}

	boolean userIsRegistered(User user) {
		boolean control = false;
		for (User userCounter : userDao.getAll()) {
			if (userCounter.getEmail() == user.getEmail()) {
				control = true;
			}
		}

		if (control) {
			System.out.println("Email was used before");
			return false;
		} else {
			return true;
		}

	}

	boolean emailVerificationControl(String email) {
		OutlookVerificationManagerAdapter outlookVerificationManagerAdapter = new OutlookVerificationManagerAdapter();
		LoggerManagerAdapter loggerManagerAdapter = new LoggerManagerAdapter();
		boolean verificationTool = outlookVerificationManagerAdapter.emailIsValid(email);
		boolean loggerTool = loggerManagerAdapter.emailVerification(email);

		if (loggerTool == true && verificationTool) {
			System.out.println("verification is successfull");
			return true;
		} else {
			System.out.println("verification is failed");
			return false;
		}
	}

}
