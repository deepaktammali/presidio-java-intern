package resteasy_helloworld;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/greet")
public class Greeting {
		
	@GET
	public Response sayHello() {
		return Response.ok("Hello").build();
	}
	
	@GET
	@Path("/{firstname}")
	public Response sayHelloToPathParam(@PathParam("firstname")String firstName) {
		String greeting = "Hello "+firstName;
		return Response.ok(greeting).build();
	}
	
	@GET
	@Path("/fullname")
	public Response sayHelloToQuery(@QueryParam("firstname") String firstName,@QueryParam("lastname") String lastName) {
		String greeting = "Hello "+firstName+" "+lastName;
		return Response.ok(greeting).build();
	}
	
	@POST
	public Response sayHelloToPost(@FormParam("firstname") String firstName,@FormParam("lastname") String lastName) {
		String greeting = "Hello "+firstName+" "+lastName;
		return Response.ok(greeting).build();
	}
}
