package lab6;

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

//multi level inheritance

class Tesla extends Car{
	private String model;
	Tesla(){
		super("Tesla","Electric");
		this.model = "x";
	}

}