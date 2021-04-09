package actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.database.User;
import utils.database.baseclass.UserModel;

public class RegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserModel queryUser = User.findByUsername(username);
			if(queryUser==null) {
				UserModel newUser = new User(username,password,"0");
				User.insertUser(newUser);
			}
			res.sendRedirect(req.getContextPath()+"/login");
	}

}
