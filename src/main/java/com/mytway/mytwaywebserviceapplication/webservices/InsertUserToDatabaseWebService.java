package com.mytway.mytwaywebserviceapplication.webservices;
 
import com.mytway.mytwaywebserviceapplication.pojo.UserTable;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/database/insert")
public class InsertUserToDatabaseWebService {
 
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();
    }
        
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public UserTable getUserTableFromJSON() {

        UserTable userTable = new UserTable();




        return userTable;

    }
        
        
 
}