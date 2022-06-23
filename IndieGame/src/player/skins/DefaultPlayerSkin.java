package player.skins;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import engine.Direction;

public class DefaultPlayerSkin extends JComponent{
//	private static final String standing  = "resources/skins/default/standing.png";
//	private static final String walkingLeft  = "resources/skins/default/walking_left.png";
//	private static final String walkingRight  = "resources/skins/default/walking_right.png";
	
	private static Image[] standing = new Image[4];
	private static Image[] walkingLeft = new Image[4];
	private static Image[] walkingRight = new Image[4];
	
	// animation speed coefficient and counter
	private static int k = 20, i = k;
	private static boolean isWalkingLeftLeg = true;
	
	//default direction
	private static int standingFlag = 3;
	
	public DefaultPlayerSkin(){
		BufferedImage buffimage;
		try {
			buffimage = ImageIO.read(new File("resources/skins/default/standing_l.png"));
			standing[0] = buffimage.getScaledInstance(31, 53, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/standing_r.png"));
			standing[1] = buffimage.getScaledInstance(31, 53, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/standing_d.png"));
			standing[2] = buffimage.getScaledInstance(53, 31, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/standing_u.png"));
			standing[3] = buffimage.getScaledInstance(53, 31, Image.SCALE_DEFAULT);
			
			buffimage = ImageIO.read(new File("resources/skins/default/walking_left_l.png"));
			walkingLeft[0] = buffimage.getScaledInstance(53, 53, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/walking_left_r.png"));
			walkingLeft[1] = buffimage.getScaledInstance(53, 53, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/walking_left_d.png"));
			walkingLeft[2] = buffimage.getScaledInstance(53, 53, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/walking_left_u.png"));
			walkingLeft[3] = buffimage.getScaledInstance(53, 53, Image.SCALE_DEFAULT);
			
			buffimage = ImageIO.read(new File("resources/skins/default/walking_right_l.png"));
			walkingRight[0] = buffimage.getScaledInstance(50, 53, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/walking_right_r.png"));
			walkingRight[1] = buffimage.getScaledInstance(50, 53, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/walking_right_d.png"));
			walkingRight[2] = buffimage.getScaledInstance(53, 50, Image.SCALE_DEFAULT);
			buffimage = ImageIO.read(new File("resources/skins/default/walking_right_u.png"));
			walkingRight[3] = buffimage.getScaledInstance(53, 50, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			standing = null;
			walkingLeft = null;
			walkingRight = null;
			e.printStackTrace();
		}
	}
	
	public Image standing() {
		return standing[standingFlag];
	}
	
	public static Image walking(Direction direction) {
		int j = -1;
		if(direction.left) { j = 0; }
		if(direction.right) { j = 1; }
		if(direction.down) { j = 2; }
		if(direction.up) { j = 3; }
		
		standingFlag = j;
		
		if(i > 0) {
			i--;
			if(isWalkingLeftLeg) {
				return walkingLeft[j];
			}
			else {
				return walkingRight[j];
			}
		}
		else {
			// TODO: hardcode
			i = k;
			if(isWalkingLeftLeg) {
				isWalkingLeftLeg = false;
				return walkingRight[j];
			}
			else {
				isWalkingLeftLeg = true;
				return walkingLeft[j];
			}
		}
	}
	
	public void paint(Graphics g, Direction direction) {
		Image image;
		if(!direction.left && !direction.right && !direction.up && !direction.down) {
			image = standing();
//			System.out.println(Player.getInstance().getX());
//			System.out.println(Player.getInstance().getY());
		}
		else {
			image = walking(direction);
		}
		g = (Graphics2D) g;
		g.drawImage(image, 640, 360, null);
	}
}
