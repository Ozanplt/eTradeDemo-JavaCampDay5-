package eTradeDemo.core.concretes;

import eTradeDemo.core.abstracts.LoggerService;

public class LoggerManagerAdapter implements LoggerService{

	@Override
	public void log(String message) {
		System.out.println("E-Mail sent: "+message);
		
	}

	@Override
	public boolean emailVerification(String email) {
		return true;
	}


}
