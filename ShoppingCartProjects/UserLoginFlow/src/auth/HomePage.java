package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utils.database.User;
import utils.database.baseclass.UserModel;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/homepage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public HomePage() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel user = (UserModel) request.getAttribute("user");
		
		PrintWriter out = response.getWriter();
		System.out.println(user.getUsername());
		response.setContentType("text/html");
		System.out.println();
		out.printf("<form method=\"POST\" action=\"logout\">\r\n"
				+ "		<input name=\"username\" type=\"hidden\" value='%s'/>\r\n"
				+ "		<button type=\"submit\">LogOut</button>\r\n"
				+ "	</form>",user.getUsername());
	}

}
