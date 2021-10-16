package com.codeshallwe.designPatterns.creational;

/*
 * First, let's see how we can construct object with different representations.
 * 
 * Representations here is just the object with different state.
 * 
 * Let's try with the setter method. That is 2 ways. One with Constructors. one with setters. 
 * 
 * Builder Pattern is all about encapsulating the construction of the object part and try to construct it in steps. Let's see how now.
 * 
 * With that, the construction is encapsulated. We can go one step further and bring the builder class into the House class since the purpose of Builder class is only inside House class.
 * 
 * Now that is a simple straight forward Builder Pattern. Let's see what we need to do if we have to extend it. Say we need to add windows to our house
 * 
 * Let's make the House class abstract first. 
 */
public class BuilderDemo {
	public static void main(String[] args) {
		// We would want to start and add state the below way
		House newHouse = new ModernHouse.HouseBuilder()
				.addName("New Modern House").addWindows(3).build();
		System.out.println(newHouse);
		House newHouse2 = new ModernHouse.HouseBuilder()
				.addName("New Modern House").addWindows(3).addDoors(8).build();
		System.out.println(newHouse2);
	}
}

abstract class House {
	int doors;
	String name;

	// should be able to pass any type builder
	public House(HouseBuilder<?> houseBuilder) {
		// We can directly access
		this.doors = houseBuilder.doors;
		this.name = houseBuilder.name;
	}

	// We will need a Builder
	abstract static class HouseBuilder<T extends HouseBuilder<T>> {
		private int doors;
		private String name;

		public T addName(String name) {
			this.name = name;
			return self(); // we are returning the same builder object
		}

		public T addDoors(int i) {
			this.doors = i;
			return self();
		}

		protected abstract T self();

		abstract House build();

	}

	@Override
	public String toString() {
		return String.format("House [doors=%s, name=%s]", doors,
				name != null ? name.toUpperCase() : null);
	}
}

// let's extend base House and build a ModernHouse with windows.

class ModernHouse extends House {

	private int windows;

	public ModernHouse(HouseBuilder houseBuilder) {
		super(houseBuilder);
		this.windows = houseBuilder.windows;
	}

	// This will extend the other HouseBuilder
	static class HouseBuilder extends House.HouseBuilder<HouseBuilder> {
		private int windows;

		@Override
		protected HouseBuilder self() {
			return this;
		}

		@Override
		ModernHouse build() {
			return new ModernHouse(this); // returning the subtype of House
		}
		public HouseBuilder addWindows(int i) {
			this.windows = i;
			return this;
		}
	}

	@Override
	public String toString() {
		return String.format("ModernHouse [windows=%s, doors=%s, name=%s]",
				windows, doors, name);
	}

}