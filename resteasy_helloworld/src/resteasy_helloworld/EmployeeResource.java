package resteasy_helloworld;

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

