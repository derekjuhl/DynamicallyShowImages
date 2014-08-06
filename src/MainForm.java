import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainForm {
	
	private final String IMG_PATH = "C:\\Users\\stevec\\Workspace\\ImageTest\\Images\\";
	private final int IMAGE_WIDTH=315;
	private final int IMAGE_HEIGHT=670;
	private JFrame frame;
	private JPanel panel;
	private JLabel prompt;
	private JLabel pictureLabel;
	private JTextField numberField;
	private JButton button;
	private JPanel picturePanel;
	private int number=1;
	
	public MainForm(){
		createFrame();
	}

	private void createFrame(){
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(200,200,400,400);
			frame.add(createPanel());
			frame.setVisible(true);
	
		
	}
	
	private JPanel createPanel(){
		panel= new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(createTopPanel(), BorderLayout.NORTH);
         return panel;
	}
	
	private JPanel createTopPanel(){
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		prompt= new JLabel("How many pictures");
		numberField = new JTextField(10);
		
		button = new JButton("Get Pictures");
		button.addActionListener(new PictureListener());
		//pictureLabel = new JLabel();
		
		
         topPanel.add(prompt);
         topPanel.add(numberField);
         topPanel.add(button);
         
         return topPanel;
	}
	
	
	
	private class PictureListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			number = Integer.parseInt(numberField.getText());
			String[] pictures = new String[] {"One.png", "Two.png", "Three.png", "four.png", "Five.png"};
			picturePanel=new JPanel();
			picturePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			 BufferedImage img=null;
				try {
					for (int i=0; i<number;i++){
					img = ImageIO.read(new File(IMG_PATH + pictures[i]));
					ImageIcon icon = new ImageIcon(img);
			         JLabel label = new JLabel(icon);
			         picturePanel.add(label,BorderLayout.WEST);
			        // images.add(label);
					}
					panel.add(picturePanel, BorderLayout.CENTER);
					frame.setBounds(200,200,number *(IMAGE_WIDTH),IMAGE_HEIGHT);
					
					frame.revalidate();
					frame.repaint();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
		}
		
	}
}
