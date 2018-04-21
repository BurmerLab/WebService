package com.mytway.mytwaywebserviceapplication.utility.database.dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Database {
	
    private String driver = "jdbc:postgresql";
//    private String host = "localhost:5469";
//    private String host = "localhost:5432";
    private String host = "michalburmz5.nazwa.pl:5432";
    private String database = "mytway";
    private String userTable = "postgres";
    private String password = "Wojna2ds";
    
//        private final static Logger logger = Logger.getLogger(Database.class);
        
    public Connection GetConnection() throws Exception{
        try{
            String connectionURL = driver + "://" + host + "/" + database;
            Connection connection = null;
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, userTable, password);
            return connection;
        }
        catch (SQLException e){
            throw e;	
        }
        catch (Exception e){
            throw e;	
        }
    }

}
