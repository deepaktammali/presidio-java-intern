package actions.get;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
import utils.AuthHelper;

public class RegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
			res.sendRedirect(req.getContextPath()+"/register.jsp");
	}

}
