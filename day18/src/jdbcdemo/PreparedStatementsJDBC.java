package jdbcdemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementsJDBC {
	public static void main(String[] args) throws SQLException {
		
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertStudentString = "INSERT INTO students VALUES(?,?)";
		try(
			Statement dbStatement = databaseConnection.createStatement();
			PreparedStatement insertStudent = databaseConnection.prepareStatement(insertStudentString);
				)
		{
			dbStatement.execute("CREATE TABLE students(roll INT,name VARCHAR(20));");
			
			insertStudent.setInt(1, 1);
			insertStudent.setString(2, "Deepak");
			insertStudent.executeUpdate();
			
			insertStudent.setInt(1,2);
			insertStudent.setString(2,"Kohli");
			insertStudent.executeUpdate();
			
			DatabaseUtils.close();
			
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
	}
}
