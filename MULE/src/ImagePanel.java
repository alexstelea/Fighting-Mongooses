import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class ImagePanel extends JPanel{
	
	//image to use
	String imageFile = "/media/startscreen.png";

	public ImagePanel(){
		super();
	}

	public ImagePanel(String image){
		super();
		this.imageFile = image;
	}

	public void paintComponent(Graphics g){
		//create image icon to get image
		ImageIcon imageicon = new ImageIcon(getClass().getResource(imageFile));

		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imageFile));

		//draw image on the panel
		super.paintComponent(g);

		if (image != null)
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
