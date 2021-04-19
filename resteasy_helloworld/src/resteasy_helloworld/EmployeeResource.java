package resteasy_helloworld;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/employee")
public class EmployeeResource {
	
	@GET
	@Produces("application/xml")
	public Employee getRandomEmployeeData() {
		return new Employee("<insert_random_name>", (int)(Math.random()*20));
	}
	
	@GET
	@Produces("application/xml")
	@Path("/xml")
	public Employee getEmployeeXMLWithPostData(@QueryParam("id") int id,@QueryParam("name") String name) {
		return new Employee(name, id);
	}
	
	@GET
	@Produces("application/xml")
	@Path("/list")
	public ArrayList<Employee> getEmployeeXMLWithPostData() {
		ArrayList<Employee> employees = new ArrayList<>(5);
		employees.add(new Employee("a", 1));
		employees.add(new Employee("b", 2));
		employees.add(new Employee("c", 3));
		return employees;
	}
	
}

@XmlRootElement
class Employee{
	String name;
	int id;
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

