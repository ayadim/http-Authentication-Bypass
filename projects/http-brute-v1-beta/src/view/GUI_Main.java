package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.apache.commons.codec.binary.Base64;

import control.Control;


import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;



public class GUI_Main {

	public static String green ="#66CDAA";
	public static String red ="#e53939";
	public static String blue ="#2d8bbe";
	public static String gris = "#808080";
	private Control c_main;
	private JTextField txtLink;

	private JFrame frmHttpBypass;
	private JTextField txtWordlistPath;
	private JTextField txtUserName;
	private JTextField txtRequestMethod;
	private JTextPane txtPaneLog;
	public final JFileChooser selectFileChooser = new JFileChooser();
	private String wordlistPath ;
	private JScrollPane scrollPaneAreaForLog;
	private JButton btnStart;
	private JTextField txtVerbLink;
	/**
	 * Create the application.
	 */
	public GUI_Main() {
		c_main = new Control();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		

		frmHttpBypass = new JFrame();
		frmHttpBypass.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Main.class.getResource("/img/Security_Approved.png")));
		//frmSecurityFeeds.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Main.class.getResource("/img/Security_Approved.png")));
		frmHttpBypass.getContentPane().setBackground(Color.WHITE);
		frmHttpBypass.setBounds(100, 100, 911, 614);
		frmHttpBypass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtPaneLog = new JTextPane();
		txtPaneLog.setEditable(false);
		
		txtPaneLog.setFont(new Font("verdana", Font.PLAIN, 13));
	
		//log style 
		javax.swing.text.Style style = txtPaneLog.addStyle("I'm a Style", null);
        StyleConstants.setForeground(style,Color.decode(GUI_Main.green));
        StyledDocument doc = txtPaneLog.getStyledDocument();

        try { doc.insertString(doc.getLength(), "Welcome to http authentication basic brute force !  \n",style); }
        catch (BadLocationException e){}
		
		JMenuBar menuBar = new JMenuBar();
		frmHttpBypass.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setBackground(Color.WHITE);
		mnFile.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemCheckForUpdate = new JMenuItem("Check For Update");
		menuItemCheckForUpdate.setBackground(Color.WHITE);
		mnNewMenu.add(menuItemCheckForUpdate);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Website");
		mntmNewMenuItem.setBackground(Color.WHITE);

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmAbout = new JMenuItem("About");

		mntmAbout.setBackground(Color.WHITE);
		mnNewMenu.add(mntmAbout);
		frmHttpBypass.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 905, 638);
		frmHttpBypass.getContentPane().add(tabbedPane);
		
		JPanel panelBruteForce = new JPanel();
		panelBruteForce.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		panelBruteForce.setToolTipText("");
		panelBruteForce.setBackground(Color.WHITE);
		tabbedPane.addTab("Brute Force", null, panelBruteForce, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelBruteForce.setLayout(null);
		
		scrollPaneAreaForLog = new JScrollPane();
		scrollPaneAreaForLog.setBounds(66, 319, 768, 203);
		scrollPaneAreaForLog.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		panelBruteForce.add(scrollPaneAreaForLog);
		scrollPaneAreaForLog.setViewportView(txtPaneLog);
		

		
		JLabel lblTabTitle = new JLabel("HTTP Authentication Basic Brute Forcing");
		lblTabTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblTabTitle.setBounds(256, 88, 388, 28);
		lblTabTitle.setForeground(Color.GRAY);
		panelBruteForce.add(lblTabTitle);
		
		txtLink = new JTextField(" ");
		txtLink.setBounds(66, 178, 768, 22);
		txtLink.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtLink.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		panelBruteForce.add(txtLink);
		txtLink.setColumns(10);
		
		JLabel lblLink = new JLabel("Link :");
		lblLink.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLink.setBounds(66, 163, 46, 14);
		panelBruteForce.add(lblLink);
		
		JLabel lblOptions = new JLabel("Wordlist Path :");
		lblOptions.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblOptions.setBounds(66, 211, 112, 14);
		panelBruteForce.add(lblOptions);
		
		txtWordlistPath = new JTextField(" ");
		txtWordlistPath.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtWordlistPath.setColumns(10);
		txtWordlistPath.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		txtWordlistPath.setBounds(66, 228, 604, 22);
		panelBruteForce.add(txtWordlistPath);
		
		txtUserName = new JTextField("admin");
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUserName.setColumns(10);
		txtUserName.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		txtUserName.setBounds(164, 275, 128, 22);
		panelBruteForce.add(txtUserName);
		
		txtRequestMethod = new JTextField(" ");
		txtRequestMethod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtRequestMethod.setColumns(10);
		txtRequestMethod.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		txtRequestMethod.setBounds(531, 275, 54, 22);
		txtRequestMethod.setText("GET");
		panelBruteForce.add(txtRequestMethod);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblUsername.setBounds(66, 276, 88, 14);
		panelBruteForce.add(lblUsername);
		
		JLabel lblMethod = new JLabel("Method :");
		lblMethod.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMethod.setBounds(457, 275, 64, 14);
		panelBruteForce.add(lblMethod);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblLog.setForeground(new Color(0, 0, 255));
		lblLog.setBounds(66, 305, 46, 14);
		panelBruteForce.add(lblLog);
		
		GUI_Main mainWindows = this;
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!tabBrutForce())
					return;
				
				
				if (btnStart.getText().equals("Start")){
					txtPaneLog.setText("");
					appendToLog("Start attack please wait ...", GUI_Main.gris);
					btnStart.setText("Attacking ....");
					Thread t = new Thread(new Runnable() {  
					    public void run() {  
					    	boolean result = c_main.bruteForceHttpAuthentication(mainWindows,txtLink.getText() , txtRequestMethod.getText(),txtUserName.getText(),wordlistPath);
					    	if(!result)
					    		appendToLog("Stop attack ..", GUI_Main.red);
					    	btnStart.setText("Start");
					    	return;
					    }  
				
					
					});  
					t.start(); 
				}
				
