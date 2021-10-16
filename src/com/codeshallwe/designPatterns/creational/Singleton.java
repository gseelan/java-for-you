package com.codeshallwe.designPatterns.creational;

/*
 * 4 ways to create an Object
 * 
 * 1) new keyword
 * 2) Cloning
 * 3) Serialization
 * 4) Reflection
 * 
 * These are the 4 ways to create an object. Let's create another class to demonstrate Singleton.
 * 
 * Let's first create our only one object in this class, with global access
 * 
 * Let's make this an Enum
 */
public enum Singleton {

	NEWINSTANCE; //This is the only instance using which we can access the methods in this class

	public String getMessage() {
		return "Hello";
	}

}
