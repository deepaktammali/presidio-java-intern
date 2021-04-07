package actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.database.User;
import utils.database.baseclass.UserModel;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserModel queryUser = User.findByUsername(username);
		try {
			if(queryUser==null) {
				User.insertUser(queryUser);
			}
			res.sendRedirect("");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