//				c_main.bruteForceHttpAuthentication(mainWindows,txtLink.getText() , txtRequestMethod.getText(),txtUserName.getText(),wordlistPath);
				
			}


		});
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnStart.setBackground(new Color(102,205,170));
		btnStart.setBounds(680, 272, 154, 23);
		panelBruteForce.add(btnStart);
		
		selectFileChooser.setFileFilter(new FileNameExtensionFilter("text Files", "txt","list"));
		selectFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		
		selectFileChooser.setApproveButtonText("Select");
		
		JButton btnChooseFile = new JButton("Choose file");
		btnChooseFile.setForeground(Color.WHITE);
		btnChooseFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = selectFileChooser.showSaveDialog(btnChooseFile.getParent());				
		        if (returnVal == JFileChooser.OPEN_DIALOG) {
		            File outputFile = selectFileChooser.getSelectedFile();
		            if(returnVal == 0){
		            	txtWordlistPath.setText(outputFile.getAbsolutePath());
				        StyleConstants.setForeground(style, Color.decode(GUI_Main.blue));  
				        wordlistPath = outputFile.getAbsolutePath();

				           try { doc.insertString(doc.getLength(), "File choosed : "+outputFile.getAbsolutePath()+" \n",style); }
				          catch (BadLocationException ex){}
		            }

		        }
			
			};				
				
		});
		btnChooseFile.setBounds(680, 227, 154, 23);
		btnChooseFile.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnChooseFile.setBackground(new Color(80, 170, 218));
