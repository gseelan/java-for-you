package com.codeshallwe.javaEveryday;

/*
 * Let's start
 * 
 * Trick question because it works only with nested classes on only 2 occastions.
 * One with Local classes. Let's see that.
 * Now, let's get it from Anonymous class but using "var". 
 * Thank you.
 */
public class DayOne {

	public static String getFromLocal() {
		class Names {
			private String name = "AwesomeBus";
		}
		Names names = new Names();
		return names.name; // Here, we access the private field
	}

	public static String getFromAnonymous() {
		var bus = new iBus() {
			private String name = "AnonymousBus";
		};
		return bus.name;// Here again, we access the private field.
	}

	public static void main(String[] args) {
		// Let's try to access the private field name.
		Bus bus = new Bus();
		// bus.name;// It is private. Not visible hence.
		System.out.println("Name from Local class is: " + getFromLocal());
		System.out.println("Name from Anonymous Var : " + getFromAnonymous());
	}
}

interface iBus {

}

class Bus {
	private String name;
}
