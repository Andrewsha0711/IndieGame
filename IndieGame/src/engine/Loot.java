package engine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Loot {

	// Граничные точки зоны
	public Point position;
	// Массив соседних зон
	public ArrayList<RectArea> connected;
	private int size=10;

//	public RectArea(Point[] points) {
//		if (points.length == 4) {
//			this.leftL = points[0];
//			this.leftU = points[1];
//			this.rightL = points[2];
//			this.rightU = points[3];
//		}
//	}

	public Loot(int x0, int y0) {
		this.position = new Point(x0, y0);
	}


	public void paint(Graphics g, int additionX, int additionY) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.yellow);
		g2.fillRect(this.position.x + additionX, this.position.y + additionY, this.size, this.size);
		//g.setColor(Color.red);
	}
	
}
