package com.codeshallwe.Comparator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 4 ways to create an Object
 * 
 * 1) new keyword
 * 2) Cloning
 * 3) Serialization
 * 4) Reflection
 * 
 * These are the 4 ways to create an object.
 */
public class Singleton implements Cloneable, Serializable {

	public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException, IOException,
			ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// 1. new keyword
		Singleton obj1 = new Singleton();
		Singleton obj2 = new Singleton();
		System.out.println(
				String.format("Hashcode of Obj1 [%s], Hashcode of Obj2 [%s]", obj1.hashCode(), obj2.hashCode())); // 2
																													// different
																													// objects

		// 2. Cloning - For this, the class has to implement Cloneable interface
		Singleton obj3 = (Singleton) obj2.clone(); // cloning object from a previous object
		System.out.println(
				String.format("Hashcode of Obj2 [%s], Hashcode of Obj3 [%s]", obj2.hashCode(), obj3.hashCode()));

		// 3. Serialization - For this, the class has to implement Serializable
		// interface
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("example.ser"));
		out.writeObject(obj3); // writing object 3 so we can retrieve later.
		out.close(); // closing stream

		// let's quickly see the file getting created.
		ObjectInput in = new ObjectInputStream(new FileInputStream("example.ser"));
		Singleton obj4 = (Singleton) in.readObject();
		System.out.println(
				String.format("Hashcode of Obj3 [%s], Hashcode of Obj4 [%s]", obj3.hashCode(), obj4.hashCode()));

		// 4. Reflection - 2 ways again a) Class b) Constructor

		// Class based
		Singleton obj5 = Singleton.class.newInstance(); // deprecated from java 9
		System.out.println(
				String.format("Hashcode of Obj4 [%s], Hashcode of Obj5 [%s]", obj4.hashCode(), obj5.hashCode()));

		// Constructor based
		Constructor<Singleton> cons = Singleton.class.getConstructor();
		Singleton obj6 =  cons.newInstance();
		System.out.println(
				String.format("Hashcode of Obj5 [%s], Hashcode of Obj6 [%s]", obj5.hashCode(), obj6.hashCode()));

	}

}
