package maps;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import engine.RectArea;
import npc.SecurityGuard;
import player.Player;

public class HotlineMiamiMap extends JComponent{
	private static HotlineMiamiMap instance;
	
	// Settings
    private static final int DEF_WIDTH = 701*2;
    private static final int DEF_HEIGHT = 641*2;
	// Textures and other
	private static final String backgroundSrc = "resources/maps/hotline_miami_map.PNG";
	private static ArrayList<RectArea> area;
	public static ArrayList<SecurityGuard> npc;
	
//	static {
//		area.add(new RectArea(0,100, 0,0, 100,100, 100,0));
//	}
	
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
		// Сборка карты
		area = new ArrayList<RectArea>();
		npc = new ArrayList<SecurityGuard>();
		
		RectArea tmp = new RectArea(-30,300, -30,-20, 200,300, 200,-20);
		RectArea tmp1 = new RectArea(130,160, 130,80, 290,160, 290, 80);
		tmp.connected.add(tmp1);
		tmp1.connected.add(tmp);
		
		area.add(tmp);
		
		RectArea tmp2 = new RectArea(215,300, 215,-20, 400,300, 400,-20);
		tmp2.connected.add(tmp1);
		tmp1.connected.add(tmp2);
		
		area.add(tmp1);
		area.add(tmp2);
		
		npc.add(new SecurityGuard(-50, 30));
	}
	
	public static RectArea getDefaultArea() {
		// TODO: hardcode
		return area.get(0);
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
		for(int i = 0; i < area.size(); i++) {
			area.get(i).paint(g, 640 - Player.getInstance().getX() , 360 - Player.getInstance().getY());
		}
		for(int i = 0; i < npc.size(); i++) {
			npc.get(i).paint(g, 640 - Player.getInstance().getX() , 360 - Player.getInstance().getY());
		}
	}
}
