/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanli_khach_san.database;

/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class Database {


    static private String database_name="orcl2";
    static private String username="qlks_HQT";
    static private String password="qlks_HQT";
    static private int port = 1521;
    static private String hostname = "localhost";
    static private Connection connection;
    static private boolean is_connected;
    static private String url;


    public Database() {
    }

    static public void initialize(String database_name, String username, String password){
        Database.database_name = database_name;
        Database.password = password;
        Database.username = username;
    }

    static public void initialize(
            String database_name,
            String username,
            String password,
            String hostname,
            int port
    ){
        Database.database_name = database_name;
        Database.hostname = hostname;
        Database.username = username;
        Database.password = password;
        Database.port = port;
    }

    public static void connect(){
        Database.url = "jdbc:oracle:thin:@"
                + Database.hostname
                + ":"
                + Database.port
                + ":"
                + Database.database_name;
        Database.connection = null;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Database.connection = DriverManager.getConnection(url, username, password);
            Database.is_connected = true;
        }
        catch (Exception e){

            e.printStackTrace();
            Database.is_connected = false;
        }
    }

    static public Connection getConnection(){
        connect();
        return Database.connection;
    }

    static public Connection getConnection(String database_name, String username, String password)
    {
        initialize(database_name, username, password);
        connect();
        return Database.connection;
    }

    static public boolean is_connected(){
        return Database.is_connected;
    }
}
