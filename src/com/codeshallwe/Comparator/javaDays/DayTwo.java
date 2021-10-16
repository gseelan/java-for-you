package com.codeshallwe.Comparator.javaDays;

/*
 * Let's start
 * 
 * Let's see a couple of keywords - for & final.
 * Now, try using "var" as a keyword 
 * "var" can be used as identifier. So what is "var" if not a keyword
 * "var" is a reserved type name, used only in places of TYPE.
 * It can be used in place of both primitive as well as derived types a.k.a Objects
 */
public class DayTwo {

	public static void main(String[] args) {
		String name = "CodeShallWe"; // "name" as identifier works
		// String final = null; --> Keywords cannot be used as identifiers.
		String var = "Welcome"; // no issues

		// for example
		var age = 25;
		// System.out.println("Age class: " +age.getClass()); // here it is primitive
		// type int
		var lang = "java";
		System.out.println("lang is : " + lang.getClass());

		// Let's first try it with a regular local variable.
		// declare first, initialise later
		int count;
		count = 0;
		System.out.println("primitive Count:: " + count);
		// one with Object
		String names;
		names = "CodeShallWe";
		System.out.println("Say the name:: " + names);
		// Now, "var"
		//var temp;
		// Need to have initializer. somethign like final? No
		// var is a preferred type name. When we use "var" the compiler gets the cool
		// job to try hard and find the TYPE of the variable from the context on the
		// right side.
		var str = "Hello World";
		// Compiler would see the right side. Figures it is a String and assign String
		// as datatype to str. Try assigning another type.
		//str = 0;
		// Compiler is smart. Now if we don't initialize, we are not giving compiler
		// enough context for it to work. in order to avoid the chaos, we need to
		// intialise "var" when we declare itself.

	}// here it is of type String
}
