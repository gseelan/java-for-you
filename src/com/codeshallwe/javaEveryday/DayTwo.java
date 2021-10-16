package com.codeshallwe.javaEveryday;

/*
 * Let's start
 * 
 * "name" as identifier works fine. 
 * Let's try to use a couple of keywords in java as identifiers - for, final
 * Again error. So keywords cannot be used as identifiers.
 * 
 * now, try using var as a keyword. - works fine. so "var" is not a keyword. 
 * Then what is var?? 
 * 
 * var is a reserved type name. It can be used only in places where a TYPE is used or expected.
 * By TYPE, it can be used in place of both primitives as well as Derived/ Objects
 * Let's check
 * 
 * Thank you.
 */
public class DayTwo {

	public static void main(String[] args) {
		String name = "CodeShallWe";
		System.out.println("Name:: " + name);
		// String final = "Not gonna work";//won't work

		String var = "varPlay";
		System.out.println("What play : " + var);
		var age = 23;
		System.out.println("Type here is int - primitive :: "+age);
		var name2 = "Anothername";
		System.out.println("Another name? "+name2.getClass());
	}
}
