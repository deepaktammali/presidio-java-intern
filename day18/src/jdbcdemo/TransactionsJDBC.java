package jdbcdemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionsJDBC {
	public static void main(String[] args) {

		Savepoint savePoint = null;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();

		try (Statement dbStatement = databaseConnection.createStatement();) {

			databaseConnection.setAutoCommit(false);

			dbStatement.execute("CREATE TABLE cricketers(id INT,name VARCHAR(20),role VARCHAR(10));");

			dbStatement.execute("INSERT INTO cricketers VALUES(1,'Virat Kohli','Batsmen');");
			savePoint = databaseConnection.setSavepoint();
			
			dbStatement.execute("INSERT INTO cricketers VALUES(2,'ABD','Batsmen')");
			savePoint = databaseConnection.setSavepoint();
			
			dbStatement.execute("INSERT INTO cricketerss VALUES(3,'Moeen Ali','Alrounder')");
			savePoint = databaseConnection.setSavepoint();

			dbStatement.execute("INSERT INTO cricketers VALUES(4,'Steve Smith','Batsmen')");
			savePoint = databaseConnection.setSavepoint();

			dbStatement.execute("INSERT INTO cricketers VALUES(5,'Bhuvaneshwar','Bowler')");

			databaseConnection.commit();
			databaseConnection.close();

		} catch (SQLException e) {
				DatabaseUtils.close(e, savePoint);

			e.printStackTrace();
		}

	}
}
