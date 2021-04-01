package jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.ResultSetMetaData;


public class MySQLJDBCDemo {
	public static void main(String[] args) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
//		System.out.println(databaseConnection);
		
		try {
			ResultSet students = databaseConnection.createStatement().executeQuery("SELECT * from students");
			
			ResultSetMetaData studentsMetadata = students.getMetaData();
			
			for(int i=1;i<=studentsMetadata.getColumnCount();i++) {
				System.out.println(studentsMetadata.getColumnName(i));
			}
			
			
			while(students.next()) {
				System.out.println("Roll Number : "+students.getInt("roll"));
				System.out.println("Name : "+students.getString("name"));
			}
			
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		
		
		
	}
}
