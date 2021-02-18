package api.api_rest.ClientsManagement;

import java.util.List;

public class ClientsManager {
    
	public static String getClients()
	{
		List<Client> clients = BDD.getClients();

		System.out.println(clients.toString());

		String jsonString = "[";

		for(Client client : clients)
		{
			jsonString += client.toJSONstring();
		}

		jsonString += "]";

		return jsonString;
	}
}