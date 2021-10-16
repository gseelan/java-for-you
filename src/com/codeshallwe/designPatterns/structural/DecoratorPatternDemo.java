package com.codeshallwe.designPatterns.structural;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/*
 * Let's first have a person and its implementation.
 * 
 * Now, let's have the Basic Decorator/ Hat implementation. One thing to remember is that this also will implement Programmer. 
 * 
 * Now the concrete implementations for the Decorator.
 * 
 * Same Object is being decorated with Java and Python.
 * 
 * We will quickly see a classic example of Decorator Pattern. It is the Input/Output Stream of Java IO
 * 
 * Here, we first decorated the file with FileOutputStream. Then went on to decorate it with GZIPOutputStream.
 * 
 * Another aspect of Decorator Pattern is to add additional behaviors when we decorate. For instance, with the java Io GZIPOutputStream, it adds its own behaviors to create a GZIP file in addition to overriding FileOutputStream. Lets quickly check that in our case/example.
 * 
 */
public class DecoratorPatternDemo {
	public static void main(String[] args) {

		File file = new File("files/example.txt");
		try (FileOutputStream fos = new FileOutputStream(file); GZIPOutputStream gos = new GZIPOutputStream(fos)) {

		} catch (IOException e) {
		}

		Programmer p1 = new BeginnerProgrammer();
		p1.languagesKnown();
		Programmer p2 = new BeginnerProgrammer();
		p2 = new JavaHat(p2);
		p2.languagesKnown(); // the simple beginner programmer is now decorated
		// let's also add Python
		p2 = new PythonHat(p2);
		p2.languagesKnown();

		//
		JavaHat jh = new JavaHat(p2);
		jh.saySomething();
		PythonHat ph = new PythonHat(p2);
		ph.doNothing();
	}
}

class JavaHat extends HatDecorator {

	public JavaHat(Programmer programmer) {
		super(programmer, "Java");
	}

	public void saySomething() {
		System.out.println("Java is the Best Language");
	}
}

class PythonHat extends HatDecorator {

	public PythonHat(Programmer programmer) {
		super(programmer, "Python");
	}

	public void doNothing() {
		System.out.println("No. Python is th Best language");
	}
}

class HatDecorator implements Programmer {

	protected Programmer programmer;

	public HatDecorator(Programmer programmer, String lang) {
		this.programmer = programmer;
		addLanguage(lang);
	}

	@Override
	public void languagesKnown() {
		this.programmer.languagesKnown();
	}

	@Override
	public void addLanguage(String lang) {
		this.programmer.addLanguage(lang);
	}
}

interface Programmer {
	void languagesKnown();

	void addLanguage(String lang);
}

class BeginnerProgrammer implements Programmer {
	Set<String> langKnown = new HashSet<>();

	@Override
	public void languagesKnown() {
		System.out.println(null != langKnown && langKnown.isEmpty() ? "No languages yet" : langKnown.toString());
	}

	@Override
	public void addLanguage(String lang) {
		this.langKnown.add(lang); // with every decorator/ hat, we add languages
	}
}
