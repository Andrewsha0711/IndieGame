package game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComponent;

import maps.HotlineMiamiMap;
import npc.SecurityGuardThread;
import player.Player;
import player.PlayerThread;

public class GameWindow extends JComponent{
		private static GameWindow instance;
		
		private static final int DEF_WIDTH = 1280;
	    private static final int DEF_HEIGHT = 720;
				
	    // TODO: any map not only this one
	    private HotlineMiamiMap map;
	    private ArrayList<SecurityGuardThread> npcThreads;

        public Dimension getPreferredSize() {
	        return new Dimension(DEF_WIDTH, DEF_HEIGHT);
	    }
		
	    // TODO: change to constuct from any map
		private GameWindow(HotlineMiamiMap map){	
			this.map = map;
			this.npcThreads = new ArrayList<SecurityGuardThread>();
			for(int i = 0; i < this.map.npc.size(); i++) {
				this.npcThreads.add(new SecurityGuardThread(this.map.npc.get(i)));
			}
			PlayerThread.getInstance().start();
			for(int i = 0; i < this.npcThreads.size(); i++) {
				this.npcThreads.get(i).start();
			}
		}
		
		public static GameWindow getInstance() {
			if(instance == null) {
				instance = new GameWindow(HotlineMiamiMap.getInstance());
			}
			return instance;
		}
		
		//TODO: getInstance(<AnyMap> map)
		
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			this.map.paint(g2);
			g2.setColor(Color.magenta);
			g2.fillRect(1100,20, 150, 50);
			g2.setColor(Color.yellow);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.BOLD, 20));
			g2.drawString("Loot score: "+Player.getInstance().getLootCount(), 1110,50);
			Player.getInstance().paint(g2);
		}

		public void interruptAll() {
			PlayerThread.isRunning = false;
			for(int i = 0; i < this.npcThreads.size(); i++) {
				this.npcThreads.get(i).isRunning = false;
			}
//			PlayerThread.getInstance().interrupt();
		}
}
