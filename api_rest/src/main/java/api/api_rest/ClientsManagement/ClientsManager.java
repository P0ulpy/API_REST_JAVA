package api.api_rest.ClientsManagement;

import java.util.List;

public class ClientsManager {
    
	public static String getClients()
	{
		List<Client> clients = BDD.getClients();

		String jsonString = "[";

		for(Client client : clients)
		{
			jsonString += client.toJSONstring() + ",";
		}

		jsonString += "]";

		return jsonString;
	}

	public static String getClient(int id)
	{
		Client client = BDD.getClient(id);

		if(client != null)
		{
			return client.toJSONstring();
		}

		return "{message : \"no user with this id\"}";
	}

	public static String deleteClient(int id)
	{
		return "{message : \""+ BDD.deleteClient(id) +"\"}";
	}

	public static String addClient(Client client)
	{
		return "{message : \""+ BDD.addClient(client) +"\"}";
	}

	public static String alterClient(int id, Client client)
	{
		return "{message : \""+ BDD.alterClient(id, client) +"\"}";
	}
}