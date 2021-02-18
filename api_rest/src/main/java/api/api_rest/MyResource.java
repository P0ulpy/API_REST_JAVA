package api.api_rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.jstl.sql.Result;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
    
		try {
			Connection a = BDD.getConnection();
			
			Statement sus = a.createStatement();
			ResultSet sus2 = sus.executeQuery("SELECT * FROM client");
			
			String sustarace = "";
			
			while(sus2.next())
			{
				sustarace += sus2.getString("nom") + "\n";
			}
			
			return sustarace;
		}
		catch(Exception sus)
		{
			return "Got it!" + sus.getMessage();
		}
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String sus(@PathParam("id") int id)
    {
    	return String.valueOf(id);
    }
}