package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthHelper {
	public static boolean isUserAuthenticated(HttpServletRequest req) {
		HttpSession userSession = req.getSession();
		Boolean isLoggedIn ;
		if((isLoggedIn = (Boolean) userSession.getAttribute("isLoggedIn"))!=null) {
			return isLoggedIn;
		}
		return false;
	}
}
