package maps;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import engine.Loot;
import engine.RectArea;
import npc.SecurityGuard;
import player.Player;

public class Map {
	private static final int DEF_WIDTH = 701*2;
    private static final int DEF_HEIGHT = 641*2;
	// Textures and other
	private static  String backgroundSrc ="";
	private static ArrayList<RectArea> area;
	private static ArrayList<Loot> loot;
	public static ArrayList<SecurityGuard> npc;
	private Image background;
	
	public Map(ArrayList<RectArea> area, ArrayList<Loot> loot, ArrayList<SecurityGuard> npc, String backgroundSrc) {
		this.area = area;
		this.loot = loot;
		this.npc = npc;
		this.backgroundSrc = backgroundSrc;
		BufferedImage buffimage;
		try {
			buffimage = ImageIO.read(new File(backgroundSrc));
			this.background = buffimage.getScaledInstance(DEF_WIDTH, DEF_HEIGHT, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Loot> getLoot() {
			return loot;
	}
	
	public static ArrayList<RectArea> getArea() {
		return area;
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
		
		for(int i = 0; i < loot.size(); i++) {
			loot.get(i).paint(g, 640 - Player.getInstance().getX() , 360 - Player.getInstance().getY());
		}
	}
		
}
