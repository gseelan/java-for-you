package com.codeshallwe.designPatterns.creational;

/*
 * Why do we need Singleton pattern?
 * 
 * There are cases where only one instance of the object is enough. For instance, to compare with real world, a school can
 * live with only one HeadMaster. In our system, System runtime, we don't really need too many instance of it, as there is 
 * only one at a time.
 * 
 * Like this, in places where only one instance can do the job, we can use Singleton pattern. 
 * 
 * Spring Framework, by default create all the objects/ beans as Singleton. But one thing to note is, they are all
 * Singleton per JVM. 
 * 
 * Hope you enjoyed the session. Meet you in the next one. Good day!
 * 
 */
public class SingletonDemo {

	public static void main(String[] args) throws Exception {

		System.out.println(Runtime.getRuntime());
	}

}
