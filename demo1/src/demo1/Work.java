package demo1;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Work extends JFrame {
	JButton button;
	JLabel label;
	
	public Work() {
		super("Set Picture into JLabel using FIleChooser in java");
		button = new JButton("Browse");
		button.setBounds(300, 300, 100, 40);
		label = new JLabel("Insert pics here");
		label.setBounds(10,10,670,250);
		add(button);
		add(label);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "gif", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					 File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					label.setIcon(ResizeImage(path));
				}
				else if(result == JFileChooser.CANCEL_OPTION) {
					System.out.println("No File selected");
					
				}
			}
		});
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700,400);
		setVisible(true);
	}
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	
	public static void main(String[] args){
		new Work();
	}
	
}
