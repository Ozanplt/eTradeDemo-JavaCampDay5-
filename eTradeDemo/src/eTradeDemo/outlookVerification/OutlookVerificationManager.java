package eTradeDemo.outlookVerification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OutlookVerificationManager {
	public boolean outlookVerification(String outlook) {
	
			Pattern pattern = Pattern.compile(".@outlook.com");// compile methodu ile istediğimiz düzeni burada
																	// oluşturuyoruz. Verilen format burada derlenir.
			Matcher matcher = pattern.matcher(outlook); // eşleşmeyi kontrol için Machter methodunu kullanıyoruz
			if (matcher.find()) {
				return true;
			} else {
				return false;
			}

	}
}
