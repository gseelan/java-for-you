package com.codeshallwe.javaEveryday;

/*
 * Let's start.
 * 
 * Creating 2 interfaces - Flyable And Walkable
 * 
 * Let's have something that can both Fly and Walk - A bird.
 * 
 * At this point it looks like this...
 * There is another way of implementing this, if we decide to program to the interface.
 * But if we are going to have just one this way, this would be an overkill. Going back to how it was before.
 * 
 * Let's have a method that returns an instance of something that can both Fly and Walk
 * 
 * Bird is at the intersection. Instead of creating an intersecting interface we could use var.
 * Also we saw how intersection type can be used instead of creating another interface.
 */

public class Var {

	// We are returning T. T has to be something that is Walkable and Flyable.
	//T here is an intersection of Walkable and Flyable.
	public static <T extends Flyable & Walkable> T getSomething() {
		// here let's return an instance of a Bird
		return (T) new Bird();
	}

	public static void main(String[] args) {
		var bird = getSomething();
		bird.fly(); // Now fly is not there.
		// Find walk()
		bird.walk();// It is not there. If I change the interface to Walkable, then maybe will get
					// walk()
		// What if I want to have both -> Flyable and Walkable but without having an
		// intersecting interface
	}
}

class Bird implements Flyable, Walkable {

	@Override
	public void walk() {
		System.out.println("Walking...");
	}

	@Override
	public void fly() {
		System.out.println("Flying...");
	}

}

interface Flyable {
	void fly();
}

interface Walkable {
	void walk();
}
