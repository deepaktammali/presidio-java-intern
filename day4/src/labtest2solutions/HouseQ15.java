package labtest2solutions;

public class HouseQ15 {
	public static void main(String[] args) {
		Door myDoor = new Door();
		Window myWindow = new Window();
		House house = new House(myDoor,myWindow,8,4);
		System.out.println("The cost of house is "+house.getCost());
	}
}


class House{
	private Door door;
	private Window window;
	private int doorArea;
	private int windowArea;
	
	House(Door door,Window window,int doorArea,int windowArea){
		this.door = door;
		this.doorArea = doorArea;
		this.window = window;
		this.windowArea = windowArea;
	}

	public int getCost() {
		return door.getCost(doorArea)+window.getCost(windowArea);
	}
}

class Door{
//	100rupees for sq.m default
	
	private int costPerSqm = 100;
	
	Door(){
		
	}
	
	Door(int costPerSqm){
		this.costPerSqm = costPerSqm;
	}
	
	public int getCostPerSqm() {
		return costPerSqm;
	}
	
	public int getCost(int area) {
		return area*costPerSqm;
	}
	
}


class Window{
	
	private int costPerSqm = 100;
	
	Window(){
		
	}
	
	public int getCostPerSqm() {
		return costPerSqm;
	}

	Window(int costPerSqm){
		this.costPerSqm = costPerSqm;
	}
	
	public int getCost(int area) {
		return area*costPerSqm;
	}
}