package control;

import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;

import model.Http_Authentication_basic;
import view.GUI_Main;

public class Control {
		public static String version = "1.0";
		
		public Control(){
			
		}
		public boolean bruteForceHttpAuthentication(GUI_Main window,String link,String method,String username,String wordlistPath)
		{
			Http_Authentication_basic bruteforce_http = new Http_Authentication_basic(window, link, method, username, wordlistPath);
			return bruteforce_http.bruteForce();
		}
		public void makeAtestOnMainWindow(GUI_Main window)
		{
			window.appendToLog("input", GUI_Main.blue);
			window.appendToLog("input", GUI_Main.gris);
			window.appendToLog("input", GUI_Main.green);
			window.appendToLog("my msg here ", GUI_Main.red);
			window.appendToLog("so what now", GUI_Main.gris);
			window.appendToLog("what i", GUI_Main.gris);
			window.appendToLog("input", GUI_Main.red);
			window.appendToLog("input", GUI_Main.blue);
			window.appendToLog("input", GUI_Main.gris);
			window.appendToLog("input", GUI_Main.green);
			window.appendToLog("my msg here ", GUI_Main.red);
			window.appendToLog("so what now", GUI_Main.gris);
			window.appendToLog("what i", GUI_Main.gris);
			window.appendToLog("input", GUI_Main.red);
			
		}

		
		public static void openLinkInBrowser(String link)
		{
			try {
				URI url = new URI(link);
				if (Desktop.isDesktopSupported()) {
				        Desktop.getDesktop().browse(url);
			    } 
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		}
		
		public String getUpdateVersion()
		{
			String myUrl = "https://gist.githubusercontent.com/ayadim/a94c4143c5d725d927ed/raw/http-brute.txt";
			// ------------- Get the content
			
			BufferedReader in=null;
			String inputLine ="";
			String myContent = "";
	        try {
				URL url = new URL(myUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				
				connection.setDoOutput(true);	
				 in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while ((inputLine = in.readLine()) != null){ 	
					myContent +=inputLine;
				}
				in.close();
				 
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
			return myContent;
		}
}
