package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.oracle.webservices.internal.api.EnvelopeStyle.Style;

import control.Control;
import javax.swing.JTextPane;



public class GUI_Main {

	private Control c_main;
	private JTextField txtSearching;

	private JFrame frmHttpBypass;
	private JTextField txtWordlistPath;
	private JTextField textField;
	private JTextField txtRequestMethod;
	private JTextPane txtPaneLog;

	/**
	 * Create the application.
	 */
	public GUI_Main(Control ctrl) {
		c_main = ctrl;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frmHttpBypass = new JFrame();
		//frmSecurityFeeds.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Main.class.getResource("/img/Security_Approved.png")));
		frmHttpBypass.getContentPane().setBackground(Color.WHITE);
		frmHttpBypass.setBounds(100, 100, 911, 614);
		frmHttpBypass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		panelBruteForce.setBorder(new CompoundBorder());
		panelBruteForce.setToolTipText("");
		panelBruteForce.setBackground(Color.WHITE);
		tabbedPane.addTab("Brute Force", null, panelBruteForce, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelBruteForce.setLayout(null);
		
		JScrollPane scrollPaneAreaTextForDescription = new JScrollPane();
		scrollPaneAreaTextForDescription.setBounds(66, 319, 768, 203);
		scrollPaneAreaTextForDescription.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		panelBruteForce.add(scrollPaneAreaTextForDescription);
		
		
		txtPaneLog = new JTextPane();
		txtPaneLog.setEditable(false);
		txtPaneLog.setFont(new Font("verdana", Font.PLAIN, 13));
	
		javax.swing.text.Style style = txtPaneLog.addStyle("I'm a Style", null);
        StyleConstants.setForeground(style,Color.decode("#67c14b"));
        StyledDocument doc = txtPaneLog.getStyledDocument();

        try { doc.insertString(doc.getLength(), "Welcome to http authentication basic brute force !  \n",style); }
        catch (BadLocationException e){}

        //StyleConstants.setForeground(style, Color.blue); change color 

//        try { doc.insertString(doc.getLength(), "BLEH",style); }
//        catch (BadLocationException e){}

		scrollPaneAreaTextForDescription.setViewportView(txtPaneLog);
		

		
		JLabel lblTabTitle = new JLabel("HTTP authentication basic brute forcing");
		lblTabTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblTabTitle.setBounds(219, 48, 462, 28);
		lblTabTitle.setForeground(new Color(51, 102, 153));
		panelBruteForce.add(lblTabTitle);
		
		txtSearching = new JTextField(" ");
		txtSearching.setBounds(66, 132, 768, 22);
		txtSearching.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSearching.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		panelBruteForce.add(txtSearching);
		txtSearching.setColumns(10);
		
		JLabel lblLink = new JLabel("Link :");
		lblLink.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLink.setBounds(66, 116, 46, 14);
		panelBruteForce.add(lblLink);
		
		JLabel lblOptions = new JLabel("Wordllist Path :");
		lblOptions.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblOptions.setBounds(66, 211, 112, 14);
		panelBruteForce.add(lblOptions);
		
		txtWordlistPath = new JTextField(" ");
		txtWordlistPath.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtWordlistPath.setColumns(10);
		txtWordlistPath.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		txtWordlistPath.setBounds(66, 228, 768, 22);
		panelBruteForce.add(txtWordlistPath);
		
		textField = new JTextField(" ");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		textField.setBounds(164, 275, 128, 15);
		panelBruteForce.add(textField);
		
		txtRequestMethod = new JTextField(" ");
		txtRequestMethod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtRequestMethod.setColumns(10);
		txtRequestMethod.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		txtRequestMethod.setBounds(455, 275, 54, 15);
		txtRequestMethod.setText("GET");
		panelBruteForce.add(txtRequestMethod);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblUsername.setBounds(66, 276, 88, 14);
		panelBruteForce.add(lblUsername);
		
		JLabel lblMethod = new JLabel("Method :");
		lblMethod.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMethod.setBounds(378, 275, 64, 14);
		panelBruteForce.add(lblMethod);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblLog.setForeground(new Color(0, 0, 255));
		lblLog.setBounds(66, 305, 46, 14);
		panelBruteForce.add(lblLog);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnStart.setBackground(new Color(80, 170, 218));
		btnStart.setBounds(680, 272, 154, 23);
		panelBruteForce.add(btnStart);
		
		JPanel panelAbout = new JPanel();
		panelAbout.setToolTipText("");
		panelAbout.setBackground(Color.WHITE);
		tabbedPane.addTab("About", null, panelAbout, null);
		panelAbout.setLayout(null);
		
		JLabel lblAboutAuthor = new JLabel("About Author");
		lblAboutAuthor.setFont(new Font("Arial", Font.BOLD, 17));
		lblAboutAuthor.setForeground(new Color(51, 102, 153));
		lblAboutAuthor.setBounds(395, 244, 109, 31);
		panelAbout.add(lblAboutAuthor);
		
		JLabel lblAyadiMohammed = new JLabel("AYADI Mohammed ");
		lblAyadiMohammed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAyadiMohammed.setBounds(384, 288, 132, 14);
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
		lblAboutApplication.setForeground(new Color(51, 102, 153));
		lblAboutApplication.setFont(new Font("Arial", Font.BOLD, 19));
		lblAboutApplication.setBounds(365, 22, 170, 31);
		panelAbout.add(lblAboutApplication);
		
		JLabel lblSecurityFeeds = new JLabel("Security Feeds");
		lblSecurityFeeds.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecurityFeeds.setBounds(400, 64, 100, 22);
		panelAbout.add(lblSecurityFeeds);
		
		JLabel lblVersion = new JLabel("Version ");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVersion.setBounds(415, 97, 56, 14);
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
		versionValue.setFont(new Font("Tahoma", Font.BOLD, 12));
		versionValue.setBounds(470, 97, 31, 14);
		panelAbout.add(versionValue);
		
		JLabel lblNewLabel_2 = new JLabel("Security feeds is an security software that help you to findout security issues.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(192, 122, 516, 22);
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
		
		JLabel lblNewLabel_4 = new JLabel("To Allah and my friends in Hero Family");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(328, 458, 243, 22);
		panelAbout.add(lblNewLabel_4);
		
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
				tabbedPane.setSelectedIndex(1);
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
		
		frmHttpBypass.setTitle("Http auth Bypass");
		frmHttpBypass.setResizable(false);
//		frmSecurityFeeds.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("PATH/TO/YourImage.png")));
		frmHttpBypass.setLocationRelativeTo(null);
		frmHttpBypass.setVisible(true);
		
//		if(!c_main.getLastestVersion().equals(Control.version))
//			JOptionPane.showMessageDialog(frmSecurityFeeds,c_main.getLastestVersion()+" version is available ! ","Information",JOptionPane.INFORMATION_MESSAGE);
	}

	
	
	
	

	private void initialiseTextAreas(JTextArea textArea) {
	}
	

	


	
	private void clearTextArea(){
		
		txtRequestMethod.setText("GET");
		
	} 
	

	

	
	private void checkForUpdate() {
//		String msg ="";
//		if(c_main.getLastestVersion().equals(Control.version)){
//			msg ="Current version is up-to-date ! ";
//		}else{		
//			msg =c_main.getLastestVersion()+" version is available ! ";					
//		}
//		JOptionPane.showMessageDialog(frmSecurityFeeds,msg,"Information",JOptionPane.INFORMATION_MESSAGE);
	}
}
