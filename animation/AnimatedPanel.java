package animation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimatedPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private double angle;

	public AnimatedPanel() {

		try {
			image = ImageIO.read(new File("C:\\Stuff\\Untitled.png"));
			Timer timer = new Timer(1, new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					angle += Math.toRadians(253);
					
					repaint();
				}
			});
			timer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Dimension getPreferredSize() {

		return image == null ? super.getPreferredSize() : new Dimension(3 * image.getWidth(), 3 * image.getHeight());
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.translate(super.getWidth() / 2, super.getHeight() / 2);
		graphics2d.rotate(angle);

		graphics2d.drawImage(image, -(image.getWidth() / 2), -(image.getHeight() / 2), this);

	}

	public static class RotateImage {

		public RotateImage() {

			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					JFrame frame = new JFrame("Title");
					frame.setVisible(true);
					frame.setResizable(false);
					frame.add(new AnimatedPanel());
					frame.pack();

				}
			});
		}
	}

	public static void main(String[] args) {
		new RotateImage();
	}

}
