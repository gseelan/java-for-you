package com.codeshallwe.designPatterns.creational;

/*
 * Let's start by designing a Car with say doors, wheels, engine and an infortainment system.
 * doors -2, wheels - 4, engine 5L v8, infotainment system - 15inches.
 * This would be our baseline model. Let's build
 * 
 * We have the components for the base model ready. let's build the car
 * 
 * That is our base car. Keeping this as a Prototype, we will see how we can make copy of the same and 2 advanced models.
 * 
 * First to take copy, in jave we have to clone things/ the object/ here the car. For that, the car class has to implement cloneable interface.
 * 
 * We are not going to override hashCode and equals in this video. Let's see the components in the copy.
 * Java by default when we clone, does Shallow copy. By Shall copy, java creates a new object for the enclosed class, in our case, Car. But the components used inside, the instance variables are going to be the same ones. Hence the same door object is used in both place. To do Deep copy, where in all components are new, we have to edit the clone() method in Car class. Also we have to make sure the components are cloneable.
 * 
 * This is a Shallow Copy. Let's try a Deep Copy
 * They are not different Objects, the instance fields themselves. We have only done or Doors. You can do it for other fields as well. This is one aspect of Prototype. Copying/Cloning same Object to create other objects.
 * 
 * Let's now see how we can use one prototypical instance and build on top
 * 
 * We just saw how we can clone the base and build on top of the base model. Again it saves a lot of effort and time. You can build another model and check for yourselves.
 */
public class PrototypeDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Door doors = new Door(2);
		Wheel wheels = new Wheel(4);
		Engine engine = new Engine("5L V8");
		InfotainmentSystem infoSystem = new InfotainmentSystem("15inches");
		Car baseCar = new Car(doors, wheels, engine, infoSystem);
		System.out.println("Base Car:: " + baseCar);
		Car baseCarCopy = (Car) baseCar.clone();
		System.out.println("Base Car Copy:: " + baseCarCopy);
		// To make sure they are not the same Object
		System.out.println("Are they same:: " + (baseCar == baseCarCopy));
		System.out.println("Checking Shallow Copy:: "
				+ (baseCar.getDoors() == baseCarCopy.getDoors()));
		Car baseCarShallowCopy = (Car) baseCar.makeACopy(true);
		System.out.println("Base car shallow copy:: "
				+ (baseCar.getDoors() == baseCarShallowCopy.getDoors()));
		// Let's try deep copy
		Car baseCarDeepCopy = (Car) baseCar.makeACopy(false);
		System.out.println("Base car Deep copy:: "
				+ (baseCar.getDoors() == baseCarDeepCopy.getDoors()));

		// let's try a different model on top of baseline Model. Say 17inches
		// infotainment system
		// Out baseline
		System.out.println("Base Car Again:: " + baseCar);
		Car modelOne = baseCar.makeACopy(false);
		InfotainmentSystem newInfoSystem = new InfotainmentSystem("17inches");
		modelOne.setInfoSystem(newInfoSystem);
		System.out.println("Model one Car :: " + modelOne);

	}
}

// Car here
class Car implements Cloneable {
	private Door doors;
	private Wheel wheels;
	private Engine engine;
	private InfotainmentSystem infoSystem;
	protected Car(Door doors, Wheel wheels, Engine engine,
			InfotainmentSystem infoSystem) {
		super();
		this.doors = doors;
		this.wheels = wheels;
		this.engine = engine;
		this.infoSystem = infoSystem;
	}
	public Door getDoors() {
		return doors;
	}
	public Engine getEngine() {
		return engine;
	}
	public InfotainmentSystem getInfoSystem() {
		return infoSystem;
	}
	public void setInfoSystem(InfotainmentSystem infoSystem) {
		this.infoSystem = infoSystem;
	}
	@Override
	public String toString() {
		return String.format(
				"Car [doors=%s, wheels=%s, engine=%s, infoSystem=%s]", doors,
				wheels, engine, infoSystem);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	// for our convenience
	public Car makeACopy(boolean isShallow) throws CloneNotSupportedException {
		Car car = null;
		if (isShallow) {
			car = (Car) super.clone();
		} else {
			car = (Car) super.clone();
			car.doors = (Door) this.doors.clone();
		}
		return car;
	}
}

class Door implements Cloneable {
	private int count;
	public Door(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return String.format("Door [Count=%s]", count);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
// Now, let's do the same for other components in the car.
class Wheel implements Cloneable {
	private int count;
	public Wheel(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return String.format("Wheel [Count=%s]", count);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
class Engine implements Cloneable {
	private String name;
	public Engine(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("Engine [name=%s]", name);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
class InfotainmentSystem implements Cloneable {

	private String name;
	public InfotainmentSystem(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("InfotainmentSystem [name=%s]", name);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
