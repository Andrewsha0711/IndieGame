package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import player.PlayerThread;

public class Program {
	public static void run() throws Exception{
        Frame frame = new Frame();
        frame.setTitle("IndieGame");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                frame.interruptAll();
            	frame.dispose();
            }
        });
        frame.setVisible(true);
    }
	
	public static void main(String[] args) throws Exception, java.io.IOException{
		run();
	}
}
