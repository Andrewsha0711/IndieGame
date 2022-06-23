package player;

import game.GameWindow;
import main.Frame;

public class PlayerThread extends Thread {
	private static PlayerThread instance;
	public static boolean isRunning = false;
	private PlayerThread() {};

	public static PlayerThread getInstance() {
		if (instance == null) {
			instance = new PlayerThread();
		}
		return instance;
	}

	public void run() {
		isRunning = true;
		while (isRunning) {
			try {
				Player.getInstance().move();
				GameWindow.getInstance(Frame.getCurrentBuilder()).repaint();
				Thread.currentThread().sleep(15);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
