package actions.get;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import actions.Action;
import utils.AuthHelper;

public class CartAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		if(!AuthHelper.isUserAuthenticated(req)) {
//			res.sendRedirect(req.getContextPath()+"/login.jsp");
//			return;
//		}
		
		res.sendRedirect(req.getContextPath()+"/cart.jsp");
	}

}
