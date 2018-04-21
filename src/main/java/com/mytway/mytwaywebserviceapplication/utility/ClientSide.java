package com.mytway.mytwaywebserviceapplication.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
 
import org.json.JSONObject;

public class ClientSide {
 
    public static void main(String[] args) {
        String message = "";
        try {

            message = "{\n" +
"    \"userId\" : \"1\",\n" +
"    \"userName\" : \"michalek\",\n" +
"    \"email\" : \"bubu@bubu.pl\",\n" +
"    \"password\" : \"wwww\",\n" +
"    \"typeWork\" : \"1\",\n" +
"    \"lengthTimeWork\" : \"8\",\n" +
"    \"startStandardTimeWork\" : \"7\",\n" +
"    \"workPlaceLatitude\" : \"2.23232\",\n" +
"    \"workPlaceLongitude\" : \"4.23232\",\n" +
"    \"homePlaceLatitude\" : \"1.23232\",\n" +
"    \"homePlaceLongitude\" : \"3.2323232\",\n" +
"    \"workWeek\" : \"100101010\"\n" +
"}";
            
        String msg2 =  "{\n" +"\"userName\":\"mike\",\"email\":\"mike@dude.com\",\"password\":\"2312321\",\"typeWork\":\"2\",\"lengthTimeWork\":\"8:0\",\"startStandardTimeWork\":\"8:0\",\"workPlaceLatitude\":\"50.032825797471105\",\"workPlaceLongitude\":\"19.93930846452713\",\"homePlaceLatitude\":\"50.0570656\",\"homePlaceLongitude\":\"20.8952844\",\"workWeek\":\"1111100\",\"wayDistance\":\"68.31693745916618\",\"wayDuration\":\"0\""+
                "}";
            
        String searchUser = "{\n" +
"    \"userName\" : \"mike\",\n" +
"}";
            
       String messageCheckUserNameAndPassword = "{userName : \"mike\", password : \"2312321\"}"; 
            
            
            JSONObject jsonObject = new JSONObject(msg2);
            System.out.println(jsonObject);

            // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL("http://localhost:8084/MytwayWebServiceApplication/rest/database/updateUser");
//                URL url = new URL("http://localhost:8084/MytwayWebServiceApplication/rest/database/insertUser");
//                URL url = new URL("http://michalburmz5.nazwa.pl/MytwayWebServiceApplication/rest/database/insertUser");
//                URL url = new URL("http://michalburmz5.nazwa.pl/MytwayWebServiceApplication/rest/database/checkUserName");
//                URL url = new URL("http://localhost:8084/MytwayWebServiceApplication/rest/database/checkUserName");
//                URL url = new URL("http://localhost:8084/MytwayWebServiceApplication/rest/database/checkUserAndPassword");
//                URL url = new URL("http://localhost:8084/MytwayWebServiceApplication/rest/database/getUser");
                
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                
                System.out.println("Json: " + jsonObject);
                
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(jsonObject.toString());
                out.close();
                
                //Poprawny sposob odbierania Response od web Servicu
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String output;
                 while ((output = br.readLine()) != null) {
			System.out.println("test: "+output);
		}  
                System.out.println("\n Mytway REST Service Invoked Successfully..");
                br.close();
            } catch (Exception e) {
                System.out.println("\n Error while calling Mytway REST Service");
                System.out.println("e: " + e);
            }

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
} 
