package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import maps.HotlineMiamiMap;
import player.CustomKeyListener;
import player.Player;
import player.PlayerThread;

public class GameWindow extends JComponent{
		private static GameWindow instance;
		
		private static final int DEF_WIDTH = 1280;
	    private static final int DEF_HEIGHT = 720;
				
	    // TODO: any map not only this one
	    private HotlineMiamiMap map;

        public Dimension getPreferredSize() {
	        return new Dimension(DEF_WIDTH, DEF_HEIGHT);
	    }
		
	    // TODO: change to constuct from any map
		private GameWindow(HotlineMiamiMap map){	
			this.map = map;
			PlayerThread.getInstance().start();
		}
		
		public static GameWindow getInstance() {
			if(instance == null) {
				instance = new GameWindow(HotlineMiamiMap.getInstance());
			}
			return instance;
		}
		
		//TODO: getInstance(<AnyMap> map)
		
		public void paint(Graphics g) {
			g = (Graphics2D) g;
			this.map.paint(g);
			Player.getInstance().paint(g);
		}

		public void interruptAll() {
			PlayerThread.isRunning = false;
//			PlayerThread.getInstance().interrupt();
		}
}
