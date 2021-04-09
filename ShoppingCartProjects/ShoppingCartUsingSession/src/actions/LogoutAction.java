package actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AuthHelper;
import utils.database.User;
import utils.database.baseclass.UserModel;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession userSession  = req.getSession();
		if(AuthHelper.isUserAuthenticated(req)) {
			userSession.invalidate();
			res.sendRedirect(req.getContextPath()+"");
		}
		else {
			res.sendRedirect("login");
		}
	}

}
