package api.api_rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api.api_rest.ClientsManagement.ClientsManager;

@Path("/")
public class Routes {

    @GET
    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public String clients() {
        return ClientsManager.getClients();
    }

    @GET
    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String client(@PathParam("id") int id) {
        
        return "{a : 10}" + id;
    }

    @DELETE
    @Path("/deleteClient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteClient(@PathParam("id") int id) {
        
        return "{a : 10}" + id;
    }

    @POST
    @Path("/addClient")
    @Produces(MediaType.APPLICATION_JSON)
    // recuperer les données du body de la requete
    public String addClient() {
        
        return "{a : 10}";
    }

    @PUT
    @Path("/alterClient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // recuperer les données du body de la requete
    public String alterClient() {
        
        return "{a : 10}";
    }
}