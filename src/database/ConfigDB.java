package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public static Connection obgConnection = null;

    public static Connection openConnection () {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/usuarios_db";
            String user = "root";
            String password = "1033Sebas";

            obgConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        }catch (ClassNotFoundException error){
            System.out.println("Driver no instalado" + error.getMessage());
        }catch (SQLException error){
            System.out.println("error al conectar a la base de datos" + error.getMessage());
        }
        return obgConnection;

    }
    public static void closeConnection(){
        try{
            if(obgConnection !=null){
                obgConnection.close();
                System.out.println("Se ha finalizado la conexion");
            }
        }catch (SQLException error) {
            System.out.println("Error" + error.getMessage());
            }
    }
}
