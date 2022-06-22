package engine;

import java.awt.Point;

public class Wall {
	private Point[] points;
	private static int size = 3;
	
	public Wall(Point a, Point b, int size) {
		this.points = new Point[2];
		this.points[0] = a;
		this.points[1] = b;
	}
}
