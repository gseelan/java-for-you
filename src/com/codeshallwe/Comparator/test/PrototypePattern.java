package com.codeshallwe.Comparator.test;

/*
 * Let's start by designing the car. Car needs say 17inch infotainment system, a 5L V8 engine, 2 doors, 4 wheels
 */
public class PrototypePattern {

	public static void main(String[] args) {
		InfotainmentSystem is = new InfotainmentSystem("17inch");
		System.out.println(is);
	}
}

class Car {

	private InfotainmentSystem infoSystem;
	private Engine engine;
	private Door doors;
	private Wheel wheels;

}
class InfotainmentSystem {
	private String name;

	public InfotainmentSystem(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("InfotainmentSystem [%s]", this.name);
	}
}
class Engine {
	private String name;

	public Engine(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("InfotainmentSystem [%s]", this.name);
	}
}
class Door {

	private String name;

	public Door(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("InfotainmentSystem [%s]", this.name);
	}

}
class Wheel {

	private String name;

	public Wheel(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("InfotainmentSystem [%s]", this.name);
	}

}

/*
 * Check == test to make sure they are different objects but equals shoudld
 * point to same.
 */