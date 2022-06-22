package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class RectArea {
	// Граничные точки зоны
	public Point leftL, leftU, rightL, rightU;
	// Массив соседних зон
	public ArrayList<RectArea> connected;
	// Проходы в соседние зоны
	public ArrayList<int[]> pass;

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
		this.pass = new ArrayList<int[]>();
		this.connected = new ArrayList<RectArea>();
	}

	public RectArea getConnected(int x, int y) {
		if(this.connected != null) {
			for (int i = 0; i < this.connected.size(); i++) {
				if (this.connected.get(i).leftL.x < x && this.connected.get(i).rightL.x > x) {
					if ((this.connected.get(i).leftL.y > y && this.connected.get(i).leftU.y < y)
							|| (this.connected.get(i).leftL.y < y && this.connected.get(i).leftU.y > y)) {
						return this.connected.get(i);
					}
				}
			}
		}
		return this;
	};

	public boolean isImpassable(int x, int y, int objectWidth) {
		// Проверяем, пересекает ли данный маршрут зоны
		if ((x > this.rightU.x || x < this.leftU.x) || y < this.rightU.y || y > this.rightL.y) {
			boolean canPass = false;
			// Проверяем, существует ли проход
			if(this.pass != null) {
				for (int i = 0; i < this.pass.size(); i++) {
					int x0 = this.pass.get(i)[0];
					int y0 = this.pass.get(i)[1];
					int x1 = this.pass.get(i)[2];
					int y1 = this.pass.get(i)[3];
					if(y1 > y0)
						y1 -= (int)(objectWidth);
					else
						y0 -= (int)(objectWidth);
					// Проход по вертикали
					if ((x0 < x && x1 > x) || (x1 < x && x0 > x)) {
						canPass = true;
						break;
					}
					// Проход по горизонтали
					if ((y0 < y && y1 > y) || (y1 < y && y0 > y)) {
						canPass = true;
						break;
					}
				}
			}
			if (!canPass) {
				return false;
			}
		}
		return true;
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
		if(this.pass != null) {
			for(int i = 0; i < this.pass.size(); i++) {
				g.drawLine(this.pass.get(i)[0] + additionX, 
						this.pass.get(i)[1] + additionY,
						this.pass.get(i)[2] + additionX, 
						this.pass.get(i)[3] + additionY);
			}
		}
	}
}