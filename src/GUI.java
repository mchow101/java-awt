import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


// Handles GUI elements
public class GUI {
	JFrame frame; // This is the frame object for all GUI elements
	Draw draw; // A JPanel for all drawn elements
	int x, y; // Dimensions
	
	public GUI() {
		// Default size 
		x = 800;
		y = 800;
		createFrame(800, 800);
	}
	
	public GUI(int x, int y) {
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
		frame.setVisible(true); // Display the frame on the screen
	}
	
	// Draw on the frame - use this for lines, text, shapes, images, etc. 
	public class Draw extends JPanel {
		public Draw() {
			setBackground(Color.BLACK); // Set a background - java.awt.Color is very helpful here
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Set up for drawing on the frame
			
			g.setColor(Color.WHITE); // Pick the next color to use
			
			int fontSize = (int)(x*.05); // Set font size to 5% of frame height
			g.setFont(new Font("TimesNewRoman", Font.PLAIN, fontSize)); // Set font
			int textX = x/2 - (int)(x*.1); // Set starting text position to a little left of the middle
			int textY = y/8; // Set starting text position at 1/8 of the height
			g.drawString("Howdy", textX, textY); // Put some text on the frame
			
			g.drawLine(0, y/4, x, y/4); // Draw a line 
			// This line is across the frame 25% of the way down
			
			for(int i = 0; i < 10; i++) {
				int circleXPos = x/2 - i*5; // Set the center of the circle in the middle of the screen
				int circleYPos = y/2 - i*5; 
				int circleSize = i*10; // Increase the radius of each circle by 10 pixels
				g.drawOval(circleXPos, circleYPos, circleSize, circleSize); // Draw multiple circles
			}
			frame.repaint(); // Update the frame - especially important if you are animating
		}
	}
}
