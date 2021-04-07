package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Properties;

public class DatabaseUtils {

	private static ThreadLocal<Connection> databaseConnectionLocal = new ThreadLocal<Connection>();
	private static String username;
	private static String password;
	private static String databaseURI;
	
	static {
//		FileInputStream dbConfigFileStream = new FileInputStream("/db.properties");
		try  {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Properties dbConfigProperties = new Properties();
//			dbConfigProperties.load(dbConfigFileStream);

//			username = dbConfigProperties.getProperty("USERNAME");
//			password = dbConfigProperties.getProperty("PASSWORD");
//			databaseURI = dbConfigProperties.getProperty("DATABASE_URI")+dbConfigProperties.getProperty("DATABASE_NAME");
//			
			username= "root";
			password= "root";
			databaseURI = "jdbc:mysql://localhost/"+"billing";
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	public static Connection getDatabaseConnection() {
		if ((databaseConnectionLocal.get()) == null) {
			try {
				databaseConnectionLocal.set(DriverManager.getConnection(databaseURI, username, password));
				databaseConnectionLocal.get().setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

//		Connection databaseConnection = databaseConnectionLocal.get();
//		
//		if(databaseConnection.isClosed()) {
//			
//		}
//		
		return databaseConnectionLocal.get();
	}

	public static void close(Exception e, Savepoint sp) {
		Connection databaseConnection = databaseConnectionLocal.get();

		
		try {
			if(sp!=null) {
				databaseConnection.rollback(sp);
			}
			else {
				if(e!=null) {
					databaseConnection.rollback();
				}
			}
			
			databaseConnection.commit();
			databaseConnection.close();
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		databaseConnectionLocal.remove();
		
	}

	public static void close(Exception e){
		close(e, null);
	}

	public static void close(){
		close(null, null);
	}

}
