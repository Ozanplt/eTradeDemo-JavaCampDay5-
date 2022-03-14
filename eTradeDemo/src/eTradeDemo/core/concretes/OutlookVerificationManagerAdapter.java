package eTradeDemo.core.concretes;

import eTradeDemo.core.abstracts.VerificationService;
import eTradeDemo.outlookVerification.OutlookVerificationManager;

public class OutlookVerificationManagerAdapter implements VerificationService{

	@Override
	public boolean emailIsValid(String email) {
		OutlookVerificationManager outlookVerificationManager = new OutlookVerificationManager();
		
		return outlookVerificationManager.outlookVerification(email);
	}

}
