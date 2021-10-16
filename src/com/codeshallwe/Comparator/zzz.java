package com.codeshallwe.Comparator;

/*
 * 2 Conditions
 * 1. Say a car can be driven by a driver as long as the car is driveable. 
 * 2. We get an instance of the Driver to drive the car. 
 * 
 * What do we need?
 * 
 * Questions:
 *  How do I change the Driver? What if instead of Tom I want Jack to take the car?
 */
public class zzz {
	public static void main(String[] args) {
		Car fc = new Car();
		fc.myDriver(new JackTheDriver());
		fc.drive();
	}
}

interface Drivable {
	void drive();

	static class DrivableImpl implements Drivable {

		private Driver driver;

		public void myDriver(Driver d) {
			this.driver = d;
		}

		@Override
		public void drive() {
			driver.driveIt(this);
		}
	}
}

class TomTheDriver implements Driver {

	// anything drivable, a driver should be able to drive.
	public void driveIt(Drivable d) {
		System.out.println("Tom is driving it");
	}
}

class JackTheDriver implements Driver {

	// anything drivable, a driver should be able to drive.
	public void driveIt(Drivable d) {
		System.out.println("Jack is driving it");
	}
}

class Car extends Drivable.DrivableImpl {

}

interface Driver {
	void driveIt(Drivable d);
}