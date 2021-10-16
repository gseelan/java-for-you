package com.codeshallwe.Comparator;

import java.util.HashSet;
import java.util.Set;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Person p1 = new SimplePerson();
		p1.languagesknown();
		p1 = new JavaHat(p1);
		p1.languagesknown();
		p1 = new PythonHat(p1);
		p1.languagesknown();
	}
}

interface Person {
	void languagesknown();

	void addLanguages(String lang);
}

class SimplePerson implements Person {
	Set<String> langKnown = new HashSet<>();

	@Override
	public void languagesknown() {
		System.out.println(langKnown.isEmpty() ? "No languages yet" : langKnown.toString());
	}

	public void addLanguages(String lang) {
		this.langKnown.add(lang);
	}
}

class JavaHat extends HatDecorator {
	public JavaHat(Person person) {
		super(person, "Java");
	}
}

class PythonHat extends HatDecorator {
	public PythonHat(Person person) {
		super(person, "Python");
	}
}

class HatDecorator implements Person {

	protected Person person;

	public HatDecorator(Person person, String lang) {
		this.person = person;
		addLanguages(lang);
	}

	@Override
	public void languagesknown() {
		this.person.languagesknown();
	}

	@Override
	public void addLanguages(String lang) {
		this.person.addLanguages(lang);
	}

}
