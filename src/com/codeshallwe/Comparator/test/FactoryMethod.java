package com.codeshallwe.Comparator.test;

/*
 * Let's start with the Simple Factory first.
 * 
 * We would need a couple of food items, a restaurant and the restaurant's own Factory/Kitchen
 * 
 * With that the Simple Factory is in play. Let's check the 2nd use case now. 
 * 
 * We go to the Restaurant's online portal and order. Food could come from any of the Restaurant's franchises. The Main restaurant does have some control on the franchises but the franchises do have some control on items. Let's see how.
 * 
 * Ideally is to make the Restaurant Abstract and allow the sub classes to decide on some implementations. That way the main restaurant will have some control and the sub classes/franchises will have some control as well. 
 * 
 * 
 * This way method acting as Factory would help in building frameworks where the core classes do some work and expect the classes that extend to have some control. 
 * 
 * With that, we saw Simple Factory and Factory Method Pattern.
 */
public class FactoryMethod {

	public static void main(String[] args) {
		// Let's create the restaurant by passing the factory
		AbstractRestaurant restaurant = new FranchiseOneFactory();
		restaurant.orderFood("Biriyani");
		restaurant.orderFood("CaesarSalad");
	}
}
// This will do for Food
interface iFood {
}
class CaesarSalad implements iFood {
}
class Biriyani implements iFood {
}

abstract class AbstractRestaurant {

	public iFood orderFood(String whatFood) {
		// This method is the control that the main restaurant has on the food.
		// think of it as how some restaurant have secret recipes and only they
		// provide the ingredients
		getIngredients(whatFood);
		return createFood(whatFood); // Asking factory METHOD to create food
	}

	public void getIngredients(String whatFood) {
		System.out.println(whatFood + " :: getIngredients");
	}
	// This method here acts as a Factory. This method will be implemented by
	// the sub classes
	// this is the control the franchises/ sub classes have over this food
	protected abstract iFood createFood(String whatFood);
}

class OwnFactory extends AbstractRestaurant {

	@Override
	public iFood createFood(String whatFood) {
		System.out.println("OwnFactory :: is called");
		iFood food = null;
		if ("Biriyani".equalsIgnoreCase(whatFood)) {
			food = new Biriyani();
		} else if ("CaesarSalad".equalsIgnoreCase(whatFood)) {
			food = new CaesarSalad();
		}
		System.out.println(whatFood + " creating/cooking");
		return food;
	}
}

class FranchiseOneFactory extends AbstractRestaurant {

	@Override
	public iFood createFood(String whatFood) {
		System.out.println("FranchiseOneFactory :: is called");
		iFood food = null;
		if ("Biriyani".equalsIgnoreCase(whatFood)) {
			food = new Biriyani();
		} else if ("CaesarSalad".equalsIgnoreCase(whatFood)) {
			food = new CaesarSalad();
		}
		System.out.println(whatFood + " creating/cooking");
		return food;
	}
}
