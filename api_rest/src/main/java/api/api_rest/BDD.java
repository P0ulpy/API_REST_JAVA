package api.api_rest;

import java.sql.Connection;
import java.sql.DriverManager;

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
                "root", // Nom d'utlisateur 
                "" // Mot de passe
            );

            connection = con;

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return connection;
    }

}