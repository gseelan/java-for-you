package com.codeshallwe.Comparator;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightPatternDemo {

	public static void main(String[] args) {
		CustomerCare custCare = new CustomerCare();
		custCare.processRequest(new Request("Claims"));
		custCare.processRequest(new Request("Travel"));
		custCare.processRequest(new Request("HR"));
		custCare.processRequest(new Request("Travel"));
		custCare.processRequest(new Request("Claims"));
	}

}

final class CustomerCare {
	private static Map<String, Department> departments = new HashMap<>();

	public void processRequest(Request request) {
		CustomerCare.getDepartment(request.getType()).processRequest(request);
	}

	public static Department getDepartment(String name) {
		departments.put("Claims", ClaimsDepartment.getInstance());
		departments.put("Travel", TravelDepartment.getInstance());
		departments.put("HR", new HRDepartment());
		return departments.get(name);
	}

	public int totalItemsMade() {
		return departments.size();
	}
}

interface Department {
	void processRequest(Request request);
}

final class ClaimsDepartment implements Department {

	private static Department claimsDepartment;

	public static Department getInstance() {
		if (null == claimsDepartment) {
			claimsDepartment = new ClaimsDepartment();
		}
		return claimsDepartment;
	}

	@Override
	public void processRequest(Request request) {
		System.out.println("Claims department with hash code " + this.hashCode() + " process the request of type "
				+ request.getType());
	}
}

final class TravelDepartment implements Department {

	private static Department travelDepartment;

	public static Department getInstance() {
		if (null == travelDepartment) {
			travelDepartment = new TravelDepartment();
		}
		return travelDepartment;
	}

	@Override
	public void processRequest(Request request) {
		System.out.println("Travel department with hash code " + this.hashCode() + " process the request of type "
				+ request.getType());
	}
}

final class HRDepartment implements Department {

	private static Department hRDepartment;

	public static Department getInstance() {
		if (null == hRDepartment) {
			hRDepartment = new HRDepartment();
		}
		return hRDepartment;
	}

	@Override
	public void processRequest(Request request) {
		System.out.println("HR department with hash code " + this.hashCode() + " process the request of type "
				+ request.getType());
	}
}

class Request {

	private String type;

	public Request(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
