package jdbcdemo;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMetadata {
	public static void main(String[] args) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		
		DatabaseMetaData databaseMetadata;
		try {
			databaseMetadata = databaseConnection.getMetaData();
			System.out.println("Database Version : "+databaseMetadata.getDatabaseMajorVersion());
			System.out.println("Database : "+databaseMetadata.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}	
