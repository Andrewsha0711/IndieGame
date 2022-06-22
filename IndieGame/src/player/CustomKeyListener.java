package player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import engine.Direction;

public class CustomKeyListener implements KeyListener{
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_A) {
			Player.getInstance().direction.setLeft(true);
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			Player.getInstance().direction.setRight(true);
		}	
		if (e.getKeyCode()==KeyEvent.VK_W) {
			Player.getInstance().direction.setUp(true);
		}	
		if (e.getKeyCode()==KeyEvent.VK_S) {
			Player.getInstance().direction.setDown(true);
		}
//		System.out.println(Player.getInstance().getDirection());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_A) {
			Player.getInstance().direction.setLeft(false);
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			Player.getInstance().direction.setRight(false);
		}	
		if (e.getKeyCode()==KeyEvent.VK_W) {
			Player.getInstance().direction.setUp(false);
		}	
		if (e.getKeyCode()==KeyEvent.VK_S) {
			Player.getInstance().direction.setDown(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
