package actions.post;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.Action;
import utils.AuthHelper;
import utils.database.User;
import utils.database.baseclass.UserModel;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession userSession  = req.getSession();
		if(AuthHelper.isUserAuthenticated(req)) {
			userSession.invalidate();
			res.sendRedirect(req.getContextPath()+"/index.jsp");
		}
		else {
			res.sendRedirect(req.getContextPath() + "/login.html");
		}
	}

}
