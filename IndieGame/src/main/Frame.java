package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.GameWindow;
import player.CustomKeyListener;
import player.Player;

public class Frame extends JFrame{
    public static final int DEF_Width = 1280;
    public static final int DEF_Height = 720;
    
    private Player player;
    private GameWindow window;
    
    public Frame() throws Exception{
    	
    	JPanel panel = new JPanel();
    	
    	// TODO: hardcode
    	this.window = GameWindow.getInstance();
    	this.add(window);
    	this.addKeyListener(new CustomKeyListener());
    	pack();
    }
    
    public void interruptAll() {
    	GameWindow.getInstance().interruptAll();
//    	this.window.interruptAll();
    }
}

