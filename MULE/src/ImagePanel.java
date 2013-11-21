import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Toolkit;

/**
 * ImagePanel draws all the images used in the game.
 *
 * @author Geoving Gerard II
 * @version 11 | 21 | 2013
 */
public class ImagePanel extends JPanel{
	//Image to use
	String imageFile = "/media/startscreen.png";

	/**
     * A constructor that takes in the string of the image we would like to draw.
     *
     * @param image The image that is to be displayed.
     **/
	public ImagePanel(String image){
		super();
		this.imageFile = image;
	}

    /**
     * paintComponent Passes the graphics context off to the component's UI delegate, 
     *                which paints the panel's background
     *
     * @param g Graphics component
     **/
	public void paintComponent(Graphics g){
		//Create image icon to get image
		ImageIcon imageicon = new ImageIcon(getClass().getResource(imageFile));
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imageFile));

		//Draw image on the panel
		super.paintComponent(g);

		if (image != null)
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
