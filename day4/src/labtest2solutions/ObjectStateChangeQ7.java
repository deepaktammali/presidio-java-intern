package labtest2solutions;

public class ObjectStateChangeQ7 {
	public static void main(String[] args) {
		final Car teslaCar = new Car("Model Y");
		System.out.println("The car model is "+teslaCar.modelName);
		teslaCar.modelName = "Model S";
		System.out.println("The car model is "+teslaCar.modelName);
	}
}

class Car{
	public String modelName;
	Car(String modelName){
		this.modelName = modelName;
	}
}
