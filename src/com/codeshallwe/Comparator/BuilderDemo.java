package com.codeshallwe.Comparator;

public class BuilderDemo {
	public static void main(String[] args) {
		HouseBuilder builder = new HouseBuilder();
		House h1 = builder.addWindows(2).addDoors(2).addName("Hello").build();
		House h2 = builder.addWindows(5).addName("House with just windows").build();
		System.out.println(h1);
		System.out.println(h2);
		House h3 = HouseBuilder.start().addWindows(2).addDoors(2).addName("h3").build();
		System.out.println(h3);
		House h4 = HouseBuilder.start().addWindows(5).addName("h4").build();
		System.out.println(h4);
	}
}



class House {

	private int windows;
	private int doors;
	private String name;

	public House(HouseBuilder builder) {
		this.windows = builder.getWindows();
		this.doors = builder.getDoors();
		this.name = builder.getName();
	}

	@Override
	public String toString() {
		return String.format("House [windows=%s, doors=%s, name=\"%s\"]", windows, doors, name.toUpperCase());
	}

}

class HouseBuilder {

	private int windows;
	private int doors;
	private String name;

	public static HouseBuilder start() {
		return new HouseBuilder();
	}

	public HouseBuilder addWindows(int noOfWindows) {
		this.windows = noOfWindows;
		return this;
	}

	public HouseBuilder addName(String name) {
		this.name = name;
		return this;
	}

	public HouseBuilder addDoors(int noOfDoors) {
		this.doors = noOfDoors;
		return this;
	}

	public House build() {
		return new House(this);
	}

	public int getWindows() {
		return windows;
	}

	public int getDoors() {
		return doors;
	}

	public String getName() {
		return name;
	}

}
