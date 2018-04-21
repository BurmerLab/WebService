package com.mytway.mytwaywebserviceapplication.webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytway.mytwaywebserviceapplication.pojo.UserTable;
import com.mytway.mytwaywebserviceapplication.utility.model.UserTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import org.apache.log4j.Logger;
 
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
@Path("database/")
public class JsonWebservice {
 
    private final static Logger logger = Logger. getLogger(JsonWebservice.class);
    
    @POST
    @Path("/insertUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertUserToDatabase(InputStream incomingData) throws Exception {
        
        logger.info("Started webservice: insertUserToDatabase from url /database/insertUser");
        StringBuilder jsonFromRequestBuilder = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        UserTableModel userTableModel = new UserTableModel();
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                    jsonFromRequestBuilder.append(line);
            }
        } catch (Exception e) {
            logger.error("Error with parsing - ", e);
        }

        logger.info("Parsing ended, json: " + jsonFromRequestBuilder.toString());
        
        UserTable userTable = null;
        try {
            System.out.println("DANE: " + jsonFromRequestBuilder.toString());
            userTable = mapper.readValue(jsonFromRequestBuilder.toString(), UserTable.class);
            logger.info("Ended parsing json to UserTable object");
            userTableModel.insertUserTableDataFromRequestToDatabase(userTable);
            logger.info("Inserting user to DB seems correct");
        } catch (IOException e) {
            logger.error("Error with saving user to database: ", e);
        }
        logger.info("Ended webservice: insertUserToDatabase from url /database/insertUser");
        return Response.status(200).entity(jsonFromRequestBuilder.toString()).build();
    }
    
    @POST
    @Path("/updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserToDatabase(InputStream incomingData) throws Exception {
        
        logger.info("Started webservice: updateUserToDatabase from url /database/updateUser");
        StringBuilder jsonFromRequestBuilder = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        UserTableModel userTableModel = new UserTableModel();
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                    jsonFromRequestBuilder.append(line);
            }
        } catch (Exception e) {
            logger.error("Error with parsing - ", e);
        }

        logger.info("Parsing ended, json: " + jsonFromRequestBuilder.toString());
        
        UserTable userTable = null;
        try {
            System.out.println("DANE: " + jsonFromRequestBuilder.toString());
            userTable = mapper.readValue(jsonFromRequestBuilder.toString(), UserTable.class);
            logger.info("Ended parsing json to UserTable object");
            userTableModel.updateUserTableDataFromRequestToDatabase(userTable);
            logger.info("Inserting user to DB seems correct");
        } catch (IOException e) {
            logger.error("Error with saving user to database: ", e);
        }
        logger.info("Ended webservice: updateUserToDatabase from url /database/updateUser");
        return Response.status(200).entity(jsonFromRequestBuilder.toString()).build();
    }

//    http://localhost:8084/MytwayWebServiceApplication/rest/database/verify
    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRESTService() {
        logger.info("Started webservice: insertUserToDatabase from url /database/verify");
        String result = "Mytway webservice Successfully started..";
        
        logger.info("Ended webservice: insertUserToDatabase from url /database/verify");
        return Response.status(200).entity(result).build();
    }
    
    
    @POST
    @Path("/checkUserName")
    @Consumes(MediaType.APPLICATION_JSON)
    public String isUserNameExistInExternalDatabaseByMytwayWebservice(InputStream incomingData) throws Exception {
        
        logger.info("Started webservice: isUserNameExistInExternalDatabaseByMytwayWebservice from url /database/checkUserName");
        StringBuilder jsonFromRequestBuilder = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        UserTableModel userTableModel = new UserTableModel();
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                    jsonFromRequestBuilder.append(line);
            }
                
        } catch (Exception e) {
            logger.error("Error with parsing - ",e);
        }

        logger.info("Parsing ended, json: " + jsonFromRequestBuilder.toString());
        
        UserTable userTable = null;
        boolean isUserNameExist = false;
        try {
            System.out.println("DANE: " + jsonFromRequestBuilder.toString());
            userTable = mapper.readValue(jsonFromRequestBuilder.toString(), UserTable.class);
            isUserNameExist = userTableModel.isUserNameExistInDatabase(userTable.getUserName());
            logger.info("WebService returned: " + isUserNameExist);
        } catch (IOException e) {
            logger.error("Error with saving user to database: ", e);
        }
        logger.info("Ended webservice: checkUserName from url /database/insertUser");
