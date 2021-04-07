package actions;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.database.User;
import utils.database.baseclass.UserModel;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserModel queryUser = User.findByUsername(username);
		try {
			if(queryUser!=null) {
				if(queryUser.getPassword()==password) {
					queryUser.setFlag("1");
					User.updateUser(queryUser);
					res.sendRedirect("home.html");
				}
					res.sendRedirect("register.html");
			}
			else {
				res.sendRedirect("register.html");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;	
	}

}
