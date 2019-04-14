package animation3d;

import java.awt.Dimension; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cube extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	Graphics2D gBuffer;
	double p[][] = new double[8][3];
	int t = 200;
	double px, py, pz;

	double angle = 0.1;


	int x = 0, y = 1, z = 2;

	public void init() {
		p[0][x] = -100;
		p[0][y] = 100;
		p[0][z] = -100;

		p[1][x] = 100;
		p[1][y] = 100;
		p[1][z] = -100;

		p[2][x] = 100;
		p[2][y] = 100;
		p[2][z] = 100;

		p[3][x] = -100;
		p[3][y] = 100;
		p[3][z] = 100;

		p[4][x] = -100;
		p[4][y] = -100;
		p[4][z] = -100;

		p[5][x] = 100;
		p[5][y] = -100;
		p[5][z] = -100;

		p[6][x] = 100;
		p[6][y] = -100;
		p[6][z] = 100;

		p[7][x] = -100;
		p[7][y] = -100;
		p[7][z] = 100;

	}

	public void paintComponent(Graphics graphics) {


		
		if (image == null) {
			image = createImage(this.getSize().width, this.getSize().height);
			gBuffer = (Graphics2D) image.getGraphics();
		}
		gBuffer.clearRect(0, 0, this.getSize().width, this.getSize().height);
		gBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		gBuffer.drawLine((int) p[0][x] + t, (int) p[0][y] + t, (int) p[1][x] + t, (int) p[1][y] + t);
		gBuffer.drawLine((int) p[1][x] + t, (int) p[1][y] + t, (int) p[2][x] + t, (int) p[2][y] + t);
		gBuffer.drawLine((int) p[2][x] + t, (int) p[2][y] + t, (int) p[3][x] + t, (int) p[3][y] + t);
		gBuffer.drawLine((int) p[3][x] + t, (int) p[3][y] + t, (int) p[0][x] + t, (int) p[0][y] + t);
		gBuffer.drawLine((int) p[4][x] + t, (int) p[4][y] + t, (int) p[5][x] + t, (int) p[5][y] + t);
		gBuffer.drawLine((int) p[5][x] + t, (int) p[5][y] + t, (int) p[6][x] + t, (int) p[6][y] + t);
		gBuffer.drawLine((int) p[6][x] + t, (int) p[6][y] + t, (int) p[7][x] + t, (int) p[7][y] + t);
		gBuffer.drawLine((int) p[7][x] + t, (int) p[7][y] + t, (int) p[4][x] + t, (int) p[4][y] + t);
		gBuffer.drawLine((int) p[0][x] + t, (int) p[0][y] + t, (int) p[4][x] + t, (int) p[4][y] + t);
		gBuffer.drawLine((int) p[1][x] + t, (int) p[1][y] + t, (int) p[5][x] + t, (int) p[5][y] + t);
		gBuffer.drawLine((int) p[2][x] + t, (int) p[2][y] + t, (int) p[6][x] + t, (int) p[6][y] + t);
		gBuffer.drawLine((int) p[3][x] + t, (int) p[3][y] + t, (int) p[7][x] + t, (int) p[7][y] + t);

		graphics.drawImage(image, 0, 0, this);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 8; i++) {
			px = p[i][x];
			py = p[i][y];
			pz = p[i][z];

			p[i][x] = px * Math.cos(angle) + py * Math.sin(angle);
			p[i][y] = -px * Math.sin(angle) + py * Math.cos(angle);

			px = p[i][x];
			py = p[i][y];

			p[i][x] = px * Math.cos(angle) + pz * Math.sin(angle);
			p[i][z] = -px * Math.sin(angle) + pz * Math.cos(angle);

			py = p[i][y];
			pz = p[i][z];

			p[i][y] = py * Math.cos(angle) + pz * Math.sin(angle);
			p[i][z] = -py * Math.sin(angle) + pz * Math.cos(angle);

		}

		repaint();

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Title");

		frame.setResizable(false);
		Cube cube = new Cube();

		frame.setSize(450, 450);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getSize().width) / 2);
		int y = (int) ((dimension.getHeight() - frame.getSize().height) / 2);
		frame.setLocation(x, y);
		cube.init();
		frame.add(cube);
		frame.setVisible(true);
	}

}
