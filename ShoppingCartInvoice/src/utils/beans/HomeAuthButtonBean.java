package utils.beans;

import utils.database.baseclass.UserModel;

public class HomeAuthButtonBean {
	
	private Boolean isLoggedIn;
	private UserModel currUser;
	
	public String generateAuthButtonHTML() {

		if(isLoggedIn==null){
			return ("<div><button class=\"ui primary button\"><a class='item' style='padding:0;margin:0' href='login?action=getLogin'>Login</a></button>\r\n"
					+ "<button class=\"ui primary button\"><a class='item' style='padding:0;margin:0' href='register?action=getRegister'>Register</a></button></div>");
		}		
//			return "<div class=\"ui primary button\"><a class='item' style='padding:0;margin:0' href='login?action=getLogin'>Login</a></div>";
//			}
		else{
			if(currUser==null){
				return "<div><button class=\"ui primary button\"><a class='item' style='padding:0;margin:0' href='login?action=getLogin'>Login</a></button>\r\n"
						+ "<button class=\"ui primary button\"><a class='item' style='padding:0;margin:0' href='register?action=getRegister'>Register</a></button></div>";
					}
			else{
				return ("<form style='margin:0;p:0' action='logout' method='POST'>"
						+"<input type='hidden' name='username' value='"+currUser.getUsername()+"' />"
						+"<input type=\"hidden\" name=\"action\" value=\"postLogout\"/>"
						+"<button type='submit' class=\"ui primary button\">Logout</button>"
						+"</form>");
			}
		}
	}
	
	public UserModel getCurrUser() {
		return currUser;
	}


	public void setCurrUser(UserModel currUser) {
		this.currUser = currUser;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
}
