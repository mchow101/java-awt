import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


// Handles GUI elements
public class Animation {
	JFrame frame; // This is the frame object for all GUI elements
	Draw draw; // A JPanel for all drawn elements
	int x, y; // Dimensions
	Image icon;
	int i; // Counter to keep track of frames/update
	
	public Animation() {
		// Default size 
		x = 800;
		y = 800;
		createFrame(800, 800);
	}
	
	public Animation(int x, int y) {
		// Custom size of x, y 
		this.x = x;
		this.y = y;
		createFrame(x, y);
	}
	
	public void createFrame(int x, int y) {
		frame = new JFrame(); // Initialize the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes sure you can actually close the frame
		frame.setSize(x, y); // Set to specified size in pixels
		Draw draw = new Draw();
		frame.add(draw); // Add panel for drawings
		frame.setTitle("GUI is cool!"); // Set displayed title of GUI
		frame.setVisible(true); // Display the frame on the screen
		frame.repaint();
		
		i = 0; // Initialize frame counter
	}
	
	// Wait ms milliseconds before continuing
	public void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Draw on the frame - use this for lines, text, shapes, images, etc. 
	public class Draw extends JPanel {
		public Draw() {
			setBackground(Color.BLACK); // Set a background - java.awt.Color is very helpful here
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Set up for drawing on the frame
			// Draw more circles with every increment
			for(int c = 0; c < i; c++) {
				int circleXPos = x/2 - c*6; // Set the center of the circle in the middle of the screen
				int circleYPos = y/2 - c*6; 
				int circleSize = c*12; // Increase the radius of each circle by 12 pixels
				
				Color color = new Color(255 - c * 2, i * 2, 255 - i * 2);
				g.setColor(color);
				
				g.drawOval(circleXPos, circleYPos, circleSize, circleSize); // Draw circles
			}
			
			i = i < 100 ? i + 1 : 0; // Increase increment unless it is over 100, in which case it will reset
		}
	}
	
	public static void main(String[] args) {
		Animation gui = new Animation();
		while(gui.frame.getState() == 0) {
			gui.frame.repaint(); // Update the frame 		
			gui.delay(50); // Frequency at which to update the screen
		}
	}
}
