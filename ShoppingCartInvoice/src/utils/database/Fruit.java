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

public class Fruit extends FruitModel {

		static {
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();

			try (Statement dbStatement = databaseConnection.createStatement();) {

				dbStatement.execute(
						"CREATE TABLE fruits(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,name VARCHAR(30),price DOUBLE,description VARCHAR(255),imageURL VARCHAR(255));");

			} catch (SQLException e) {
				DatabaseUtils.close(e);
				System.out.println("Table Already Exists");
			}

		}

		public Fruit(String name, double price, String description,String imageURL) {
			super(name, price, description,imageURL);
		}

		public Fruit(Integer id, String name, double price, String description,String imageURL) {
			super(id, name, price, description,imageURL);
		}

		@Override
		public String toString() {
			return ("Fruit \nName : " + name + "\nPrice : " + price + "\nDescription : " + description + "\n"+imageURL+"\n");
		}
		
		public static FruitModel findByName(String name) {
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			Fruit queryFruit = null;
			try (Statement dbStatement = databaseConnection.createStatement();) {
				ResultSet fruits = dbStatement.executeQuery("SELECT * FROM fruits WHERE name = '" + name + "';");
				if (fruits.next()) {
					int id = fruits.getInt("id");
					Double price = fruits.getDouble("price");
					String description = fruits.getString("description");
					String imageURL = fruits.getString("imageURL");
					queryFruit = new Fruit(id, name, price, description,imageURL);
				}
				DatabaseUtils.close();
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				System.out.println("Error in finding fruit : " + e.getMessage());
				e.printStackTrace();
			}

			return queryFruit;
		}

		public static FruitModel findByID(Integer fruitId) {
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			Fruit queryItem = null;
			try (Statement dbStatement = databaseConnection.createStatement();) {
				ResultSet fruits = dbStatement.executeQuery("SELECT * FROM fruits WHERE id = " + fruitId);
				if (fruits.next()) {
					String name = fruits.getString("name");
					Double price = fruits.getDouble("price");
					String description = fruits.getString("description");
					String imageURL = fruits.getString("imageURL");
					queryItem = new Fruit(fruitId, name, price, description,imageURL);
				}
				DatabaseUtils.close();
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				System.out.println("Error in finding fruit : " + e.getMessage());
				e.printStackTrace();
			}

			return queryItem;
		}

		public static ArrayList<Fruit> findAll() {
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			Fruit queryItem = null;
			ArrayList<Fruit> fruits = new ArrayList<>();
			try (Statement dbStatement = databaseConnection.createStatement();) {
				ResultSet itemCursor = dbStatement.executeQuery("SELECT * FROM fruits;");
				while (itemCursor.next()) {
					Integer id = itemCursor.getInt("id");
					String name = itemCursor.getString("name");
					Double price = itemCursor.getDouble("price");
					String description = itemCursor.getString("description");
					String imageURL = itemCursor.getString("imageURL");
					queryItem = new Fruit(id, name, price, description,imageURL);
					fruits.add(queryItem);
				}
				DatabaseUtils.close();
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				System.out.println("Error in finding fruits : " + e.getMessage());
				e.printStackTrace();
			}

			return fruits;
		};
		
		private static int saveWithId(FruitModel fruit) throws SQLException {
			int i = 0;
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			String insertItemWithIdString = "INSERT INTO fruits VALUES(?,?,?,?,?)";
			try (PreparedStatement insertItemWithId = databaseConnection.prepareStatement(insertItemWithIdString);) {
				insertItemWithId.setInt(1, fruit.getId());
				insertItemWithId.setString(2, fruit.getName());
				insertItemWithId.setDouble(3, fruit.getPrice());
				insertItemWithId.setString(4, fruit.getDescription());
				insertItemWithId.setString(5, fruit.getImageURL());
				i = insertItemWithId.executeUpdate();
				DatabaseUtils.close();
			}
			return i;
		}

		private static int saveWithoutId(FruitModel fruit) throws SQLException {
			int i = 0;
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			String insertItemWithoutIdString = "INSERT INTO fruits(name,price,description,imageURL) VALUES(?,?,?,?)";
			try (PreparedStatement insertItemWithoutId = databaseConnection.prepareStatement(insertItemWithoutIdString);) {

				insertItemWithoutId.setString(1, fruit.getName());
				insertItemWithoutId.setDouble(2, fruit.getPrice());
				insertItemWithoutId.setString(3, fruit.getDescription());
				insertItemWithoutId.setString(4, fruit.getImageURL());
				i = insertItemWithoutId.executeUpdate();
				DatabaseUtils.close();
			}
			
			return i;
			
		}

		public static int insertFruit(FruitModel fruit) {
			int i =0;
			try {
				if (fruit.getId() != null) {
					i = saveWithId(fruit);
				} else {
					i = saveWithoutId(fruit);
				}
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				System.out.println("Writing to database failed : " + e.getMessage());
				e.printStackTrace();
			}
			
			return i;
		};

		public static int updateFruit(FruitModel fruit) {
			
			
			int i = 0;
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			String updateFruitString = "UPDATE fruits\r\n"
					+ "		SET name = ?, price = ?, description=?,imageURL=?\r\n"
					+ "		WHERE id=?;";
			try (PreparedStatement updateFruitStatement= databaseConnection
					.prepareStatement(updateFruitString);) {
				
				updateFruitStatement.setString(1, fruit.getName());
				updateFruitStatement.setDouble(2, fruit.getPrice());
				updateFruitStatement.setString(3, fruit.getDescription());
				updateFruitStatement.setInt(4, fruit.getId());
				i = updateFruitStatement.executeUpdate();
				DatabaseUtils.close();
				
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				e.printStackTrace();
			}
			return i;
			
		};

		public static int deleteFruitByID(Integer fruitId) {
			int i = 0;
			Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
			String deleteFruitString = "DELETE FROM fruits WHERE id=?;";
			try (PreparedStatement deleteFruit = databaseConnection
					.prepareStatement(deleteFruitString);) {
				deleteFruit.setInt(1, fruitId);
				i = deleteFruit.executeUpdate();
				DatabaseUtils.close();
				
			} catch (SQLException e) {
				DatabaseUtils.close(e);
				e.printStackTrace();
			}
			return i;
		};

		public static int deleteItem(FruitModel fruit) {
			return deleteFruitByID(fruit.getId());
		};
		
		public static void main(String[] args) {
			Fruit.insertFruit(new Fruit("Tomato",20,"fruit","https://sciencebob.com/wp-content/uploads/2015/04/tomato_small.png"));
			Fruit.insertFruit(new Fruit("Papaya",50,"fruit","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Papaya_cross_section_BNC.jpg/1200px-Papaya_cross_section_BNC.jpg"));
			Fruit.insertFruit(new Fruit("Kiwi",40,"fruit","https://solidstarts.com/wp-content/uploads/Kiwi_edited-scaled.jpg"));
			Fruit.insertFruit(new Fruit("Banana",20,"fruit","https://cdn.mos.cms.futurecdn.net/42E9as7NaTaAi4A6JcuFwG-1200-80.jpg"));

			ArrayList<Fruit> fruits = Fruit.findAll();
			
			for(Fruit fruit:fruits) {
				System.out.println(fruit.getName());
			}
			
			FruitModel fruit = Fruit.findByID(1);
			System.out.println(fruit.getName());
		}

	}
