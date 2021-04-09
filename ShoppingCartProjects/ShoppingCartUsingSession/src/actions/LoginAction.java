package actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.database.User;
import utils.database.baseclass.UserModel;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		HttpSession userSession = req.getSession();
		
		UserModel queryUser = User.findByUsername(username);
		if (queryUser != null) {
			if (queryUser.getPassword().equals(password)) {
				userSession.setAttribute("isLoggedIn", true);
				userSession.setAttribute("currUser", queryUser);
				res.sendRedirect(req.getContextPath()+"");
			} else {
				res.sendRedirect("login");
			}
		} else {
			res.sendRedirect(req.getContextPath()+"/register");
		}

	}

}
