package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utils.database.User;
import utils.database.baseclass.UserModel;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Login() {
        
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserModel queryUser = User.findByUsername(username);
		if(queryUser==null) {
			response.sendRedirect("register.html");
		}
		
		else {
			queryUser.setFlag("1");
			User.updateUser(queryUser);
//			System.out.println(queryUser.setFlag(password););
			request.setAttribute("user", queryUser);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homepage");
			requestDispatcher.forward(request, response);
		}
	
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}
