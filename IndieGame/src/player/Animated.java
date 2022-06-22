package player;

import java.awt.Graphics;

import engine.Direction;

public interface Animated {
	public void paint(Graphics g, Direction direction);
}
