package concepts;

public class templating {
	public static void main(String[] args) {
		
		PizzaFranchise pizzaFranchise = new PizzaHut();
		pizzaFranchise.createOrder();
		
		pizzaFranchise = new Dominos();
		pizzaFranchise.createOrder();
		
	}
}


abstract class PizzaFranchise{
	abstract protected void createPizza();
	abstract protected void packPizza();
	abstract protected void deliverPizza();
	
	final public void createOrder() {	//template method
		createPizza();
		packPizza();
		deliverPizza();
	}
}

class PizzaHut extends PizzaFranchise{
	@Override
	protected void createPizza() {
		System.out.println("Creating pizzahut pizza");
	}

	@Override
	protected void packPizza() {
		System.out.println("Packing pizzahut pizza");
	}

	@Override
	protected void deliverPizza() {
		System.out.println("Delivering pizzahut pizza");
	}
}


class Dominos extends PizzaFranchise{

	@Override
	protected void createPizza() {
		System.out.println("Creating dominos pizza");
		
	}

	@Override
	protected void packPizza() {
		System.out.println("Packing dominos pizza");
		
	}

	@Override
	protected void deliverPizza() {
		System.out.println("Delivering dominos pizza");
		
	}
	
}