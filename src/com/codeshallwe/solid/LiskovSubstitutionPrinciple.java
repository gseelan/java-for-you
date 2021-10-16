package com.codeshallwe.solid;

public class LiskovSubstitutionPrinciple {

	public static void main(String[] args) {
		iPermanentEmployee emp = new PermanentEmployee();
		emp.accessMeetingRoom();
		emp.accessOfficeGym();
		iContractors emp1 = new Contractor();
		emp1.accessMeetingRoom();
		//emp1.accessOfficeGym();// This Op is not supported anymore.
	}

}

//The accesses Office Gym and Meeting room are separate capabilitites. Let's segregate them out
interface GymAccess {
	void accessOfficeGym();
}

interface MeetingRoomAccess {

	// define the behaviors allowed
	void accessMeetingRoom();
}

//Let's have separate types for Permanent Employees and Contractors
interface iPermanentEmployee extends GymAccess, MeetingRoomAccess {

}

interface iContractors extends MeetingRoomAccess {

}

//Let's have a type Employee
interface Employee {

}

//Implement for Permanent employee
class PermanentEmployee implements iPermanentEmployee {

	@Override
	public void accessMeetingRoom() {
		System.out.println("Welcome to Meeting Room");
	}

	@Override
	public void accessOfficeGym() {
		System.out.println("Welcome to Office Gym");
	}

}

//let's implement Contractor
class Contractor implements iContractors {

	@Override
	public void accessMeetingRoom() {
		System.out.println("Welcome to Meeting Room");
	}

}
