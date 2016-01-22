package control;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Control {

	
		public Control(){
			
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
}
