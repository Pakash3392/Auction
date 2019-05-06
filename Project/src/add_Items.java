import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class add_Items implements ActionListener {
	
// calling all the objects 
	private JFrame frame;
	private JTextField itemNametextField;
	private JTextField pricetextField;
	private JTextArea descriptiontextArea;
	private JComboBox<Integer> timercomboBox;
	
	
	private JLabel itemNamelbl;
	private JLabel pricelbl;
	private JLabel timerlbl;
	private JLabel descriptionlbl;
	
	private JButton savebtn;
	private JButton cancelbtn;
	
	

	/**
	 * Launch the application.
	 * 	// call main to run the program 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_Items window = new add_Items();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public add_Items() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// set and organize frame 
		frame = new JFrame();
		frame.setBackground(new Color(0, 255, 255));
		frame.setForeground(new Color(0, 0, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hg2128yd\\Documents\\wooden_gavel_against_old_dirty_background_burned_on_edges.jpg"));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(100, 100, 681, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		addListner();
		setVisible(true);
		
		// designing JPanel 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		
		// calling and designing logout button. 
		JButton logoutbtl = new JButton("Logout ");
		logoutbtl.setBackground(SystemColor.activeCaptionBorder);
		logoutbtl.setBounds(552, 45, 89, 29);
		logoutbtl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(logoutbtl);
		
		// calling and designing save button. 
		JButton savebtn = new JButton("Save ");
		savebtn.setBackground(SystemColor.activeCaptionBorder);
		savebtn.setBounds(401, 463, 89, 23);
		panel.add(savebtn);
		
		// calling and designing  cancel button. 
		JButton cancelbtn = new JButton("Cancel ");
		cancelbtn.setBackground(SystemColor.activeCaptionBorder);
		cancelbtn.setBounds(510, 463, 89, 23);
		panel.add(cancelbtn);
		
		// calling action home label and set size front for label 
		JLabel auctionHomeLbl = new JLabel("Auction Home ");
		auctionHomeLbl.setBounds(76, 0, 427, 74);
		auctionHomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 58));
		panel.add(auctionHomeLbl);
		
		// calling itemname label and set size front for label 
		JLabel itemNamelbl = new JLabel("Item Name :");
		itemNamelbl.setBounds(301, 163, 79, 14);
		panel.add(itemNamelbl);
		
		// calling item label and set size front for label 
		JLabel pricelbl = new JLabel("Price:");
		pricelbl.setBounds(301, 206, 79, 14);
		panel.add(pricelbl);
		
		// calling timer label and set size front for label 
		JLabel timerlbl = new JLabel("Timer:");
		timerlbl.setBounds(301, 252, 79, 14);
		panel.add(timerlbl);
		
		// calling description label and set size front for label 
		JLabel descriptionlbl = new JLabel("Description:");
		descriptionlbl.setBounds(301, 299, 79, 14);
		panel.add(descriptionlbl);
		
		// making textfield obj and calling itemnameTextfield. 
		itemNametextField = new JTextField();
		itemNametextField.setBackground(Color.WHITE);
		itemNametextField.setBounds(365, 160, 86, 20);
		panel.add(itemNametextField);
		itemNametextField.setColumns(10);
		
		// making textfield obj and calling priceTextfield. 
		pricetextField = new JTextField("$");
		pricetextField.setBounds(365, 203, 86, 20);
		panel.add(pricetextField);
		pricetextField.setColumns(10);
		
		// making and calling descriptiontextArea
		JTextArea descriptiontextArea = new JTextArea();
		descriptiontextArea.setBounds(311, 319, 288, 115);
		panel.add(descriptiontextArea);
		
		// making and calling timercomboBox
		JComboBox timercomboBox = new JComboBox();
		timercomboBox.setBackground(SystemColor.activeCaptionBorder);
		timercomboBox.setBounds(365, 249, 28, 20);
		panel.add(timercomboBox);
	}
	
	
	public void timer(TimerTask task, Date firstTime,longperiod) {
		
		
		
	}
	
	private void addListner() {
//		savebtn.addActionListener(this);
//		cancelbtn.addActionListener(this);
//		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand().equals("Save")) {
			 
			// add item into the list of array 
		 }
		 
		 
		  if (e.getActionCommand().equals("Cancel")) {
			setVisible(false);
			add_Items.main(null);
			 
		 }
		
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


}