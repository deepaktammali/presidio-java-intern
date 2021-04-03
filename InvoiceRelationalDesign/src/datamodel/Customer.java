package datamodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datamodel.baseclass.CustomerDataModel;
import utils.DatabaseUtils;

public class Customer extends CustomerDataModel {
	static {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();

		try (Statement dbStatement = databaseConnection.createStatement();) {

			dbStatement.execute(
					"CREATE TABLE customers(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,name VARCHAR(30),mobilenumber VARCHAR(12),address VARCHAR(255));");

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Table Already Exists");
		}

	}

	private Customer(int id, String name, String mobileNumber, String address) {
		super(id, name, mobileNumber, address);
	}

	private Customer(String name, String mobileNumber, String address) {
		super(name, mobileNumber, address);
	}

	public CustomerDataModel findByID(Integer customerId) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		Customer queryCustomer = null;
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet customerCursor = dbStatement.executeQuery("SELECT * FROM customers WHERE id = " + id);
			if (customerCursor.next()) {
				String name = customerCursor.getString("name");
				String mobilenumber = customerCursor.getString("mobilenumber");
				String address = customerCursor.getString("address");
				queryCustomer = new Customer(id, name, mobilenumber, address);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding customer : " + e.getMessage());
			e.printStackTrace();
		}

		return queryCustomer;
	}

	public List<CustomerDataModel> findAll() {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		Customer queryCustomer = null;
		List<CustomerDataModel> customers = new ArrayList<>();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet customerCursor = dbStatement
					.executeQuery("SELECT * FROM customers");
			if (customerCursor.next()) {
				String name = customerCursor.getString("name");
				String mobilenumber = customerCursor.getString("mobilenumber");
				String address = customerCursor.getString("address");
				queryCustomer = new Customer(id, name, mobilenumber, address);
				customers.add(queryCustomer);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding customer : " + e.getMessage());
			e.printStackTrace();
		}

		return customers;
	}

	private static int insertWithId(CustomerDataModel customer) throws SQLException {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertCustomerStringWithId = "INSERT INTO customers VALUES(?,?,?,?)";
		try (PreparedStatement insertCustomerWithId = databaseConnection
				.prepareStatement(insertCustomerStringWithId);) {
			insertCustomerWithId.setInt(1, customer.getId());
			insertCustomerWithId.setString(2, customer.getName());
			insertCustomerWithId.setString(3, customer.getMobileNumber());
			insertCustomerWithId.setString(4, customer.getAddress());
			i = insertCustomerWithId.executeUpdate();
			DatabaseUtils.close();
		}
		return i;
	}

	private static int insertWithoutId(CustomerDataModel customer) throws SQLException {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertCustomerStringWithoutId = "INSERT INTO customers(name,mobilenumber,address) VALUES(?,?,?)";
		try (PreparedStatement insertCustomerWithoutId = databaseConnection
				.prepareStatement(insertCustomerStringWithoutId);) {

			insertCustomerWithoutId.setString(1, customer.getName());
			insertCustomerWithoutId.setString(2, customer.getMobileNumber());
			insertCustomerWithoutId.setString(3, customer.getAddress());
			i = insertCustomerWithoutId.executeUpdate();
			DatabaseUtils.close();
		}
		return i;
	}

	public static int insertCustomer(CustomerDataModel customer) {
		int i = 0;
		try {

			if (customer.getId() != null) {
				i = insertWithId(customer);
			} else {
				i = insertWithoutId(customer);
			}

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Writing to database failed : " + e.getMessage());
			e.printStackTrace();
		}
		return i;
	}

	public static int updateCustomer(CustomerDataModel customer) {
		
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String updateCustomerString = "UPDATE customers\r\n"
				+ "		SET name = ?, mobilenumber = ?, address=?\r\n"
				+ "		WHERE id=?;";
		try (PreparedStatement updateCustomer = databaseConnection
				.prepareStatement(updateCustomerString);) {
			
			updateCustomer.setString(1, customer.getName());
			updateCustomer.setString(2, customer.getMobileNumber());
			updateCustomer.setString(3, customer.getAddress());
			updateCustomer.setInt(4, customer.getId());
			i = updateCustomer.executeUpdate();
			DatabaseUtils.close();
			
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
		
		
	}

	public static int deleteCustomerByID(Integer customerId) {
		
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String deleteCustomerString = "DELETE FROM customers WHERE id=?;";
		try (PreparedStatement deleteCustomer = databaseConnection
				.prepareStatement(deleteCustomerString);) {
			deleteCustomer.setInt(1, customerId);
			i = deleteCustomer.executeUpdate();
			DatabaseUtils.close();
			
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
		
	}

	public static int deleteCustomer(CustomerDataModel customer) {
		return deleteCustomerByID(customer.getId());
	}

}
