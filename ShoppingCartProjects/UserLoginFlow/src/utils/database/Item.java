package utils.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseUtils;
import utils.database.baseclass.ItemDataModel;

public class Item extends ItemDataModel {

	static {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();

		try (Statement dbStatement = databaseConnection.createStatement();) {

			dbStatement.execute(
					"CREATE TABLE items(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,name VARCHAR(30),price DOUBLE,description VARCHAR(255));");

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Table Already Exists");
		}

	}

	public Item(String name, double price, String description) {
		super(name, price, description);
	}

	public Item(Integer id, String name, double price, String description) {
		super(id, name, price, description);
	}

	@Override
	public String toString() {
		return ("Product \nName : " + name + "\nPrice : " + price + "\nDescription : " + description + "\n");
	}
	
	public static ItemDataModel findByName(String name) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		Item queryItem = null;
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet items = dbStatement.executeQuery("SELECT * FROM items WHERE name = '" + name + "';");
			if (items.next()) {
				int id = items.getInt("id");
				Double price = items.getDouble("price");
				String description = items.getString("description");
				queryItem = new Item(id, name, price, description);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding item : " + e.getMessage());
			e.printStackTrace();
		}

		return queryItem;
	}

	public static ItemDataModel findByID(Integer itemId) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		Item queryItem = null;
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet items = dbStatement.executeQuery("SELECT * FROM items WHERE id = " + itemId);
			if (items.next()) {
				String name = items.getString("name");
				Double price = items.getDouble("price");
				String description = items.getString("description");
				queryItem = new Item(itemId, name, price, description);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding item : " + e.getMessage());
			e.printStackTrace();
		}

		return queryItem;
	}

	public static List<ItemDataModel> findAll() {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		Item queryItem = null;
		List<ItemDataModel> items = new ArrayList<>();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet itemCursor = dbStatement.executeQuery("SELECT * FROM items;");
			if (itemCursor.next()) {
				Integer id = itemCursor.getInt("id");
				String name = itemCursor.getString("name");
				Double price = itemCursor.getDouble("price");
				String description = itemCursor.getString("description");
				queryItem = new Item(id, name, price, description);
				items.add(queryItem);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding items : " + e.getMessage());
			e.printStackTrace();
		}

		return items;
	};
	
	private static int saveWithId(ItemDataModel item) throws SQLException {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertItemWithIdString = "INSERT INTO items VALUES(?,?,?,?)";
		try (PreparedStatement insertItemWithId = databaseConnection.prepareStatement(insertItemWithIdString);) {
			insertItemWithId.setInt(1, item.getId());
			insertItemWithId.setString(2, item.getName());
			insertItemWithId.setDouble(3, item.getPrice());
			insertItemWithId.setString(4, item.getDescription());
			i = insertItemWithId.executeUpdate();
			DatabaseUtils.close();
		}
		return i;
	}

	private static int saveWithoutId(ItemDataModel item) throws SQLException {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertItemWithoutIdString = "INSERT INTO items(name,price,description) VALUES(?,?,?)";
		try (PreparedStatement insertItemWithoutId = databaseConnection.prepareStatement(insertItemWithoutIdString);) {

			insertItemWithoutId.setString(1, item.getName());
			insertItemWithoutId.setDouble(2, item.getPrice());
			insertItemWithoutId.setString(3, item.getDescription());
			i = insertItemWithoutId.executeUpdate();
			DatabaseUtils.close();
		}
		
		return i;
		
	}

	public static int insertItem(ItemDataModel item) {
		int i =0;
		try {
			if (item.getId() != null) {
				i = saveWithId(item);
			} else {
				i = saveWithoutId(item);
			}
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Writing to database failed : " + e.getMessage());
			e.printStackTrace();
		}
		
		return i;
	};

	public static int updateItem(ItemDataModel item) {
		
		
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String updateItemString = "UPDATE items\r\n"
				+ "		SET name = ?, price = ?, description=?\r\n"
				+ "		WHERE id=?;";
		try (PreparedStatement updateItem = databaseConnection
				.prepareStatement(updateItemString);) {
			
			updateItem.setString(1, item.getName());
			updateItem.setDouble(2, item.getPrice());
			updateItem.setString(3, item.getDescription());
			updateItem.setInt(4, item.getId());
			i = updateItem.executeUpdate();
			DatabaseUtils.close();
			
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
		
	};

	public static int deleteItemByID(Integer itemId) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String deleteItemString = "DELETE FROM customers WHERE id=?;";
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

	public static int deleteItem(ItemDataModel item) {
		return deleteItemByID(item.getId());
	};

}
