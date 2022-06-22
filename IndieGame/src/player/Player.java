package player;

import java.awt.Graphics;
import java.awt.Graphics2D;

import engine.Direction;
import engine.MovingObject;
import maps.HotlineMiamiMap;
import player.skins.DefaultPlayerSkin;

// TODO: singleton
public class Player extends MovingObject{
	private static Player instance;
	private static DefaultPlayerSkin skin;
	// Дефолтные координаты
	private static int defaultX = 0;
	private static int defaultY = 0;
	private static int defaultStep = 2;
	
	private Player() {
		// TODO: hardcode
		super(defaultX, defaultY, 53 ,53);
		skin = new DefaultPlayerSkin();
		this.setArea(HotlineMiamiMap.getDefaultArea());
	}
	
	public static Player getInstance() {
		if(Player.instance == null) {
			Player.instance = new Player();
		}
		return Player.instance;
	}
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
//		g.drawImage(this.skin, this.getX()+100, this.getY(), null);
//		g.drawImage(this.skin, 640, 360, null);
		skin.paint(g, this.direction);
	}
	
	public void move() {
		super.move(defaultStep);
	}
	public void move(Direction direction) {
		this.setDirection(direction);
		super.move(defaultStep);
	}
}
