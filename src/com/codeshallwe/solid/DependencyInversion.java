package com.codeshallwe.solid;

/*
 * We shall see DI with the help of a Car and a Driver example. 
 * 
 * 2 Conditions:
 * a) A car can be driven as long as it is Driveable.
 * b) ANY driver should be able to drive the car.
 * 
 * let's run it
 * 
 * Now if I want a different driver to driver, say Jack. How hard can it be? 
 * An implementation for Jack. And change in Driveable implementation. But then changing to 
 * Tom is a problem. This code has tight coupling.
 * 
 * Let's fix it. We can create the object before and pass it to Car instead of creating it
 * at the time of driving it.
 * 
 * With this the dependency is inverted. 
 * 
 * Thank you. :)
 */
public class DependencyInversion {

	public static void main(String[] args) {
		Car ford = new Car();
		// pass the driver.
		ford.myDriver(new Tom());
		ford.drive();
		//for Jack
		ford.myDriver(new Jack());
		ford.drive();
	}

}

//To make the car driveable
interface Driveable {
	void drive();
}

//Tom the Driver who can drive anything that is driveable
class Tom implements iDriver {
	public void driveIt(Driveable d) {
		System.out.println("Tom is driving it");
	}
}

//IMPL for Jack
class Jack implements iDriver {
	public void driveIt(Driveable d) {
		System.out.println("Jack is driving it");
	}
}

//An implementation for driveable
class DriveableImpl implements Driveable {

	private iDriver driver;

	public void myDriver(iDriver driver) {
		this.driver = driver;
	}

	@Override
	public void drive() {
		// now any driver being passed will be able to drive it.
		driver.driveIt(this);
	}
}

//The car that extends the DriveableImple
class Car extends DriveableImpl {

}

interface iDriver {
	void driveIt(Driveable d);
}






















