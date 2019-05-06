package AuctionHome;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AuctionHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuctionHome window = new AuctionHome();
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
	public AuctionHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAuctionHome = new JLabel("Auction Home");
		lblAuctionHome.setBounds(168, 94, 107, 14);
		frame.getContentPane().add(lblAuctionHome);
	}

}