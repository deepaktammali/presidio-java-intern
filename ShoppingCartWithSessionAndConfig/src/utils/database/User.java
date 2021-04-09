package utils.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import utils.DatabaseUtils;
import utils.database.baseclass.UserModel;

public class User extends UserModel {

	static {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			boolean result = dbStatement.execute("CREATE TABLE users(" + "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
					+ "username VARCHAR(30)," + "password VARCHAR(30)," + "flag VARCHAR(12));");
			DatabaseUtils.close();
			System.out.println("Closed");
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
	}

	public User(Integer id, String username, String password, String flag) {
		super(id, username, password, flag);
	}

	public User(String username, String password, String flag) {
		super(username, password, flag);
	}

	public static UserModel findByID(Integer id) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		UserModel queryUser = null;
		try (Statement dbStatement = databaseConnection.createStatement();) {

			ResultSet user = dbStatement.executeQuery("SELECT * FROM users WHERE id=" + id + ";");
			if (user.next()) {
				String username = user.getString("username");
				String password = user.getString("password");
				String flag = user.getString("flag");
				queryUser = new User(id, username, password, flag);
			}

			DatabaseUtils.close();

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return queryUser;
	}
	
	public static UserModel findByUsername(String username) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		UserModel queryUser = null;
		try (Statement dbStatement = databaseConnection.createStatement();) {

			ResultSet user = dbStatement.executeQuery("SELECT * FROM users WHERE username='" + username + "';");
			if (user.next()) {
				Integer id = user.getInt("id");
				String password = user.getString("password");
				String flag = user.getString("flag");
				queryUser = new User(id, username, password, flag);
			}

			DatabaseUtils.close();

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return queryUser;
	}

	public static List<UserModel> findAll() {
		ArrayList<UserModel> queryUsers = new ArrayList<>();
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try (Statement dbStatement = databaseConnection.createStatement();) {

			ResultSet users = dbStatement.executeQuery("SELECT * FROM users");
			while (users.next()) {
				Integer id = users.getInt("id");
				String username = users.getString("username");
				String password = users.getString("password");
				String flag = users.getString("flag");
				queryUsers.add(new User(id, username, password, flag));
			}
			DatabaseUtils.close();

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return queryUsers;
	}

	private static int insertUserWithoutID(UserModel user) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		int i = 0;
		try (Statement dbStatement = databaseConnection.createStatement();) {
			System.out.println("INSERT INTO users(username,password,flag) VALUES('" + user.getUsername() + "','"
					+ user.getPassword() + "','" + user.getFlag() + "');");
			i = dbStatement.executeUpdate("INSERT INTO users(username,password,flag) VALUES('" + user.getUsername() + "','"
					+ user.getPassword() + "','" + user.getFlag() + "');");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
	}

	private static int insertUserWithId(UserModel user) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		int i = 0;
		try (Statement dbStatement = databaseConnection.createStatement();) {
			i = dbStatement.executeUpdate("INSERT INTO users VALUES(" + user.getId() + "," + user.getUsername() + ","
					+ user.getPassword() + "," + user.getFlag() + ");");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
	}

	public static int insertUser(UserModel user) {
		int i =0;
		if (user.getId() != null) {
			i = insertUserWithId(user);
		} else {
			i = insertUserWithoutID(user);
		}
		return i;
	};
	
	public static int updateUser(UserModel user) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			System.out.println("UPDATE users" + " SET username='" + user.getUsername() + "',password='"
					+ user.getPassword() + "',flag='" + user.getFlag() + "'" + " WHERE id=" + user.getId() + ";");
			i = dbStatement.executeUpdate("UPDATE users" + " SET username='" + user.getUsername() + "',password='"
					+ user.getPassword() + "',flag='" + user.getFlag() + "'" + " WHERE id=" + user.getId() + ";");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		
		return i;
	}

	public static int deleteUserById(Integer id) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try(Statement dbStatement = databaseConnection.createStatement();){
			i = dbStatement.executeUpdate("DELETE FROM users"
					+ "WHERE id="+id+";");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		
		return i;
		
	};

	public static int deleteTransaction(UserModel user) {
		if(user.getId()!=null) {
			return deleteUserById(user.getId());
		}
		else {
			int i = 0;
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			try(Statement dbStatement = databaseConnection.createStatement();){
				i = dbStatement.executeUpdate("DELETE FROM users"
						+ "WHERE username="+user.getUsername()+","
								+ "password="+user.getPassword()+","
										+ "flag="+user.getFlag()+";");
				DatabaseUtils.close();
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				e.printStackTrace();
			}
			
			return i;
		}
	};
	
//	public static void main(String[] args) {
//		User user = new User("deepak", "password", "0");
//		User.insertUser(user);
//		System.out.println(User.findByID(1));
//		System.out.println(User.findByUsername("deepak")==null);
//	}

}
