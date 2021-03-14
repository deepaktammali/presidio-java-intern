public class Q50{
	public static void main(String[] args){

	}
}

class Vehicle{

	protected String typeOfVehicle; //Air,Water,Land
	Vehicle(String typeOfVehicle){
		this.typeOfVehicle = typeOfVehicle;
	}

}

//single level inheritance
class Car extends Vehicle{
	protected String brand;
	private String fuelType;
	//car related stuff
	Car(String brand,String fuelType){
		super("Land");
		this.brand = brand;
		this.fuelType = fuelType;
	}
}

class Aeroplane extends Vehicle{
	protected string brand;
	//aeroplane related stuff
	Aerolane(String brand){
		super("Air");
		this.brand = brand;
	}
}

//multi level inheritance

class Tesla extends Car{
	Tesla(){
		super("Tesla","Electric");
		this.model = "x";
	}

}