package api.api_rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api.api_rest.ClientsManagement.Client;
import api.api_rest.ClientsManagement.ClientsManager;

@Path("/")
public class Routes {

    @GET
    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public String clients() 
    {
        return ClientsManager.getClients();
    }

    @GET
    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String client(@PathParam("id") int id) 
    {
        return ClientsManager.getClient(id);
    }

    @DELETE
    @Path("/deleteClient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteClient(@PathParam("id") int id) 
    {
        return ClientsManager.deleteClient(id);
    }

    @POST
    @Path("/addClient")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // recuperer les données du body de la requete
    public String addClient(Client client) 
    {
        return ClientsManager.addClient(client);
    }

    @PUT
    @Path("/alterClient/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // recuperer les données du body de la requete
    public String alterClient(@PathParam("id") int id, Client client) {
        
        return ClientsManager.alterClient(id, client);
    }
}