package actions;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.database.User;
import utils.database.baseclass.UserModel;

public class LogoutAction implements Action {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		
		System.out.println("Logout");
		UserModel queryUser = User.findByUsername(username);
		if(queryUser!=null) {
			queryUser.setFlag("0");
			User.updateUser(queryUser);
		}
		try {
			res.sendRedirect("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
