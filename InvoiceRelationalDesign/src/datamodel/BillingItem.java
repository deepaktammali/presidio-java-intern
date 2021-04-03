package datamodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import datamodel.baseclass.BillingItemDataModel;
import datamodel.baseclass.ItemDataModel;
import utils.DatabaseUtils;

public class BillingItem extends BillingItemDataModel {

	static {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();

		try (Statement dbStatement = databaseConnection.createStatement();) {

			dbStatement.execute(
					"CREATE TABLE billing_items(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,invoiceId INT NOT NULL,itemId INT NOT NULL,quantity INT NOT NULL);");

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Table Already Exists");
		}

	}

	public BillingItem(Integer id, Integer invoiceId, Integer itemId, Integer quantity) {
		super(id, invoiceId, itemId, quantity);
	}

	public BillingItem(Integer invoiceId, Integer itemId, Integer quantity) {
		super(invoiceId, itemId, quantity);
	}

	public BillingItemDataModel findByID(Integer billingItemId) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		BillingItemDataModel queryBillingItem = null;
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet billingItemsCursor = dbStatement
					.executeQuery("SELECT * FROM billing_items WHERE id = " + billingItemId);
			if (billingItemsCursor.next()) {
				Integer id = billingItemsCursor.getInt("id");
				Integer invoiceId = billingItemsCursor.getInt("invoiceId");
				Integer itemId = billingItemsCursor.getInt("itemId");
				Integer quantity = billingItemsCursor.getInt("quantity");
				queryBillingItem = new BillingItem(id, invoiceId, itemId, quantity);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding billing item : " + e.getMessage());
			e.printStackTrace();
		}

		return queryBillingItem;
	}

	public static List<BillingItemDataModel> findAll() {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		BillingItemDataModel queryBillingItem = null;
		List<BillingItemDataModel> billingItems = new ArrayList<>();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet billingItemsCursor = dbStatement.executeQuery("SELECT * FROM billing_items;");
			if (billingItemsCursor.next()) {
				Integer id = billingItemsCursor.getInt("id");
				Integer invoiceId = billingItemsCursor.getInt("invoiceId");
				Integer itemId = billingItemsCursor.getInt("itemId");
				Integer quantity = billingItemsCursor.getInt("quantity");
				queryBillingItem = new BillingItem(id, invoiceId, itemId, quantity);
				billingItems.add(queryBillingItem);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding billing items : " + e.getMessage());
			e.printStackTrace();
		}

		return billingItems;
	};

	private static int insertBillingItemWithId(BillingItemDataModel billingItem) throws SQLException {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertBillingItemWithIdString = "INSERT INTO billing_items VALUES(?,?,?,?)";
		try (PreparedStatement insertBillingItemWithId = databaseConnection.prepareStatement(insertBillingItemWithIdString);) {
			insertBillingItemWithId.setInt(1, billingItem.getId());
			insertBillingItemWithId.setInt(2, billingItem.getInvoiceId());
			insertBillingItemWithId.setInt(3, billingItem.getItemId());
			insertBillingItemWithId.setInt(4, billingItem.getQuantity());
			i = insertBillingItemWithId.executeUpdate();
			DatabaseUtils.close();
		}
		return i;
	}

	private static int insertBillingItemWithoutId(BillingItemDataModel billingItem) throws SQLException {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertBillingItemWithoutIdString = "INSERT INTO billing_items(invoiceId,itemId,quantity) VALUES(?,?,?)";
		try (PreparedStatement insertBillingItemWithoutId = databaseConnection
				.prepareStatement(insertBillingItemWithoutIdString);) {

			insertBillingItemWithoutId.setInt(1, billingItem.getInvoiceId());
			insertBillingItemWithoutId.setInt(2, billingItem.getItemId());
			insertBillingItemWithoutId.setInt(3, billingItem.getQuantity());
			i = insertBillingItemWithoutId.executeUpdate();
			DatabaseUtils.close();
		}

		return i;

	}

	public static int insertBillingItem(BillingItemDataModel billingItem) {
		int i = 0;
		try {
			if (billingItem.getId() != null) {
				i = insertBillingItemWithId(billingItem);
			} else {
				i = insertBillingItemWithoutId(billingItem);
			}
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Writing to database failed : " + e.getMessage());
			e.printStackTrace();
		}

		return i;
	};

	public int updateBillingItem(BillingItemDataModel billingItem) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String updateBillingItemString = "UPDATE billing_items\r\n"
				+ "		SET invoiceId = ?, itemId = ?, quantity=?\r\n"
				+ "		WHERE id=?;";
		try (PreparedStatement updateBillingItem = databaseConnection
				.prepareStatement(updateBillingItemString);) {
			
			updateBillingItem.setInt(1, billingItem.getId());
			updateBillingItem.setInt(2, billingItem.getInvoiceId());
			updateBillingItem.setInt(3, billingItem.getItemId());
			updateBillingItem.setInt(4, billingItem.getQuantity());
			i = updateBillingItem.executeUpdate();
			DatabaseUtils.close();
			
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
	};

	public int deleteBillingItemByID(Integer id) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String deleteItemString = "DELETE FROM billing_items WHERE id=?;";
		try (PreparedStatement deleteItem = databaseConnection
				.prepareStatement(deleteItemString);) {
			deleteItem.setInt(1, itemId);
			i = deleteItem.executeUpdate();
			DatabaseUtils.close();
			
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
	};

	public int deleteBillingItem(BillingItemDataModel billingItem) {
		if(billingItem.getId()!=null) {
			return deleteBillingItemByID(billingItem.getId());
		}
		else {
			int i = 0;
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			try(Statement dbStatement = databaseConnection.createStatement();){
				i = dbStatement.executeUpdate("DELETE FROM billing_items"
						+ "WHERE invoiceId="+billingItem.getInvoiceId()+","
								+ "itemId="+billingItem.getItemId()+","
										+ "quantity="+billingItem.getQuantity()+";");
				DatabaseUtils.close();
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				e.printStackTrace();
			}
			
			return i;
		}
	};
}
