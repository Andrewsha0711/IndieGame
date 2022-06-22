package maps;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import player.Player;

public class HotlineMiamiMap extends JComponent{
	private static HotlineMiamiMap instance;
	
	// Settings
    private static final int DEF_WIDTH = 701*2;
    private static final int DEF_HEIGHT = 641*2;
	// Textures and other
	private static final String backgroundSrc = "resources/maps/hotline_miami_map.PNG";
	
	private Image background;
	
	private HotlineMiamiMap() {
		BufferedImage buffimage;
		try {
			buffimage = ImageIO.read(new File(backgroundSrc));
			this.background = buffimage.getScaledInstance(DEF_WIDTH, DEF_HEIGHT, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			this.background = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static HotlineMiamiMap getInstance() {
		if(instance == null) {
			instance = new HotlineMiamiMap();
		}
		return instance;
	}
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(this.background, - Player.getInstance().getX(), - Player.getInstance().getY(), null);
	}
}
