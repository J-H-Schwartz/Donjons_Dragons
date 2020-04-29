package main;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Image Displaying (Jframe) class.
 * 
 */


public class DisplayImage {
	/**
	 * Displays Image via URL.
	 *
	 * @param url String containing the url of the image.
	 *
	 */
	public DisplayImage(String url) throws IOException {
		BufferedImage img = ImageIO.read(new File(url));
		ImageIcon icon = new ImageIcon(img);
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(300, 400);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
