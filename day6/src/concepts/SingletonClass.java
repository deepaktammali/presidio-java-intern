package concepts;


public class SingletonClass {
	public static void main(String[] args) throws CloneNotSupportedException{
		BusData bd1 = BusData.getInstance();
		bd1.data = "bd1";
		
		BusData bd2 = BusData.getInstance();
		bd2.data = "bd2";
		
		System.out.println(bd1.data);
		System.out.println(bd1);
		System.out.println(bd2);
	}
}

class BusData implements Cloneable{
	static private BusData bd;
	String data;
	
	private BusData(){
		
	}
	
	public static BusData getInstance() throws CloneNotSupportedException {
		if(bd==null) {
			bd = new BusData();
		}
		
		return bd;
	}
	
	public BusData clone() throws CloneNotSupportedException {
		return (BusData)super.clone();
	}
}
