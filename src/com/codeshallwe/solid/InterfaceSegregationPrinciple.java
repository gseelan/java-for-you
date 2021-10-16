package com.codeshallwe.solid;

public class InterfaceSegregationPrinciple {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.run();
		// dog.fly(); //This is not supported anymore.
		dog.bark();
		Bird bird = new Bird();
		bird.fly();
	}

}

//To fix, let's segregate the interfaces

interface barkable {
	void bark();
}

interface runnable {
	void run();
}

interface flyable {
	void fly();
}

//implement Dog
class Dog implements barkable, runnable {

	@Override
	public void bark() {
		System.out.println("Happy to... bark");
	}

	@Override
	public void run() {
		System.out.println("Sure can...run");
	}

}

//Let's implement a bird that could fly
class Bird implements flyable {

	@Override
	public void fly() {
		System.out.println("I am flying");

	}

}