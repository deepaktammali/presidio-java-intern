package lab.interfaceandpackage;

public class Q1 {
	public static void main(String[] args) {
		SalesManager salesManager = new SalesManager("JohnDoe", "asdasfnsudgd", 1026505005);
		
		System.out.println("Name : "+salesManager.getName());
		System.out.println("Department : "+salesManager.getDepartment());
		System.out.println("EmployeeId : "+salesManager.getEmp_id());
		System.out.println("Salary : "+salesManager.getSalary());
	}
}

abstract class Employee {
	private String name;
	private String emp_id;
	private String department;
	private int salary;

	public Employee(String name, String emp_id, int salary, String department) {
		this.name = name;
		this.emp_id = emp_id;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}

abstract class Prod extends Employee {
	public Prod(String name, String emp_id, int salary) {
		super(name, emp_id, salary, "Prod");
	}
}

class Worker extends Prod {
	public Worker(String name, String emp_id, int salary) {
		super(name, emp_id, salary);
	}
}

abstract class Sales extends Employee {
	public Sales(String name, String emp_id, int salary) {
		super(name, emp_id, salary, "Sales");
	}
}

class SalesPerson extends Sales {
	public SalesPerson(String name, String emp_id, int salary) {
		super(name, emp_id, salary);
	}
}

class SalesManager extends Sales {
	public SalesManager(String name, String emp_id, int salary) {
		super(name, emp_id, salary);
	}
}

class SalesTerritory extends Sales {
	public SalesTerritory(String name, String emp_id, int salary) {
		super(name, emp_id, salary);
	}
}

class Manager extends Sales {
	public Manager(String name, String emp_id, int salary) {
		super(name, emp_id, salary);
	}
}
