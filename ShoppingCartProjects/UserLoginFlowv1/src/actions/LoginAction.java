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
				if(queryUser.getPassword().equals(password)) {
					queryUser.setFlag("1");
					User.updateUser(queryUser);
					res.getWriter().printf("<form method=\"POST\" action=\"logout\">\r\n"
							+ "		<input name='username' type=\"hidden\" value='%s'/>\r\n"
							+ "		<button type=\"submit\">LogOut</button>\r\n"
							+ "	</form>",queryUser.getUsername());
				}
				else {
					res.sendRedirect("");
				}
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
