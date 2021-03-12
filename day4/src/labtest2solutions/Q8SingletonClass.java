package labtest2solutions;

public class Q8SingletonClass {
	public static void main(String[] args) {
		Database db1 = Database.getDatabaseInstance();
		Database db2 = Database.getDatabaseInstance();
		if(db1==db2) {
			System.out.println("Single Instance");
		}
	}
}

class Database{
	
	private static Database db;
	
	private Database() {
		
	}

	public static Database getDatabaseInstance() {
		
		if(db==null) {
			db = new Database();
		}
		return db;
	}
//	some methods to read and write to database
}