//		btnChooseFile.setBounds(680, 272, 154, 23);
		panelBruteForce.add(btnChooseFile);
		
		JPanel panelVerbTampering = new JPanel();
		panelVerbTampering.setBackground(Color.WHITE);
		panelVerbTampering.setToolTipText("Verb Tampering");
		tabbedPane.addTab("Verb Tampering", null, panelVerbTampering, null);
		panelVerbTampering.setLayout(null);
		
		JLabel lblHttpAuthenticationVerb = new JLabel("HTTP Authentication Verb Tampering");
		lblHttpAuthenticationVerb.setForeground(Color.GRAY);
		lblHttpAuthenticationVerb.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblHttpAuthenticationVerb.setBounds(267, 88, 365, 28);
		panelVerbTampering.add(lblHttpAuthenticationVerb);
		
		JComboBox cbxMethods = new JComboBox();
		cbxMethods.setBackground(Color.WHITE);
		cbxMethods.setBounds(38, 156, 90, 22);
		cbxMethods.addItem("GET");
		cbxMethods.addItem("POST");
		cbxMethods.addItem("PUT");
		cbxMethods.addItem("HEAD");
		cbxMethods.addItem("DELETE");
		cbxMethods.addItem("OPTIONS");
		cbxMethods.addItem("TRACE");
		

		panelVerbTampering.add(cbxMethods);
		
		txtVerbLink = new JTextField(" ");
		txtVerbLink.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtVerbLink.setColumns(10);
		txtVerbLink.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		txtVerbLink.setBounds(138, 156, 647, 22);
		panelVerbTampering.add(txtVerbLink);
		
		JTextArea txtVerbData = new JTextArea();
		txtVerbData.setBounds(138, 189, 647, 60);
		txtVerbData.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		txtVerbData.setLineWrap(true);
		panelVerbTampering.add(txtVerbData);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 260, 647, 241);
		panelVerbTampering.add(scrollPane);
		
		JTextPane txtVerbContent = new JTextPane();
		scrollPane.setViewportView(txtVerbContent);
		
		JButton btnVerbGo = new JButton("Go");
		btnVerbGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

	        	URL url = null;
	        	try {
					url = new URL (txtVerbLink.getText());
				} catch (MalformedURLException e) {
					JOptionPane.showMessageDialog(null,"The URL is not formed well try \n Exemple :  http://localhost/file.php .","Information",JOptionPane.INFORMATION_MESSAGE);
					return;
				}

	            HttpURLConnection connection = null;
				try {
		            Base64 coder = new Base64();
		            String encoding = coder.encodeAsString(new String("admin:admin").getBytes());
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestProperty  ("Authorization", "Basic " + encoding);
					connection.setRequestMethod((String) cbxMethods.getSelectedItem());
					
					connection.setDoOutput(true);
					if(((String)cbxMethods.getSelectedItem()).equals("POST"))
					{
						String urlParameters = txtVerbData.getText();
						
						// Send post request
						connection.setDoOutput(true);
						DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
						wr.writeBytes(urlParameters);
						wr.flush();
						wr.close();
					}
					System.out.println("code : " + connection.getResponseCode());
					InputStream content = null;
					if(connection.getResponseCode() != 200)
						content= (InputStream)connection.getErrorStream();
					else
						content= (InputStream)connection.getInputStream();
		            
		            BufferedReader in   =       new BufferedReader (new InputStreamReader (content));
		            //content.close();
		            String line,contentStr;
		            contentStr="";
		            while ((line = in.readLine()) != null) {
		            	contentStr += line + "\n";
		            }
		            txtVerbContent.setText(contentStr);
		            in.close();
//		            connection.disconnect();
		            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMinimum());
		            //txtVerbContent.setContentType("text/html");
		            } catch (IOException e) {

				}

			}
		});
		btnVerbGo.setForeground(Color.WHITE);
		btnVerbGo.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnVerbGo.setBackground(new Color(102, 205, 170));
		btnVerbGo.setBounds(804, 155, 63, 23);
		panelVerbTampering.add(btnVerbGo);
		

		
		JLabel lblNewLabel_5 = new JLabel("Data :");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(89, 187, 39, 14);
		panelVerbTampering.add(lblNewLabel_5);
		
		JLabel lblContent = new JLabel("Content :");
		lblContent.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblContent.setBounds(65, 258, 63, 14);
		panelVerbTampering.add(lblContent);
		
		JTextArea txtVerbContentx = new JTextArea();
		txtVerbContentx.setBounds(38, 260, 645, 239);
		panelVerbTampering.add(txtVerbContentx);
		

		
		JPanel panelAbout = new JPanel();
		panelAbout.setToolTipText("");
		panelAbout.setBackground(Color.WHITE);
		tabbedPane.addTab("About", null, panelAbout, null);
		panelAbout.setLayout(null);
		
		JLabel lblAboutAuthor = new JLabel("About Author");
		lblAboutAuthor.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblAboutAuthor.setForeground(Color.GRAY);
		lblAboutAuthor.setBounds(384, 244, 132, 31);
		panelAbout.add(lblAboutAuthor);
		
		JLabel lblAyadiMohammed = new JLabel("AYADI Mohammed ");
		lblAyadiMohammed.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblAyadiMohammed.setBounds(378, 288, 144, 14);
		panelAbout.add(lblAyadiMohammed);
		
		JLabel lblNewLabel = new JLabel("ayadi.mohamed@outlook.com");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(348, 312, 204, 17);
		panelAbout.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("https://github.com/ayadim");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(360, 343, 180, 17);
		panelAbout.add(lblNewLabel_1);
		
		JLabel lblAboutApplication = new JLabel("About Application");
		lblAboutApplication.setForeground(Color.GRAY);
		lblAboutApplication.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblAboutApplication.setBounds(365, 22, 170, 31);
		panelAbout.add(lblAboutApplication);
		
		JLabel lblSecurityFeeds = new JLabel("Http Authentication Bypass");
		lblSecurityFeeds.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSecurityFeeds.setBounds(344, 64, 212, 22);
		panelAbout.add(lblSecurityFeeds);
		
		JLabel lblVersion = new JLabel("Version ");
		lblVersion.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblVersion.setBounds(411, 97, 60, 14);
		panelAbout.add(lblVersion);
		
		JButton btnCheckForUpdate = new JButton("Check For Updates");
		btnCheckForUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheckForUpdate.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCheckForUpdate.setBounds(373, 166, 154, 23);
		btnCheckForUpdate.setBackground(Color.decode("#50AADA"));
		btnCheckForUpdate.setForeground(Color.white);
		panelAbout.add(btnCheckForUpdate);
		
		JLabel versionValue = new JLabel("1.0");
		versionValue.setForeground(new Color(51, 102, 204));
		versionValue.setFont(new Font("Verdana", Font.PLAIN, 12));
		versionValue.setBounds(470, 97, 27, 14);
		panelAbout.add(versionValue);
		
		JLabel lblNewLabel_2 = new JLabel("Security tool  to bypass http authentication just for education purpose tyr it's in you're own risk .");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(86, 122, 727, 22);
		panelAbout.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("All rights reserved by © ayadi mohammed");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(314, 560, 272, 22);
		panelAbout.add(lblNewLabel_3);
		
		JLabel lblGreeting = new JLabel("Greeting");
		lblGreeting.setForeground(new Color(51, 102, 153));
		lblGreeting.setFont(new Font("Arial", Font.BOLD, 17));
		lblGreeting.setBounds(413, 416, 73, 31);
		panelAbout.add(lblGreeting);
		
		JLabel lblgreetingValue = new JLabel("To Allah");
		lblgreetingValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblgreetingValue.setBounds(420, 458, 60, 22);
		panelAbout.add(lblgreetingValue);
		
		//######################################################################################################
		//###################################################				####################################
		//###################################################	Listenners	####################################
		//###################################################	 			 ###################################
		//######################################################################################################
			
		//---------- menu 
		menuItemCheckForUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkForUpdate();
			}
		});
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control.openLinkInBrowser("https://github.com/ayadim/http-brute-java");
			}
		});
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		

		
		btnCheckForUpdate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkForUpdate();
			}
		});
		
		frmHttpBypass.setTitle("Http Authentication Bypass");
