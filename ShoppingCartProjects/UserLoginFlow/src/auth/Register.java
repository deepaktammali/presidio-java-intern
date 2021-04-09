package auth;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utils.database.User;
import utils.database.baseclass.UserModel;


/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection databaseConnection;

    /**
     * Default constructor. 
     */
    public Register() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserModel queryUser = User.findByUsername(username);
		if(queryUser==null) {
			UserModel newUser = new User(username,password,"0");
			User.insertUser(newUser);
			response.sendRedirect("index.html");
		}
	}

}
