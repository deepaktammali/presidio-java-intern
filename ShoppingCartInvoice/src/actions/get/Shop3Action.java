package actions.get;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;

public class Shop3Action implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.sendRedirect(req.getContextPath()+"/shop3.jsp");
		
	}

}
