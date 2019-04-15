package animation3d;
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sphere extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Image image;
	Image image2;
	Graphics2D gBuffer;
	Graphics2D shade;
	private int units = 5;
	private int yPos = 0;
	private boolean change = true;

	public void paintComponent(Graphics graphics) {

		if (image == null) {
			image = createImage(this.getSize().width, this.getSize().height);
			gBuffer = (Graphics2D) image.getGraphics();
		}
		
		if (image2 == null) {
			image2 = createImage(200, 100);
			shade = (Graphics2D) image2.getGraphics();
		}
		
		gBuffer.setColor(Color.DARK_GRAY);
		gBuffer.fillOval(150, 150, 300, 300);
		gBuffer.setColor(Color.cyan);
		gBuffer.drawOval(170, 215, 260, 25);
		gBuffer.drawOval(150, 290, 300, 40);
		gBuffer.drawOval(185, 370, 229, 50);
		gBuffer.setColor(Color.green);
		gBuffer.drawOval(270, 150, 70, 300);
		gBuffer.drawOval(270, 150, 70, 300);
		
		shade.setColor(Color.lightGray);
		shade.fillOval(73, 0, units*150, units*3);
		
		if(!change) {
		yPos -= units;
		}
		
		if(change) {
			yPos += units;
		}
		
		if(yPos > (120 + units)) {
			change = false;
		}
		
		if(yPos < -(155 - units)) {
			change = true;
		}
		graphics.drawImage(image, 0, yPos, this);
		//graphics.drawImage(image2, 200, 500, this);
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();

	}


	public static void main(String[] args) {
		JFrame frame = new JFrame("Title");
		frame.setResizable(false);
		Sphere sphere = new Sphere();
		frame.setSize(600, 600);
		frame.add(sphere);
		frame.setVisible(true);
	}

}
