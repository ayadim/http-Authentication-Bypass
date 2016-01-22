package model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

public class Http_Authentication_basic {

	public  boolean checkAuthentication(String link,String username,String password) {
		
		boolean exist = false;
		try {                	
        	URL url = new URL (link);
            Base64 coder = new Base64();
            String userAndPass = username.trim() + ":" + password.trim();
            System.out.println(userAndPass);
            String encoding = coder.encodeAsString(new String(userAndPass).getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            System.out.println(connection.getResponseCode());
            //if you get 200 response that's mean you have an authenication / case 401 you haven't :(
            exist = (connection.getResponseCode()==200)?true:false;
//            //show the content 
//            InputStream content = (InputStream)connection.getInputStream();
//            BufferedReader in   = 
//                new BufferedReader (new InputStreamReader (content));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch(Exception e) {
            e.printStackTrace();
        }
		
		return exist;
	}
}
