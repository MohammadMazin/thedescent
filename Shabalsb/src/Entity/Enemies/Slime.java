package Entity.Enemies;

import Entity.*;
import TileMap.TileMap;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import Audio.AudioPlayer;

public class Slime extends Enemy {
	 
	private BufferedImage[] sprites;               //variable to store sprite sheets
	private HashMap<String, AudioPlayer> sfx;      //variable to store audio files
	
	
	public Slime(TileMap tm) {
		
		super(tm);             //calls the superclass
		
		moveSpeed = 0.3;
		maxSpeed = 0.3;
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
		
		//dimensions of sprites
		width = 30;
		height = 30;
		
		//dimensions of collision box
		cwidth = 20;
		cheight = 20;
		
		health = maxHealth = 2;
		damage = 1;
		
		// load sprites
		try {
			
			BufferedImage spritesheet = ImageIO.read(
				getClass().getResourceAsStream(
					"/Sprites/Enemies/slime.png"
				)
			);
			
			sprites = new BufferedImage[3];
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
		
		//Initializing HashMap
		sfx = new HashMap<String, AudioPlayer>();
		sfx.put("death", new AudioPlayer("/SFX/enemyhit.mp3"));
		
		//animation criteria
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(300);
		
		
		//so object faces right
		right = true;
		facingRight = true;
		
	}
	
	public boolean isRight() {return right;}
	
	private void getNextPosition() {
		
		// movement
		if(left) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		else if(right) {
			dx += moveSpeed;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
		}
		
		// falling
		if(falling) {
			dy += fallSpeed;
		}
		
	}
	
	public void update() {
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		//check voice
		if(health == 0)
			sfx.get("death").play();
	
		
		// if it hits a wall, go other direction
		if(right && dx == 0) {
			right = false;
			left = true;
			facingRight = false;
		}
		else if(left && dx == 0) {
			right = true;
			left = false;
			facingRight = true;
		}
		
		// update animation
		animation.update();
		
	}
	
	public void draw(Graphics2D g) {
		

		
		setMapPosition();
		
		super.draw(g);
		
	}
	
}











