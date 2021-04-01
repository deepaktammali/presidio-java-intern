package jdbcdemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementsJDBC {
	public static void main(String[] args) {
		
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try
		{
			
			Statement sqlStatement = databaseConnection.createStatement();
			sqlStatement.execute("CREATE TABLE cricketers(id INT,name VARCHAR(20),role VARCHAR(10));");
			
			sqlStatement.execute("INSERT INTO cricketers VALUES(1,'Virat Kohli','Batsmen');");
			sqlStatement.execute("INSERT INTO cricketers VALUES(2,'ABD','Batsmen')");
			
			databaseConnection.close();
			
		} catch (SQLException e) {
			try {
				databaseConnection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}
