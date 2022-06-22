package npc;

import java.awt.Graphics;
import java.awt.Graphics2D;

import engine.Direction;
import engine.MovingObject;
import maps.HotlineMiamiMap;
import npc.skins.DefaultSecuritySkin;

public class SecurityGuard extends MovingObject{

	private DefaultSecuritySkin skin;
	// Дефолтные координаты
	private int defaultStep = 2;
	
	public SecurityGuard(int x, int y) {
		// TODO: hardcode
		super(x, y, 53 ,53);
		skin = new DefaultSecuritySkin();
		this.setArea(HotlineMiamiMap.getDefaultArea());
	}
	
	public void paint(Graphics g, int additionX, int additionY) {
		g = (Graphics2D) g;
		skin.paint(g, this.direction, this.getX() + additionX, this.getY() + additionY);
	}
	
//	public void move(Direction direction) {
//		this.setDirection(direction);
//		super.move(defaultStep);
//	}
	
	public void move() {
		super.move(defaultStep);
	}
}
