package api.api_rest.ClientsManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BDD {

    private static Connection connection;
    public static Connection getConnection()
    {
        if (connection != null)
        {
            return connection;
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/api_rest_php?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
                "root",
                ""
            );

            connection = con;
        }
        catch (Exception e)
        {
            System.out.println("CONNECTION ERROR : " + e.getMessage());
        }

        return connection;
    }

    public static List<Client> getClients()
    {
        try 
        {
			Connection connection = BDD.getConnection();
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM client");
            
            List<Client> clients = new ArrayList<Client>(); 

            while(result.next())
            {
                clients.add(new Client(result));
            }

            return clients;
		}
		catch(Exception exception)
		{
			System.out.println("get clients error : " + exception.getMessage());
            return null;
		}
    }

    public static Client getClient(int id)
    {
        try 
        {
			Connection connection = BDD.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM client WHERE id = " + id);

            if(result.next())
            {
                return new Client(result);
            }
            
            throw new Exception("no client whith this id");
		}
		catch(Exception exception)
		{
			System.out.println("get client error : " + exception.getMessage());
            return null;
		}
        
    }

    public static String deleteClient(int id)
    {
        try 
        {
			Connection connection = BDD.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM client WHERE id = ?");
            statement.setInt(1, id);

			if(statement.executeUpdate() == 1)
            {
                return "success";
            }
            
            return "can't delete client";
		}
		catch(Exception exception)
		{
			System.out.println("delete client error : " + exception.getMessage());
            return exception.getMessage();
		}
    }

    public static String addClient(Client client)
    {
        try 
        {
			Connection connection = BDD.getConnection();
			PreparedStatement statement = 
            connection.prepareStatement("INSERT INTO client (id, nom, prenom, telephone) VALUES( IF(? IS NULL, id, ?), IF(? IS NULL, nom, ?), IF(? IS NULL, prenom, ?), IF(? IS NULL, telephone, ?))");
            statement.setInt(1, client.id);
            statement.setInt(2, client.id);
            statement.setString(3, client.nom);
            statement.setString(4, client.nom);
            statement.setString(5, client.prenom);
            statement.setString(6, client.prenom);
            statement.setString(7, client.telephone);
            statement.setString(8, client.telephone);
            
			if(statement.executeUpdate() == 1)
            {
                return "success";
            }
            
            return "can't create client";
		}
		catch(Exception exception)
		{
			System.out.println("add client error : " + exception.getMessage());
            return exception.getMessage();
		}
    }

    public static String alterClient(int id, Client client)
    {
        try 
        {
			Connection connection = BDD.getConnection();
			PreparedStatement statement = 
            connection.prepareStatement("UPDATE client SET nom = IF(? IS NULL, nom, ?), prenom = IF(? IS NULL, prenom, ?), telephone = IF(? IS NULL, telephone, ?) WHERE id = ?");
            
            statement.setString(1, client.nom);
            statement.setString(2, client.nom);
            statement.setString(3, client.prenom);
            statement.setString(4, client.prenom);
            statement.setString(5, client.telephone);
            statement.setString(6, client.telephone);
            statement.setInt(7, id);
            
			if(statement.executeUpdate() == 1)
            {
                return "success";
            }
            
            return "can't alter client";
		}
		catch(Exception exception)
		{
			System.out.println("alter client error : " + exception.getMessage());
            return exception.getMessage();
		}
    }
}