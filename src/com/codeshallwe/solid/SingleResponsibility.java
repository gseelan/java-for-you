package com.codeshallwe.solid;

public class SingleResponsibility {

	public static void main(String[] args) {
		AccountsDepartment ad = new AccountsDepartment();
		Employeee emp1 = new Employeee("Tom", EmployeeRole.MANAGER);
		System.out.println(String.format("Paid %s to %s the %s", ad.paySalary(emp1), emp1.getName(), emp1.getRole()));
		Employeee emp2 = new Employeee("Charan", EmployeeRole.CTO);
		System.out.println(String.format("Paid %s to %s the %s", ad.paySalary(emp2), emp2.getName(), emp2.getRole()));
	}

}

//creating Employee class
class Employeee {

	// Adding some state
	private String name;
	private EmployeeRole role;

	// constructor
	protected Employeee(String name, EmployeeRole role) {
		super();
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}

}

enum EmployeeRole {
	MANAGER, DIRECTOR, CTO;
}

class AccountsDepartment {
	// Behavior
	// get the employee and pay
	public Double paySalary(Employeee emp) {
		if (emp.getRole() == EmployeeRole.MANAGER)
			return 50000D;
		else if (emp.getRole() == EmployeeRole.CTO)
			return 75000D;
		return 60000D;
	}
}
