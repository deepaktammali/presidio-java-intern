public class Q6{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.next();
		String password = scanner.next();
		User user = new User(userName,password);
		System.out.printf("The password for username %s is %s",user.getUsername(),user.getPassword()).println();
		scanner.close();
	}
}

class User{
	private String userName;
	private String password=null;
	Password(String userName,String password){
		this.userName = userName;
		this.password = password;
	}

	Password(String userName){
		this.userName = userName;
	}

	public String getUsername(){
		return this.userName;
	}

	public void setUsername(String userName){
		this.userName = userName;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}
}