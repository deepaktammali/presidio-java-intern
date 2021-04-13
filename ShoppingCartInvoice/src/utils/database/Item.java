package utils.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseUtils;
import utils.database.baseclass.FruitModel;
import utils.database.baseclass.ItemDataModel;

public class Item extends ItemDataModel {

	static {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();

		try (Statement dbStatement = databaseConnection.createStatement();) {

			dbStatement.execute(
					"CREATE TABLE items(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,name VARCHAR(30),price DOUBLE,description VARCHAR(255),imageURL VARCHAR(255),category VARCHAR(20));");

		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Table Already Exists");
		}

	}

	public Item(String name, double price, String description,String imageURL,String category) {
		super(name, price, description,imageURL,category);
	}

	public Item(Integer id, String name, double price, String description,String imageURL,String category) {
		super(id, name, price, description,imageURL,category);
	}

	@Override
	public String toString() {
		return ("Product \nName : " + name + "\nPrice : " + price + "\nDescription : " + description + "\n"+imageURL+"\n");
	}
	
	
	public static ArrayList<Item> findByCategory(String category) {
		
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		Item queryItem = null;
		ArrayList<Item> items = new ArrayList<>();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet itemCursor = dbStatement.executeQuery("SELECT * FROM items WHERE category = '" + category + "';");
			while (itemCursor.next()) {
				Integer id = itemCursor.getInt("id");
				String name = itemCursor.getString("name");
				Double price = itemCursor.getDouble("price");
				String description = itemCursor.getString("description");
				String imageURL = itemCursor.getString("imageURL");
				queryItem = new Item(id, name, price, description,imageURL,category);
				items.add(queryItem);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding items : " + e.getMessage());
			e.printStackTrace();
		}

		return items;	
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
				String imageURL = items.getString("imageURL");
				String category = items.getString("category");
				queryItem = new Item(id, name, price, description,imageURL,category);
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
				String imageURL = items.getString("imageURL");
				String category = items.getString("category");
				queryItem = new Item(itemId, name, price, description,imageURL,category);
			}
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			System.out.println("Error in finding item : " + e.getMessage());
			e.printStackTrace();
		}

		return queryItem;
	}

	public static ArrayList<Item> findAll() {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		Item queryItem = null;
		ArrayList<Item> items = new ArrayList<>();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			ResultSet itemCursor = dbStatement.executeQuery("SELECT * FROM items;");
			while (itemCursor.next()) {
				Integer id = itemCursor.getInt("id");
				String name = itemCursor.getString("name");
				Double price = itemCursor.getDouble("price");
				String description = itemCursor.getString("description");
				String imageURL = itemCursor.getString("imageURL");
				String category = itemCursor.getString("category");
				queryItem = new Item(id, name, price, description,imageURL,category);
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
		String insertItemWithIdString = "INSERT INTO items VALUES(?,?,?,?,?,?)";
		try (PreparedStatement insertItemWithId = databaseConnection.prepareStatement(insertItemWithIdString);) {
			insertItemWithId.setInt(1, item.getId());
			insertItemWithId.setString(2, item.getName());
			insertItemWithId.setDouble(3, item.getPrice());
			insertItemWithId.setString(4, item.getDescription());
			insertItemWithId.setString(5, item.getImageURL());
			insertItemWithId.setString(6, item.getCategory());
			i = insertItemWithId.executeUpdate();
			DatabaseUtils.close();
		}
		return i;
	}

	private static int saveWithoutId(ItemDataModel item) throws SQLException {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		String insertItemWithoutIdString = "INSERT INTO items(name,price,description,imageURL,category) VALUES(?,?,?,?,?)";
		try (PreparedStatement insertItemWithoutId = databaseConnection.prepareStatement(insertItemWithoutIdString);) {

			insertItemWithoutId.setString(1, item.getName());
			insertItemWithoutId.setDouble(2, item.getPrice());
			insertItemWithoutId.setString(3, item.getDescription());
			insertItemWithoutId.setString(4, item.getImageURL());
			insertItemWithoutId.setString(5, item.getCategory());
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
				+ "		SET name = ?, price = ?, description=?, imageURL=?, category=?\r\n"
				+ "		WHERE id=?;";
		try (PreparedStatement updateItem = databaseConnection
				.prepareStatement(updateItemString);) {
			
			updateItem.setString(1, item.getName());
			updateItem.setDouble(2, item.getPrice());
			updateItem.setString(3, item.getDescription());
			updateItem.setInt(4, item.getId());
			updateItem.setString(5, item.getImageURL());
			updateItem.setString(6, item.getCategory());
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
		String deleteItemString = "DELETE FROM items WHERE id=?;";
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
	
//	public static void main(String[] args) {
//		Item.insertItem(new Item("Tomato",20,"A red fruit","https://sciencebob.com/wp-content/uploads/2015/04/tomato_small.png","fruit"));
//		Item.insertItem(new Item("Papaya",50,"Papaya is a tropical fruit","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Papaya_cross_section_BNC.jpg/1200px-Papaya_cross_section_BNC.jpg","fruit"));
//		Item.insertItem(new Item("Kiwi",40,"It has an oval shape.","https://solidstarts.com/wp-content/uploads/Kiwi_edited-scaled.jpg","fruit"));
//		Item.insertItem(new Item("Banana",20,"A banana is a curved, yellow fruit","https://cdn.mos.cms.futurecdn.net/42E9as7NaTaAi4A6JcuFwG-1200-80.jpg","fruit"));
//		
//		Item.insertItem(new Item("Potato",34,"Aroot vegetable native to the Americas","https://cdn.technologynetworks.com/tn/images/thumbs/jpeg/640_360/spud-power-potatoes-are-more-than-carbs-334431.jpg","vegetable"));
//		Item.insertItem(new Item("ladies' fingers",45,"The mucilaginous seed pods","https://5.imimg.com/data5/XN/FQ/MY-26989188/ladies-finger-500x500.jpg","vegetable"));
//		Item.insertItem(new Item("EggPlant",62," brinjal is a plant species in the nightshade family Solanaceae","https://images-na.ssl-images-amazon.com/images/I/51JbI%2BBTW7L._SL1000_.jpg","vegetable"));
//		Item.insertItem(new Item("Carrot",23,"The carrot is a root vegetable","https://i.ndtvimg.com/mt/cooks/2014-11/carrots.jpg","vegetable"));
//		
//		Item.insertItem(new Item("Surf Excel Matic",105,"Washing Powder","https://images-na.ssl-images-amazon.com/images/I/61OZNxFaxFL._SY450_.jpg","household"));
//		Item.insertItem(new Item("Vim",99,"Dishwash Liquid","https://5.imimg.com/data5/JW/FG/MY-2548289/vim-liquid-dish-wash-500x500.png","household"));
//		Item.insertItem(new Item("Dabur Honey",200,"Honey","https://www.netmeds.com/images/product-v1/600x600/12743/dabur_honey_100_gm_0_2.jpg","household"));
//		Item.insertItem(new Item("Savlon",50,"Handwash","https://5.imimg.com/data5/KW/KI/MY-46495127/savlon-antiseptic-liquid-500x500.jpg","household"));
//		
//		ArrayList<Item> items = Item.findAll();
//		
//		for(Item item:items) {
//			System.out.println(item.getName());
//		}
//		
//		ItemDataModel item = Item.findByID(1);
//		System.out.println(item.getName());
//	}

}