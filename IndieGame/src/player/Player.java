package player;

import java.awt.Graphics;
import java.awt.Graphics2D;

import engine.Direction;
import engine.Loot;
import engine.MovingObject;
import game.GameWindow;
import player.skins.DefaultPlayerSkin;

// TODO: singleton
public class Player extends MovingObject{
	private static Player instance;
	private static DefaultPlayerSkin skin;
	// Дефолтные координаты
	private static int defaultX = 0;
	private static int defaultY = 0;
	private static int defaultStep = 4;
	private static int lootCount = 0;
	
	private Player() {
		// TODO: hardcode
		super(defaultX, defaultY, 53 ,53);
		skin = new DefaultPlayerSkin();
		this.setArea(GameWindow.getCurrentMap().getArea().get(0));
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
	
	//checking if there's any loot nearby
	public void checkLoot() {
		Loot loot = this.getArea().checkLoot(this.getX(), this.getY());
		if (loot!=null)
		{
			GameWindow.getCurrentMap().getLoot().remove(loot);
			this.getArea().loot.remove(loot);
			lootCount++;
		}
		
	}
	
	public int getLootCount() {
		return lootCount;
	}
	
	public void move() {
		super.move(defaultStep);
	}
	public void move(Direction direction) {
		this.setDirection(direction);
		super.move(defaultStep);
	}
}
