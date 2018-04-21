package com.mytway.mytwaywebserviceapplication.utility.database.dao;

import com.mytway.mytwaywebserviceapplication.pojo.UserTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;

public class UserTableDAO {
private final static Logger logger = Logger. getLogger(UserTableDAO.class);
    
    public void insertUserToExternalDatabase(Connection connection, UserTable userTable) throws Exception{

        logger.info("Started inserting to Database");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar currentDate = Calendar.getInstance();

        try{
            PreparedStatement ps = connection.prepareStatement(QUERY_PARAMS.INSERT_USER_TABLE_TO_EXTERNAL_DATABASE);
            ps.setString(1, userTable.getUserName());
            ps.setString(2, dateFormat.format(currentDate.getTime()));
            ps.setString(3, userTable.getEmail());
            ps.setString(4, userTable.getPassword());
            ps.setInt(5, userTable.getTypeWork());
            ps.setString(6, userTable.getLengthTimeWork());
            ps.setString(7, userTable.getStartStandardTimeWork());
            ps.setDouble(8, userTable.getWorkPlaceLatitude());
            ps.setDouble(9, userTable.getWorkPlaceLongitude());
            ps.setDouble(10, userTable.getHomePlaceLatitude());
            ps.setDouble(11, userTable.getHomePlaceLongitude());
            ps.setString(12, userTable.getWorkWeek());
            ps.setString(13, "" + userTable.getWayDistance());
            ps.setString(14, "" + userTable.getWayDuration());
            ps.executeUpdate();

        }catch(Exception e){
            logger.error("Error during insert to database: ", e);
            throw e;
        }
        logger.info("End inserting to Database");
    }   
    
    public boolean isUserNameExistInExternalDatabase(Connection connection, String userName) throws Exception{

        logger.info("Started checking username in Database");
        boolean isUserNameExist = false;
        try{
            PreparedStatement ps = connection.prepareStatement(QUERY_PARAMS.IS_USER_NAME_EXIST_IN_DATA_BASE);
            ps.setString(1, userName);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                isUserNameExist = true;
            }
        }catch(Exception e){
            logger.error("Error: ", e);
            throw e;
        }
        
        return isUserNameExist;
    }  
    
       public UserTable getUserFromExternalDatabase(Connection connection, String userName, String userPassword) throws Exception{

        logger.info("Started checking username in Database");
        UserTable userTable = new UserTable();
        try{
            PreparedStatement ps = connection.prepareStatement(QUERY_PARAMS.GET_USER_FROM_DATA_BASE);
            ps.setString(1, userName);
            ps.setString(2, userPassword);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                userTable.setUserName(rs.getString("user_name"));
                userTable.setEmail(rs.getString("email"));
                userTable.setTypeWork(rs.getInt("type_work"));
                userTable.setLengthTimeWork(rs.getString("length_time_work"));
                userTable.setStartStandardTimeWork(rs.getString("start_standard_time_work"));
                userTable.setWorkPlaceLatitude(rs.getDouble("work_place_latitude"));
                userTable.setWorkPlaceLongitude(rs.getDouble("work_place_longitude"));
                userTable.setHomePlaceLatitude(rs.getDouble("home_place_latitude"));
                userTable.setHomePlaceLongitude(rs.getDouble("home_place_longitude"));
                userTable.setWorkWeek(rs.getString("work_week"));
                userTable.setWayDistance(rs.getString("way_distance"));
                userTable.setWayDuration(rs.getString("way_duration"));
            }
        }catch(Exception e){
            logger.error("Error: ", e);
            throw e;
        }
        
        return userTable;
    }  
	
        public boolean isUserNameAndPasswordIsCorrectInExternalDatabase(Connection connection, String userName, String userPassword) throws Exception{

        logger.info("Started checking username in Database");
        boolean isUserNameExist = false;
        try{
            PreparedStatement ps = connection.prepareStatement(QUERY_PARAMS.IS_USER_NAME_AND_PASSWORD_IS_CORRECT_IN_DATA_BASE);
            ps.setString(1, userName);
            ps.setString(2, userPassword);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                isUserNameExist = true;
            }
        }catch(Exception e){
            logger.error("Error: ", e);
            throw e;
        }
        
        return isUserNameExist;
    }  

     public void updateUserTable(Connection connection, UserTable userTable) throws Exception {
/*
         type_work=?,
         length_time_work=?,
         start_standard_time_work=?,
         work_place_latitude=?,"
        + " work_place_longitude=?,
         home_place_latitude=?,
         home_place_longitude=?,
         work_week=?,
         way_distance=?,
         way_duration=?
         WHERE user_name=?
         and password=? 
         */
         
        try{
          PreparedStatement ps = connection.prepareStatement(QUERY_PARAMS.UPDATE_USER_TABLE_TO_EXTERNAL_DATABASE);
          ps.setInt(1, userTable.getTypeWork());
          ps.setString(2, userTable.getLengthTimeWork());
          ps.setString(3, userTable.getStartStandardTimeWork());
          ps.setDouble(4, userTable.getWorkPlaceLatitude());
          ps.setDouble(5, userTable.getWorkPlaceLongitude());
          ps.setDouble(6, userTable.getHomePlaceLatitude());
          ps.setDouble(7, userTable.getHomePlaceLongitude());
          ps.setString(8, userTable.getWorkWeek());
          ps.setString(9, userTable.getWayDistance());
          ps.setString(10, userTable.getWayDuration());
          ps.setString(11, userTable.getUserName());
          ps.setString(12, userTable.getPassword());
          ps.executeUpdate();

        } catch(Exception e){
                throw e;
        }

    }
    
}
