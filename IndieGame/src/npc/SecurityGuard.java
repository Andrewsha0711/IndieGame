package npc;

import java.awt.Graphics;
import java.awt.Graphics2D;

import engine.Direction;
import engine.MovingObject;
import engine.RectArea;
import npc.skins.DefaultSecuritySkin;
import player.Player;
import npc.SecurityGuardThread;
import java.lang.Math;

public class SecurityGuard extends MovingObject{

	private DefaultSecuritySkin skin;
	// Дефолтные координаты
	private int defaultStep = 2;
	private int visibility = 150;
	
	public SecurityGuard(int x, int y, RectArea area) {
		// TODO: hardcode
		super(x, y, 53 ,53);
		skin = new DefaultSecuritySkin();
		this.setArea(area);
	}
	
	public void paint(Graphics g, int additionX, int additionY) {
		g = (Graphics2D) g;
		skin.paint(g, this.direction, this.getX() + additionX, this.getY() + additionY);
	}
	
//	public void move(Direction direction) {
//		this.setDirection(direction);
//		super.move(defaultStep);
//	}
	
	//checking if player is nearby and in the same room
	public boolean checkPlayer()
	{
		if (Math.abs(this.getX()-Player.getInstance().getX())<visibility&& Math.abs(this.getY()-Player.getInstance().getY())<visibility
				&& this.getArea()==Player.getInstance().getArea()) 
			return true;
		return false;
	}
	
	public void move() {
		// TODO: stop guard's thread ?
		if (!checkPlayer())
		super.move(defaultStep);
	}
}