//        return Response.status(200).entity(jsonFromRequestBuilder.toString()).build();

        JSONObject json=new JSONObject();
        json.put("isUserNameExistInTable" , isUserNameExist);

        return json.toString();
    }            
    
    @POST
    @Path("/checkUserAndPassword")
    @Consumes(MediaType.APPLICATION_JSON)
    public String isUserNameAndPasswordIsCorrectInExternalDatabaseByMytwayWebservice(InputStream incomingData) throws Exception {
        
        logger.info("Started webservice: isUserNameAndPasswordIsCorrectInExternalDatabaseByMytwayWebservice from url /database/checkUserAndPassword");
        StringBuilder jsonFromRequestBuilder = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        UserTableModel userTableModel = new UserTableModel();
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                    jsonFromRequestBuilder.append(line);
            }
                
        } catch (Exception e) {
            logger.error("Error with parsing - ",e);
        }

        logger.info("Parsing ended, json: " + jsonFromRequestBuilder.toString());
        
        UserTable userTable = null;
        boolean isUserNameAndPasswordIsCorrect = false;
        
        try {
            System.out.println("DANE: " + jsonFromRequestBuilder.toString());
            
            userTable = mapper.readValue(jsonFromRequestBuilder.toString(), UserTable.class);
            isUserNameAndPasswordIsCorrect = userTableModel.isUserNameAndPasswordIsCorrectInDatabase(userTable.getUserName(), userTable.getPassword());
            
            logger.info("WebService returned: " + isUserNameAndPasswordIsCorrect);
        } catch (IOException e) {
            logger.error("Wrror with checkin user name and password", e);
        }
        logger.info("Ended webservice: checkUserAndPassword from url /database/checkUserAndPassword");
//        return Response.status(200).entity(jsonFromRequestBuilder.toString()).build();

        JSONObject json=new JSONObject();
        json.put("isUserNameAndPasswordCorrect" , isUserNameAndPasswordIsCorrect);

        return json.toString();
    }    
    
    @POST
    @Path("/getUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getUserParameters(InputStream incomingData) throws Exception {
        
        logger.info("Started webservice: getUserParameters from url /database/getUser");
        StringBuilder jsonFromRequestBuilder = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        UserTableModel userTableModel = new UserTableModel();
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                    jsonFromRequestBuilder.append(line);
            }
                
        } catch (Exception e) {
            logger.error("Error with parsing - ",e);
        }

        logger.info("Parsing ended, json: " + jsonFromRequestBuilder.toString());
        
        UserTable userTable = null;
        UserTable user = new UserTable();
        
        try {
//            System.out.println("DANE: " + jsonFromRequestBuilder.toString());
            
            userTable = mapper.readValue(jsonFromRequestBuilder.toString(), UserTable.class);
            user = userTableModel.getUserFromDatabase(userTable.getUserName(), userTable.getPassword());
            
            logger.info("WebService returned: " + user);
        } catch (IOException e) {
            logger.error("Wrror with checkin user name and password", e);
        }
        logger.info("Ended webservice: getUserParameters from url /database/getUser");

        JSONObject json=new JSONObject();
        json.put("userName" , user.getUserName());
        json.put("email" , user.getEmail());
        json.put("typeWork" , user.getTypeWork());
        json.put("lengthTimeWork" , user.getLengthTimeWork());
        json.put("startStandardTimeWork" , user.getStartStandardTimeWork());
        json.put("workPlaceLatitude" , user.getWorkPlaceLatitude());
        json.put("workPlaceLongitude" , user.getWorkPlaceLongitude());
        json.put("homePlaceLatitude" , user.getHomePlaceLatitude());
        json.put("homePlaceLongitude" , user.getHomePlaceLongitude());
        json.put("workWeek" , user.getWorkWeek());
        json.put("wayDistance" , user.getWayDistance());
        json.put("wayDuration" , user.getWayDuration());
        
        return json.toString();
    } 
}
