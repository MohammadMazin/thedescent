package Entity;

import Entity.*;
import TileMap.TileMap;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import Audio.AudioPlayer;

public class Crystal extends Enemy {
	
	private BufferedImage[] sprites;              //stores sprites
	private AudioPlayer breakSound;               //stores audio file
	 
	public Crystal(TileMap tm) {
		
		super(tm);                                //calling tileMap of superclass
		
		//setting height and width of the sprite 
		width = 30;                         
		height = 30;
		
	    //setting height and width of the collision box
		cwidth = 20;
		cheight = 20;
		
		//setting health
		health = maxHealth = 1;
		
		
		// loading sprites
		try {
			
			BufferedImage spritesheet = ImageIO.read(
				getClass().getResourceAsStream(
						"/ItemSprite/crystal.png"
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
		
		breakSound = new AudioPlayer("/SFX/GlassBreaking.mp3");
		
		//setting animation condition
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(70);
		
		
		
	}
	
    public void setHealth(int health) { this.health = maxHealth = health;}
    public int getHealth() {return health;}
   
    public boolean isBroken() { 
    	
    	if (health <= 0) 
    	    return true;
    	
    	else
    		return false;
    }
	
    
    
	public void update() {
		
		if(health == 0)                 
			breakSound.play();              //audio to play when health reaches 0
		
		
		checkTileMapCollision();
		
		
		if(flinching) {
			long elapsed =(System.nanoTime() - flinchTimer) / 1000000;   //a timer starts in which health cannot decrease while flinching is true
			
			if(elapsed > 400) {
				flinching = false;          //condition in which to set flinching to false
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











