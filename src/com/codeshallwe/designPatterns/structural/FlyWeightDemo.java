package com.codeshallwe.designPatterns.structural;

import java.util.HashMap;
import java.util.Map;

/*
 * Let's first have how we would like to call our CustomerCare object and process the requests.
 * 
 * Next, let's have the departments ready.
 * have 2 more departments. Travel and HR
 * 
 * Now, let's implement the CustomerCare class. Idea is to create only few objects and reuse them.
 * 
 * We could check once now.
 * 
 * They are not reused. They are different Objects. Let's try Singleton pattern to get the Objects
 * Not the complete implementation of singleton as you could find in the Singleton video.
 * 
 * Now they are same Objects. let's do it for the other objects. Btw, object creation can be done using many ways.  checkout creational design patterns.
 * 
 * Same objects are reused for repeated requests.
 * 
 * Thread Pool, Connection Pool and String Pool are all classic examples where we use the same object again and again inorder to not waste energy on creating new objects. Let's quickly check String Pool
 * 
 */
public class FlyWeightDemo {

	public static void main(String[] args) {
		CustomerCare custCare = new CustomerCare();
		// Let's pass the Requests into this. Each Request will be of some type.
		custCare.processRequests(new Request("Claims"));
		custCare.processRequests(new Request("HR"));
		custCare.processRequests(new Request("Claims"));
		custCare.processRequests(new Request("HR"));
		custCare.processRequests(new Request("HR"));
		custCare.processRequests(new Request("Travel"));

		// Checking the String Pool
		String a = "CodeShallWe";
		String b = "CodeShallWe";
		// Now what is happening is that, behind the scene Java uses a String Pool and
		// same strings are pointed to the same ones in the pool. Not like creating new
		// objects in the heap.

		System.out.println(a.hashCode() == b.hashCode());
		System.out.println("A. " + a.hashCode());
		System.out.println("B. " + b.hashCode());
	}
}

class CustomerCare {

	private static Map<String, Department> departments = new HashMap<>();

	public void processRequests(Request request) {
		// Here, we would like to get the department from the map and then process the
		// request through the concerned department.
		CustomerCare.getDepartment(request.getType()).processRequest(request);
	}

	private static Department getDepartment(String type) {
		departments.put("Claims", ClaimsDepartment.getInstance());
		departments.put("Travel", TravelDepartment.getInstance());
		departments.put("HR", HRDepartment.getInstance());
		return departments.get(type);
	}
}

interface Department {
	void processRequest(Request request);
}

class ClaimsDepartment implements Department {

	private ClaimsDepartment() {
	}

	private static Department instance;

	public static Department getInstance() {
		if (null == instance) {
			instance = new ClaimsDepartment();
		}
		return instance;
	}

	@Override
	public void processRequest(Request request) {
		System.out.println(
				"Claims Department " + this.hashCode() + " is processing the Request of type - " + request.getType());
	}

}

class HRDepartment implements Department {

	private HRDepartment() {
	}

	private static Department instance;

	public static Department getInstance() {
		if (null == instance) {
			instance = new HRDepartment();
		}
		return instance;
	}

	@Override
	public void processRequest(Request request) {
		System.out.println(
				"HR Department " + this.hashCode() + " is processing the Request of type - " + request.getType());
	}

}

class TravelDepartment implements Department {

	private TravelDepartment() {
	}

	private static Department instance;

	public static Department getInstance() {
		if (null == instance) {
			instance = new TravelDepartment();
		}
		return instance;
	}

	@Override
	public void processRequest(Request request) {
		System.out.println(
				"Travel Department " + this.hashCode() + " is processing the Request of type - " + request.getType());
	}

}

class Request {
	private String type;

	public Request(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
