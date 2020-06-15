package Entity;

import Entity.*;
import TileMap.TileMap;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class KeyItem extends Enemy {
	
	private BufferedImage[] sprites;  //stores sprites
	
	public KeyItem(TileMap tm) {
		
		super(tm);                    //calling tileMap of superclass
		
		//setting height and width of the sprite 
		width = 30;
		height = 30;
		
		//setting height and width of the collision box
		cwidth = 20;
		cheight = 20;
		
		//setting health
		health = maxHealth = 1;
		
		
		// load sprites
		try {
			
			BufferedImage spritesheet = ImageIO.read(
				getClass().getResourceAsStream(
				"/ItemSprite/powerup.png"
				)
			);
			
			sprites = new BufferedImage[10];
			for(int i = 0; i < sprites.length; i++) {
				sprites[i] = spritesheet.getSubimage(
					i * width,
					0,
					width,
					height
				);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//setting animation condition
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(70);
		
		
		
	}
	

	
	public void update() {
		
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		if(flinching) {
			long elapsed =
				(System.nanoTime() - flinchTimer) / 1000000;
			if(elapsed > 400) {
				flinching = false;
			}
		}
			
		// update animation
		animation.update();
		
	}
	
	public void draw(Graphics2D g) {
		

		
		setMapPosition();
		
		super.draw(g);
		
	}
	
}











