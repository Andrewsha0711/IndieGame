package npc;

import java.util.Random;

import engine.Direction;
import game.GameWindow;

public class SecurityGuardThread extends Thread{
	public static boolean isRunning = false;
	private SecurityGuard npc;
	Random random;
	
	public SecurityGuardThread(SecurityGuard npc) {
		this.npc = npc;
		this.random = new Random();
	}
	
	private boolean isStanding() {
		return(!(this.npc.direction.left ||
				this.npc.direction.right ||
				this.npc.direction.down ||
				this.npc.direction.up));
	}
	
	private void getRandomDirection() {
		this.npc.direction.setLeft(this.random.nextBoolean());
		this.npc.direction.setRight(this.random.nextBoolean());
		this.npc.direction.setDown(this.random.nextBoolean());
		this.npc.direction.setUp(this.random.nextBoolean());
	}
	
	public void run() {
		isRunning = true;
		int actionTime = 50;
		while (isRunning) {
			try {
				if(actionTime > 0) {
					this.npc.move();
					actionTime--;
				}
				else {
					this.getRandomDirection();
					actionTime = 50;
				}
				sleep(100);
//				GameWindow.getInstance().repaint();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
