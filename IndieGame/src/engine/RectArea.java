package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.lang.Math;

public class RectArea {
	// Граничные точки зоны
	public Point leftL, leftU, rightL, rightU;
	// Массив соседних зон
	public ArrayList<RectArea> connected;
	
	public ArrayList<Loot> loot;

//	public RectArea(Point[] points) {
//		if (points.length == 4) {
//			this.leftL = points[0];
//			this.leftU = points[1];
//			this.rightL = points[2];
//			this.rightU = points[3];
//		}
//	}

	public RectArea(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3) {
		this.leftL = new Point(x0, y0);
		this.leftU = new Point(x1, y1);
		this.rightL = new Point(x2, y2);
		this.rightU = new Point(x3, y3);
		this.connected = new ArrayList<RectArea>();
		this.loot = new ArrayList<Loot>();
	}

	public RectArea getConnected(int x, int y, int width, int height) {
		if(this.connected != null) {
			for (int i = 0; i < this.connected.size(); i++) {
				if (this.connected.get(i).leftL.x < x && this.connected.get(i).rightL.x > x + width) {
					if (this.connected.get(i).leftL.y > y + height && this.connected.get(i).leftU.y < y)  {
						return this.connected.get(i);
					}
				}
			}
		}
		return this;
	};

	public boolean isImpassable(int x, int y, int width, int height) {
		// Проверяем, пересекает ли данный маршрут зоны
		if ((x + width >= this.rightU.x || x < this.leftU.x) || (y < this.rightU.y || y + height > this.rightL.y)) {
			// Переход на соединенную зону
//			if(direction.right) {
//				return this.getConnected(x + width, y, x + width, y + height);
//			}
//			if(direction.left) {
//				return this.getConnected(x, y, x, y + height);
//			}
//			if(direction.down) {
//				return this.getConnected(x, y + height, x + width, y + height);
//			}
//			if(direction.down) {
//				return this.getConnected(x, y, x + width, y);
//			}
			if(this.getConnected(x, y, width, height) != this) {
				return true;
			}
			return false;
		}
		return true;
	}
	
	public Loot checkLoot(int x, int y) {
		for (int i = 0; i<loot.size();i++) {
			if (Math.abs(loot.get(i).position.x-x)<30) return loot.get(i);
		}
		return null;
	}
	
	public int width() {
		return (int) (Math.abs(this.leftL.x - this.rightL.x));
	}

	public int height() {
		return (int) (Math.abs(this.leftL.y - this.rightU.y));
	}

	public void paint(Graphics g, int additionX, int additionY) {
		g = (Graphics2D) g;
		g.setColor(Color.white);
		g.drawRect(this.leftL.x + additionX, this.leftU.y + additionY, this.width(), this.height());
		g.setColor(Color.red);
	}
	
}