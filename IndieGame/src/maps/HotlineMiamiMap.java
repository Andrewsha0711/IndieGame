package maps;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import engine.Loot;
import engine.RectArea;
import npc.SecurityGuard;
import player.Player;

public class HotlineMiamiMap extends JComponent{
	private static HotlineMiamiMap instance;
	
	// Settings
    private static final int DEF_WIDTH = 701*2;
    private static final int DEF_HEIGHT = 641*2;
	// Textures and other
	private static final String backgroundSrc = "IndieGame/resources/maps/hotline_miami_map.PNG";
	private static ArrayList<RectArea> area;
	private static ArrayList<Loot> loot;
	public static ArrayList<SecurityGuard> npc;
	
//	static {
//		area.add(new RectArea(0,100, 0,0, 100,100, 100,0));
//	}
	
	private Image background;
	
	private HotlineMiamiMap() {
		BufferedImage buffimage;
		try {
			buffimage = ImageIO.read(new File(backgroundSrc));
			this.background = buffimage.getScaledInstance(DEF_WIDTH, DEF_HEIGHT, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			this.background = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Сборка карты
		area = new ArrayList<RectArea>();
		npc = new ArrayList<SecurityGuard>();
		loot = new ArrayList<Loot>();
		
		RectArea tmp = new RectArea(-30,360, -30,-20, 200,360, 200,-20);
		RectArea tmp1 = new RectArea(130,120, 130,90, 290,120, 290, 90);
		tmp.connected.add(tmp1);
		tmp1.connected.add(tmp);
				
		area.add(tmp);
		
		RectArea tmp2 = new RectArea(215,360, 215,-70, 520,360, 520,-70);
		tmp2.connected.add(tmp1);
		tmp1.connected.add(tmp2);		
		
		area.add(tmp1);
		area.add(tmp2);
		
		RectArea tmp3 = new RectArea(520,100, 520,-70, 720,100, 720,-70);
		tmp2.connected.add(tmp3);
		tmp3.connected.add(tmp2);
		area.add(tmp3);
		
		RectArea tmp4 = new RectArea(580,150, 580,-150, 650, 150, 650,-150);
		tmp3.connected.add(tmp4);
		tmp4.connected.add(tmp3);
		area.add(tmp4);
		
		
		RectArea tmp5 = new RectArea(540, 360, 540, 120, 720, 360, 720, 120);
		tmp4.connected.add(tmp5);
		tmp5.connected.add(tmp4);
		tmp3.connected.add(tmp5);
		tmp5.connected.add(tmp3);
		area.add(tmp5);
		
		RectArea tmp6 = new RectArea(420, 280, 420, 240, 620, 280, 620, 240);
		tmp6.connected.add(tmp2);
		tmp2.connected.add(tmp6);
		tmp6.connected.add(tmp5);
		tmp5.connected.add(tmp6);
		area.add(tmp6);
		
	
		RectArea tmp8 = new RectArea(340, 450, 340, 300, 460, 450, 460, 300);
		tmp8.connected.add(tmp2);
		tmp2.connected.add(tmp8);
		area.add(tmp8);
		
		RectArea tmp7 = new RectArea(20, 680, 20, 370, 460, 680, 460, 370);
		tmp8.connected.add(tmp7);
		tmp7.connected.add(tmp8);
		tmp2.connected.add(tmp7);
		tmp7.connected.add(tmp2);
		area.add(tmp7);
		
		
		RectArea tmp9 = new RectArea(460, 680, 460, 480, 580, 680, 580, 480);
		tmp9.connected.add(tmp7);
		tmp7.connected.add(tmp9);
		area.add(tmp9);
		
		RectArea tmp10 = new RectArea(-40, -90, -40, -330, 720, -90, 720, -330);
		tmp10.connected.add(tmp4);
		tmp4.connected.add(tmp10);
		tmp10.connected.add(tmp3);
		tmp3.connected.add(tmp10);
		area.add(tmp10);
		
		RectArea tmp11 = new RectArea(-40, 550, -40, 480, 80, 550, 80, 480);
		tmp11.connected.add(tmp7);
		tmp7.connected.add(tmp11);
		area.add(tmp11);
		
		RectArea tmp12 = new RectArea(-360, 680, -360, 370, 10, 680, 10, 370);
		tmp12.connected.add(tmp11);
		tmp11.connected.add(tmp12);
		area.add(tmp12);
		
		RectArea tmp13 = new RectArea(-250, 430, -250, 250, -170, 430, -170, 250);
		tmp12.connected.add(tmp13);
		tmp13.connected.add(tmp12);
		area.add(tmp13);
		
		RectArea tmp14 = new RectArea(-360, 360, -360, 120, -50, 360, -50, 120);
		tmp14.connected.add(tmp13);
		tmp13.connected.add(tmp14);
		tmp14.connected.add(tmp13);
		tmp13.connected.add(tmp14);
		area.add(tmp14);
		
		RectArea tmp15 = new RectArea(-450, 610, -450, 550, -300, 610, -300, 550);
		tmp12.connected.add(tmp15);
		tmp15.connected.add(tmp12);
		area.add(tmp15);
		
		
		RectArea tmp16 = new RectArea(-620, 740, -620, 250, -370, 740, -370, 250);
		tmp16.connected.add(tmp15);
		tmp15.connected.add(tmp16);
		area.add(tmp16);
		
		RectArea tmp17 = new RectArea(-120, -220, -120, -280, 20, -220, 20, -280);
		tmp10.connected.add(tmp17);
		tmp17.connected.add(tmp10);
		area.add(tmp17);
		
		RectArea tmp18 = new RectArea(-500, -150, -500, -330, -50, -150, -50, -330);
		tmp18.connected.add(tmp17);
		tmp17.connected.add(tmp18);
		area.add(tmp18);
		
		RectArea tmp19 = new RectArea(-250, -50, -250, -230, -180, -50, -180, -230);
		tmp18.connected.add(tmp19);
		tmp19.connected.add(tmp18);
		area.add(tmp19);
		
		RectArea tmp20 = new RectArea(-350, 100, -350, -130, -50, 100, -50, -130);
		tmp20.connected.add(tmp19);
		tmp19.connected.add(tmp20);
		area.add(tmp20);
		
		RectArea tmp21 = new RectArea(-310, 150, -310, 50, -250, 150, -250, 50);
		tmp20.connected.add(tmp21);
		tmp21.connected.add(tmp20);
		area.add(tmp21);
		
		RectArea tmp22 = new RectArea(-450, 40, -450, -30, -300, 40, -300, -30);
		tmp20.connected.add(tmp22);
		tmp22.connected.add(tmp20);
		area.add(tmp22);
		
		RectArea tmp23 = new RectArea(-620, 230, -620, -130, -370, 230, -370, -130);
		tmp23.connected.add(tmp22);
		tmp22.connected.add(tmp23);
		area.add(tmp23);
		
		fillWithLoot(10);

		
		
		npc.add(new SecurityGuard(140, 30));
	}
	

	public static void fillWithLoot(int numberOfItems) {
		for (int i=0; i<numberOfItems; i++)
		{
			RectArea tmpArea = area.get((int)(Math.random() * (area.size())));
			Loot tmpLoot = new Loot((int)(Math.random() * (tmpArea.rightL.x-tmpArea.leftL.x+1)+tmpArea.leftL.x),
					(int)(Math.random() * (tmpArea.rightL.y-tmpArea.rightU.y+1)+tmpArea.rightU.y));
			tmpArea.loot.add(tmpLoot);
			loot.add(tmpLoot);
		}
	}
	
	public static RectArea getDefaultArea() {
		// TODO: hardcode
		return area.get(0);
	}
	
	public static ArrayList<Loot> getLoot() {
		// TODO: hardcode
		return loot;
	}
	
	public static HotlineMiamiMap getInstance() {
		if(instance == null) {
			instance = new HotlineMiamiMap();
		}
		return instance;
	}
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(this.background, - Player.getInstance().getX(), - Player.getInstance().getY(), null);
		
		for(int i = 0; i < area.size(); i++) {
			area.get(i).paint(g, 640 - Player.getInstance().getX() , 360 - Player.getInstance().getY());
		}
		
		for(int i = 0; i < npc.size(); i++) {
			npc.get(i).paint(g, 640 - Player.getInstance().getX() , 360 - Player.getInstance().getY());
		}
		
		for(int i = 0; i < loot.size(); i++) {
			loot.get(i).paint(g, 640 - Player.getInstance().getX() , 360 - Player.getInstance().getY());
		}
	}
}
