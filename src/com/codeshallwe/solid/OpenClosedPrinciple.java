package com.codeshallwe.solid;

/*
 * Revert the changes we did for Hawaiian and refactor the system first.
 * 
 * System is refactored. Let's add Hawaiian now.
 */
public class OpenClosedPrinciple {
	public static void main(String[] args) {
		PizzaCompany pc = new PizzaCompany();
		System.out.println(pc.orderPizza(new Margherita(), 5));
		System.out.println(pc.orderPizza(new Hawaiian(), 3));
	}
}

class PizzaCompany {

	public String orderPizza(PizzaType type, int quantity) {
		System.out.println("Cost of " + type.getPizzaType() + " pizza is " + (quantity * type.getCost()));
		return PizzaInventorySystem.processPizza(type, quantity);
	}

}

class PizzaInventorySystem {

	static String processPizza(PizzaType type, int quantity) {
		return String.format("Order for %s Pizza received. Quantity : %s", type.getPizzaType(), quantity);
	}
}

//Using Single Responsibility Principle, cost and type are better in Pizza class
interface PizzaType {
	String getPizzaType();

	double getCost();
}

class Margherita implements PizzaType {

	@Override
	public String getPizzaType() {
		// TODO Auto-generated method stub
		return "Margherita";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 250;
	}

}

class Pepperoni implements PizzaType {

	@Override
	public String getPizzaType() {
		// TODO Auto-generated method stub
		return "Pepperoni";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 300;
	}

}

class Hawaiian implements PizzaType {

	@Override
	public String getPizzaType() {
		// TODO Auto-generated method stub
		return "Hawaiian";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 325;
	}

}
