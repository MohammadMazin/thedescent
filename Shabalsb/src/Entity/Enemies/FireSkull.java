package Entity.Enemies;

import Entity.*;
import TileMap.TileMap;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import Audio.AudioPlayer;

public class FireSkull extends Enemy {
	
	private BufferedImage[] sprites;           //stores sprite sheets
	private HashMap<String, AudioPlayer> sfx;  //stores audio files
	private ArrayList<DarkEnergy> darkEn;      //stores DarkEnergy bullets
		
	private long time;                         //variable used as a timer
	
	private boolean firing;
	private boolean close;
	
	
	public FireSkull(TileMap tm) {
		
		super(tm);                             //calls the super class
		

		maxSpeed = 0.3;
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
		
		//dimensions of sprites
		width = 30;
		height = 30;
		
		//dimensions of collision box
		cwidth = 20;
		cheight = 20;
		
		health = maxHealth = 10;
		damage = 1;
		
		// load sprites
		try {
			
			BufferedImage spritesheet = ImageIO.read(
				getClass().getResourceAsStream(
					"/Sprites/Enemies/fireskull.png"
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
		
		//setting animation criteria
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(300);
		
		
		darkEn = new ArrayList<DarkEnergy>();
		
		right = true;
		facingRight = true;
		
	}
	

	public void setLeft(boolean b) {right = !b; facingRight = !b;}
    
	public void setFiring() {firing = true;}

	public  void playerClose(boolean b) {close = b;}
	
	private void getNextPosition() {
		
		
		
		// movement
		if(!right) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		
		// falling
		if(falling) {
			dy += fallSpeed;
		}
		
	}
	
	public void update() {
		
		
		
		if(close) {
			enemyAttack();
		}
		
		
		
		time++;
		
	
		
		//enemy attack 
		for(int i = 0; i  < darkEn.size(); i++) {
			darkEn.get(i).update();
			if(darkEn.get(i).shouldRemove()) {
				darkEn.remove(i);
				i--;
			}
		}
				
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		//check voice
		if(health == 0)
			sfx.get("death").play();
			
		
		
		// check flinching
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
	
	public void enemyAttack() {
		
			if(time < 200) return;
			
            //This part of the code only executes if value of time is greater than 200
						
				DarkEnergy fb = new DarkEnergy(tileMap, facingRight); //Creating Dark Energy objects
				
				fb.setPosition(x + 10, y);   //Setting the position
				darkEn.add(fb);              //Adding it to the ArrayList
				
				time = 0;                    //Resetting the timer
	
				
	}
	
	public void setClose(boolean b) {close = true;}
	
	
	
public void checkFire(Player p) {
		
	     //checks through all DarkEnrgy objects present in the ArrayList
		for(int j = 0; j < darkEn.size(); j++) {
		
			//executes if player and dark energy co-ordinates become the same
			if(p.getx() - darkEn.get(j).getx() < 20 && darkEn.get(j).getx() - p.getx() < 20 &&
			   p.gety() - darkEn.get(j).gety() < 20 && darkEn.get(j).gety() - p.gety() < 20) {
				
				p.hit(1);
				darkEn.remove(j);
				
				
		     }
		}
					
					
	}
	
	public void draw(Graphics2D g) {

		
		setMapPosition();
		
		// draw fireballs
				for(int i = 0; i < darkEn.size(); i++) {
					darkEn.get(i).draw(g);
				}
				
				if(flinching) {
					long elapsed =
						(System.nanoTime() - flinchTimer) / 1000000;
					if(elapsed / 100 % 2 == 0) {
						return;
					}
				}
				
		
		super.draw(g);
		
		
		
	}
	
}










