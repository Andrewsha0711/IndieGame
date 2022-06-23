package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.GameWindow;
import maps.HotlineMiamiMapBuilder;
import maps.MapBuilder;
import player.CustomKeyListener;
import player.Player;

public class Frame extends JFrame{
    public static final int DEF_Width = 1280;
    public static final int DEF_Height = 720;
    
    private Player player;
    private GameWindow window;
    private static MapBuilder builder;
    
    public Frame() throws Exception{
    	
    	JPanel panel = new JPanel();
    	builder = new HotlineMiamiMapBuilder();
    	
    	// TODO: hardcode
    	this.window = GameWindow.getInstance(builder);
    	this.add(window);
    	this.addKeyListener(new CustomKeyListener());
    	pack();
    }
    
    public void interruptAll() {
    	GameWindow.getInstance(builder).interruptAll();
//    	this.window.interruptAll();
    }
    
    public static MapBuilder getCurrentBuilder() {
    	return builder;
    }
}

