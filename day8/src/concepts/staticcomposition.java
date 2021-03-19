//package concepts;
//
//
//public class staticcomposition {
//	public static void main(String[] args) {
//		Food food = new Rice(new Daal(new Prawn()));
//		System.out.println("The current food price is :"+food.cost());
//	}
//}
//
//abstract class Food {
//	public abstract int cost();
//}
//
//abstract class VegFood extends Food {
//
//}
//
//abstract class NonVegFood extends Food {
//
//}
//
//class Rice extends VegFood {
//
//	Food food;
//
//	Rice() {
//		food = null;
//	}
//
//	Rice(Food food) {
//		this.food = food;
//	}
//
//	@Override
//	public int cost() {
//		return (food == null) ? 10 : 10 + food.cost();
//	}
//
//}
//
//class Daal extends VegFood {
//
//	Food food;
//
//	Daal() {
//		food = null;
//	}
//
//	Daal(Food food) {
//		this.food = food;
//	}
//
//	@Override
//	public int cost() {
//		return (food == null) ? 15 : 15 + food.cost();
//	}
//}
//
//class Prawn extends NonVegFood {
//	Food food;
//
//	Prawn(){
//		food=null;
//	}
//
//	Prawn(Food food){
//		this.food = food;
//	}
//
//	@Override
//	public int cost() {
//		return (food == null) ? 30 : 30 + food.cost();
//	}
//}