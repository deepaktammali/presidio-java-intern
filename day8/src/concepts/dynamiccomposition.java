package concepts;

import java.util.ArrayList;
import java.util.Scanner;

public class dynamiccomposition {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		Thali thali = new Thali();
		boolean eatingFood = true;
		while (eatingFood) {
			
			System.out.println("Enter choice \n1.Add food \n2.Get cost");
			choice = scanner.nextInt();
			switch (choice) {
				case 1: {
					System.out.println("Enter choice \n1.Rice \n2.Daal \n3. Prawn");
					int foodChoice = scanner.nextInt();
					switch(foodChoice) {
					
					case 1:{
						thali.addFood(new Rice());
						break;
					}
					
					case 2:{
						thali.addFood(new Daal());
						break;
					}
					
					case 3:{
						thali.addFood(new Prawn());
						break;
					}
					
					default:{
						System.out.println("Enter Valid Choice");
						break;
					}
					
					}
					break;
				}
				
				case 2:{
					System.out.println("Your total bill is "+thali.cost());
//					eatingFood = false;
					break;
				}
			}
		}
	}
}

class Thali {
	private ArrayList<Food> foodItems;
	
	public Thali() {
		foodItems = new ArrayList<Food>();
	}
	
	public int cost() {
		int totalCost = 0;
		for (int i = 0; i < foodItems.size(); i++) {
			totalCost += foodItems.get(i).cost();
		}
		return totalCost;
	}

	public void addFood(Food food) {
		foodItems.add(food);
	}

}

abstract class Food {
	public abstract int cost();
}

abstract class VegFood extends Food {

}

abstract class NonVegFood extends Food {

}

class Rice extends VegFood {

	Food food;

	Rice() {
		food = null;
	}

	Rice(Food food) {
		this.food = food;
	}

	@Override
	public int cost() {
		return (food == null) ? 10 : 10 + food.cost();
	}

}

class Daal extends VegFood {

	Food food;

	Daal() {
		food = null;
	}

	Daal(Food food) {
		this.food = food;
	}

	@Override
	public int cost() {
		return (food == null) ? 15 : 15 + food.cost();
	}
}

class Prawn extends NonVegFood {
	Food food;

	Prawn() {
		food = null;
	}

	Prawn(Food food) {
		this.food = food;
	}

	@Override
	public int cost() {
		return (food == null) ? 30 : 30 + food.cost();
	}
}
