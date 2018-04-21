package com.mytway.mytwaywebserviceapplication.utility.model;

import com.mytway.mytwaywebserviceapplication.pojo.UserTable;
import com.mytway.mytwaywebserviceapplication.utility.database.dao.Database;
import com.mytway.mytwaywebserviceapplication.utility.database.dao.UserTableDAO;
import com.mytway.mytwaywebserviceapplication.webservices.JsonWebservice;
import java.sql.Connection;
import org.apache.log4j.Logger;

public class UserTableModel {
    
    private final static Logger logger = Logger. getLogger(UserTableModel.class);
    
    public void insertUserTableDataFromRequestToDatabase(UserTable userTable) throws Exception{
        try {
            Database database = new Database();
            Connection connection = database.GetConnection();
            
            UserTableDAO userTableDAO = new UserTableDAO();
            userTableDAO.insertUserToExternalDatabase(connection, userTable);

        } catch (Exception e) {
            logger.error("Error with inserting user table data from request to database: ", e);
            throw e;
        }
    }
    
    public void updateUserTableDataFromRequestToDatabase(UserTable userTable) throws Exception{
        try {
            Database database = new Database();
            Connection connection = database.GetConnection();
            
            UserTableDAO userTableDAO = new UserTableDAO();
            userTableDAO.updateUserTable(connection, userTable);

        } catch (Exception e) {
            logger.error("Error with updating user table data from request to database: ", e);
            throw e;
        }
    }
    
    public boolean isUserNameExistInDatabase(String userName) throws Exception{
        
        boolean isUserNameExist = false;
        
        try {
            Database database = new Database();
            Connection connection = database.GetConnection();
            
            UserTableDAO userTableDAO = new UserTableDAO();
            isUserNameExist = userTableDAO.isUserNameExistInExternalDatabase(connection, userName);
        } catch (Exception e) {
            logger.error("Error with inserting user table data from request to database: ", e);
            throw e;
        }
        
        return isUserNameExist;
    }
    
     public boolean isUserNameAndPasswordIsCorrectInDatabase(String userName, String userPassword) throws Exception{
        
        boolean isUserNameAndPasswordIsCorrect = false;
        
        try {
            Database database = new Database();
            Connection connection = database.GetConnection();
            
            UserTableDAO userTableDAO = new UserTableDAO();
            isUserNameAndPasswordIsCorrect = userTableDAO.isUserNameAndPasswordIsCorrectInExternalDatabase(connection, userName, userPassword);
        } catch (Exception e) {
            logger.error("Error with inserting user table data from request to database: ", e);
            throw e;
        }
        
        return isUserNameAndPasswordIsCorrect;
    }
     
    public UserTable getUserFromDatabase(String userName, String userPassword) throws Exception{
        
        UserTable userTable = new UserTable();
        try {
            Database database = new Database();
            Connection connection = database.GetConnection();
            
            UserTableDAO userTableDAO = new UserTableDAO();
            userTable = userTableDAO.getUserFromExternalDatabase(connection, userName, userPassword);
        } catch (Exception e) {
            logger.error("Error with getting user parameters from external database : ", e);
            throw e;
        }
        
        return userTable;
    }
        
    public void selectUserTableDataFromRequestToDatabase(UserTable userTable) throws Exception{
        try {
            Database database = new Database();
            Connection connection = database.GetConnection();
            
            UserTableDAO userTableDAO = new UserTableDAO();
            userTableDAO.insertUserToExternalDatabase(connection, userTable);

        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}
