package com.codeshallwe.Comparator.javaDays;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Trick question because it works only for nested class on 2 occasions.
 * One when we use Local Classes, which are classes inside a block.
 * Another is to use "var" with an Anonymous Class
 */
public class DayOne {

	public static String retrieveName() {
		class Names {
			private String name = "AwesomeBus";
		}
		Names names = new Names();
		return names.name;
	}

	public static String retrieveNameFromAnonymous() {
		var bus = new iBus() {
			private String name = "AnonymousBus";
		};
		return bus.name;
	}

	static <T> T pick(T a1, T a2) {
		return a2;
	}

	static <T, A, B> void hg(List<T> h) {

	}

	public static <T extends String & List> void main(String[] args) {
		Bus bus = new Bus();
		// bus.name; //This is not visible because it is private.
		System.out.println("Bus name is : " + retrieveName());
		System.out.println("Bus name from Anonymous is : " + retrieveNameFromAnonymous());
		var s = pick("d", new ArrayList<String>());
		System.out.println("kkkkkk " + s.getClass());
		List<? extends Number> h = new ArrayList<Temp>();
		// h.add(new Temp()); // --> Not working - #find
		List<Temp> g = new ArrayList<>();
		// hg(h);
		// hg(g);

	}

	@SuppressWarnings("unchecked")
	private static <T extends Closeable & Iterator<String>> T createCloseableIterator(boolean empty) {
		if (empty)
			return (T) new Empty();
		else
			return (T) new Scanner(System.in);
	}

	static void readAndPrint(boolean empty) throws IOException {
		var elements = createCloseableIterator(empty);
	}

//https://dev.to/rnowif/intersection-types-in-java-1jk8
	<T extends FileReader & FileWriter> void readAndWrite2(T file) {
		file.readLines();
		file.write("Hello");
	}

}

class Empty {

}

interface FileReader {
	Collection<String> readLines();
}

interface FileWriter {
	void write(String line);
}

interface FileDestroyer {
	void deleteFile();
}

interface iBus extends Serializable {
}

class Temp extends Number {
	public Temp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Bus {

	private String name;
	private int seats;
}