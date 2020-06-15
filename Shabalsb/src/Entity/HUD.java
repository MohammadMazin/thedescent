package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Handler.Stats;

public class HUD {
	
	private Player player;
	
	private BufferedImage image;
	private Font font;

	
	public HUD(Player p) {
		player = p;
		
		//loads image
		try {
			image = ImageIO.read(
				getClass().getResourceAsStream(
					"/HUD/hud.png"
				)
			);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//creates new font object
		font = new Font("Arial", Font.PLAIN, 14);
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, 0, 10, null);              //hud.png drawn on screen
		
		//setting font color and style that is to be drawn
		g.setFont(font);
		g.setColor(Color.WHITE);
		
		g.drawString(	player.getHealth() + "/" + player.getMaxHealth(), 30, 25);
		
		g.drawString(player.getFire() / 100 + "/" + player.getMaxFire() / 100, 30, 45	);
		
		g.drawString(player.getLives() + "/" + player.getMaxLives() , 30, 65);
		
	}
	
}