//		frmSecurityFeeds.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("PATH/TO/YourImage.png")));
		frmHttpBypass.setLocationRelativeTo(null);
		frmHttpBypass.setVisible(true);
		
		if(!c_main.getUpdateVersion().equals(Control.version))
			JOptionPane.showMessageDialog(frmHttpBypass,c_main.getUpdateVersion()+" version is available ! ","Information",JOptionPane.INFORMATION_MESSAGE);
	}

	
	
	
	

	private void initialiseTextAreas(JTextArea textArea) {
	}
	
	private void clearTextArea(){		
		txtRequestMethod.setText("GET");		
	} 
	
	public void changeStartBtn()
	{
		btnStart.setText("Start");
	}

	public void appendToLog(String msg,String color) 
	{
		javax.swing.text.Style style = txtPaneLog.addStyle("I'm a Style", null);
		StyleConstants.setForeground(style,Color.decode(color));
        StyledDocument doc = txtPaneLog.getStyledDocument();
        try 
        {
        	 
        	doc.insertString(doc.getLength(), msg +"\n",style);
        }
          catch (BadLocationException ex){}	
//        scrollPaneAreaForLog.getVerticalScrollBar().setValue(scrollPaneAreaForLog.getVerticalScrollBar().getMaximum());
	}

	public void appendToLogInAttack(String old,String msg,String color) 
	{
		txtPaneLog.setText(old);
		javax.swing.text.Style style = txtPaneLog.addStyle("I'm a Style", null);
		StyleConstants.setForeground(style,Color.decode(color));
        StyledDocument doc = txtPaneLog.getStyledDocument();
        try 
        {
        	 
        	doc.insertString(doc.getLength(), msg +"\n",style);
        }
          catch (BadLocationException ex){}	
//        scrollPaneAreaForLog.getVerticalScrollBar().setValue(scrollPaneAreaForLog.getVerticalScrollBar().getMaximum());
	}
	private void checkForUpdate() {
		String msg ="";
		if(c_main.getUpdateVersion().equals(Control.version)){
			msg ="Current version is up-to-date ! ";
		}else{		
			msg =c_main.getUpdateVersion()+" version is available ! ";					
		}
		JOptionPane.showMessageDialog(frmHttpBypass,msg,"Information",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getLog()
	{
		return txtPaneLog.getText();
	}
	
	private boolean tabBrutForce() {
		if(txtLink.getText().equals(" ") || txtRequestMethod.getText().equals(" ") || txtUserName.getText().equals(" ") ||  txtWordlistPath.getText().equals(" "))
		{
			//JOptionPane.showMessageDialog(null,"The URL is not formed well try \n exemple http://localhost/file.php .","Information",JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,"fill the empty fields ","Information",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		try {                	
        	URL url = new URL (txtLink.getText());
		}catch(MalformedURLException e) {
            
            JOptionPane.showMessageDialog(null,"The URL is not formed well try \n Exemple :  http://localhost/file.php .","Information",JOptionPane.INFORMATION_MESSAGE);
            return false;
		}
		return true;
	}
}
