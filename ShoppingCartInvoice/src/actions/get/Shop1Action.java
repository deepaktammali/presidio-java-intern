package actions.get;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;

public class Shop1Action implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("In Shop1");
		res.sendRedirect(req.getContextPath()+"/shop1.jsp");
	}
}
