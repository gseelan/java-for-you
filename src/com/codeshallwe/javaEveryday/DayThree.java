package com.codeshallwe.javaEveryday;

/*
 * Let's start. 
 * 
 * First try it with regular local variable. Declare first, initialise later.
 * 
 * Let's try "var" now. Error. It says, need to initialise "var" there. something like "final"? NO
 * 
 * "var" is this reserved type name that is used in places where we use TYPE.  When we use "var",
 * the compiler gets to find the TYPE from the context given on the right side.
 * let's check with String.
 * 
 * Compiler is smart. Now if don't initialise, we are not giving the compiler enough context for it to find the TYPE of the variable. That will end up bringing a lot of chaos into otherwise Strongly typed language.
 * 
 * hence, we have to initialise "var" there where we declare itself.
 */
public class DayThree {

	public static void main(String[] args) {

		int count;
		count = 10;
		System.out.println("Primitive count :: " + count);
		// one with Objects
		String name;
		name = "CodeShallWe";
		System.out.println("Say the name :: " + name);

		// var
		// var temp;

		var str = "Hello World";
		// try assigning an int
		// str = 0;

	}
}
