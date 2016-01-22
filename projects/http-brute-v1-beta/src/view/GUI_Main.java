package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Control.Control;
import model.Feed;
import model.FeedMessage;

public class GUI_Main {

	private Control c_main;
	private JTextArea textAreaDescription;
	private JTextField txtSearching;
	private JTextArea textAreaDateUpdate;

	private JFrame frmSecurityFeeds;


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
		

		frmSecurityFeeds = new JFrame();
		frmSecurityFeeds.setIconImage(Toolkit.getDefaultToolkit().getImage(Gui_Main.class.getResource("/img/Security_Approved.png")));
		frmSecurityFeeds.getContentPane().setBackground(Color.WHITE);
		frmSecurityFeeds.setBounds(100, 100, 911, 687);
		frmSecurityFeeds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSecurityFeeds.setJMenuBar(menuBar);
		
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
		frmSecurityFeeds.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 905, 638);
		frmSecurityFeeds.getContentPane().add(tabbedPane);
		
		JPanel panelExploit = new JPanel();
		panelExploit.setBorder(new CompoundBorder());
		panelExploit.setToolTipText("");
		panelExploit.setBackground(Color.WHITE);
		tabbedPane.addTab("Security Feeds", null, panelExploit, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelExploit.setLayout(null);
		
		JScrollPane scrollPaneAreaTextForDescription = new JScrollPane();
		scrollPaneAreaTextForDescription.setBounds(66, 479, 768, 107);
		scrollPaneAreaTextForDescription.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		panelExploit.add(scrollPaneAreaTextForDescription);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setForeground(new Color(0, 255, 0));
		textAreaDescription.setBackground(Color.BLACK);
		scrollPaneAreaTextForDescription.setViewportView(textAreaDescription);
		initialiseTextAreas(textAreaDescription);

		
		JLabel lblTabTitle = new JLabel("HTTP BRUTE");
		lblTabTitle.setFont(new Font("Arial", Font.BOLD, 19));
		lblTabTitle.setBounds(378, 47, 144, 28);
		lblTabTitle.setForeground(new Color(51, 102, 153));
		panelExploit.add(lblTabTitle);
		
		txtSearching = new JTextField(" ");
		txtSearching.setBounds(66, 132, 768, 49);
		txtSearching.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSearching.setBorder(BorderFactory.createLineBorder(Color.decode("#c2c2c2")));
		panelExploit.add(txtSearching);
		txtSearching.setColumns(10);
		
		textAreaDateUpdate = new JTextArea();
		textAreaDateUpdate.setBounds(702, 130, 143, 15);
		initialiseTextAreas(textAreaDateUpdate);
		panelExploit.add(textAreaDateUpdate);
		
		JLabel lblLink = new JLabel("Link :");
		lblLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLink.setBounds(66, 116, 46, 14);
		panelExploit.add(lblLink);
		
		JLabel lblOptions = new JLabel("options :");
		lblOptions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOptions.setBounds(66, 229, 46, 14);
		panelExploit.add(lblOptions);
		
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
				//Control.openLinkInBrowser("https://github.com/ayadim/SecurityFeeds");
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
		
		frmSecurityFeeds.setTitle("Security Feeds");
		frmSecurityFeeds.setResizable(false);
//		frmSecurityFeeds.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("PATH/TO/YourImage.png")));
		frmSecurityFeeds.setLocationRelativeTo(null);
		frmSecurityFeeds.setVisible(true);
		
//		if(!c_main.getLastestVersion().equals(Control.version))
//			JOptionPane.showMessageDialog(frmSecurityFeeds,c_main.getLastestVersion()+" version is available ! ","Information",JOptionPane.INFORMATION_MESSAGE);
	}

	
	
	
	

	private void initialiseTextAreas(JTextArea textArea) {
	}
	

	


	
	private void clearTextArea(){
		textAreaDateUpdate.setText("");
		textAreaDescription.setText("");

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
