package GameState;

import Main.GamePanel;
import TileMap.*;
import Entity.*;
import Entity.Enemies.*;
import Entity.Enemies.Coin;
import Audio.AudioPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Level2A extends GameState {
	
	private TileMap tileMap;
	private Background bg1,bg2,bg3;
	
	private DarkEnergy de;
	
	private Player player;
	private String[] options = {
			"DEFEAT ALL THE ENEMIES TO PROCEED",
			"ALL ENEMIES DEFEATED",	
		};
	
	private Color titleColor;
	private Font titleFont;
	
	private ArrayList<Enemy> enemies ,   trapEn;
	private ArrayList<Explosion> explosions;
	
	
    private Coin coin1,coin2;
    private Slime s;
    private FireSkull f1,f2,f3,f4,f5,f6,f7,f8, f9, f10;
	
	private int coinNum;
	private boolean enemyInit;
	
	private HealthPack hp;
	private LivesPack lp;
	
	private HUD hud;
	
	private AudioPlayer bgMusic, itemPickup;
	
	//---------------------------------------------------------------------//
	
	public Level2A(GameStateManager gsm) {
		super(gsm);
		titleColor = new Color(128, 0, 0);
		titleFont = new Font(
				"Century Gothic",
				Font.BOLD,
				11);
		init();
	}
	
	public void init() {
		
		//Initializing the different variables and elements in the level
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/RockTileset.png");
		tileMap.loadMap("/Maps/lvl2aDone.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(1);
		
		
		bg1 = new Background("/Backgrounds/forestbg1.jpg", 0.1);
		bg2 = new Background("/Backgrounds/forestbg2.png", 0.2);
		bg3 = new Background("/Backgrounds/forestbg3.png", 0.3);
		
		player = new Player(tileMap);
		player.setPosition(1410, 279);
		
		de = new DarkEnergy(tileMap, true);
		
		
		enemyInit = false;
		populateEnemies();
		
		explosions = new ArrayList<Explosion>();
		
		
		hud = new HUD(player);
		
		bgMusic = new AudioPlayer("/Music/alevelmusic.mp3");
		itemPickup = new AudioPlayer("/SFX/menuselect.mp3");
		
		bgMusic.play();
		
		hp = new HealthPack(tileMap);
		lp = new LivesPack(tileMap);
		
		hp.setPosition(2207, 467);
		lp.setPosition(2500, 188);
		
		player.setHealth(gsm.health);
		player.setLives(gsm.lives);
		
	}
	
	private void populateEnemies() {
		
		enemies = new ArrayList<Enemy>();
		
		de.setPosition(200, 100);
		
	//	FireSkull s;
		Point[] points = new Point[] {
			//coins(0 - 1)
			new Point(2770, 195),
			new Point(2770, 135),
			
		    //ENEMIES - Fireskull(2-9)
			new Point(  40, 460),   
	     	new Point(  40, 400),
	     	new Point(  40, 280),
	     	new Point(  40, 220),
	     	new Point( 520, 370),
	     	new Point( 810, 160),   //L
	     	new Point(1660, 310),   //L
	     	new Point(2740, 340),   //L
	     	
	     	//Enemy - Slime
			new Point( 420, 440),
			new Point( 530, 440),
			new Point( 560, 440),
			new Point( 590, 440),
			new Point( 750, 440),
			new Point( 970, 440),
			new Point( 680, 190),
			new Point( 700, 190),
			new Point(1670, 310),
		    new Point(2470, 280),
			new Point(2490, 440)
			
		};
		
		//Creating enemy objects and adding them to the ArrayList
		for(int i = 0; i < points.length; i++) {
			if(i < 2) {
				if(i == 0) {
				coin1 = new Coin(tileMap, "/ItemSprite/gatea.png");
				
				coin1.setPosition(points[i].x, points[i].y);
				enemies.add(coin1);
				}
				else if(i == 1) {
				coin2 = new Coin(tileMap, "/ItemSprite/gateb.png");
				
				coin2.setPosition(points[i].x, points[i].y);
				enemies.add(coin2);}
				
				coinNum++;
				
			}
			else if( i == 2) {
				f1 =  new FireSkull(tileMap);
				f1.setPosition(points[i].x, points[i].y);
				enemies.add(f1);
			}
			else if( i == 3) {
				f2 =  new FireSkull(tileMap);
				f2.setPosition(points[i].x, points[i].y);
				enemies.add(f2);
			}
			else if( i == 4) {
				f3 =  new FireSkull(tileMap);
				f3.setPosition(points[i].x, points[i].y);;
				enemies.add(f3);
			}
			else if( i == 5) {
				f4 =  new FireSkull(tileMap);
				f4.setPosition(points[i].x, points[i].y);
				enemies.add(f4);
			}
			else if( i == 6) {
				f5 =  new FireSkull(tileMap);
				f5.setPosition(points[i].x, points[i].y);
				enemies.add(f5);
			}
			else if( i == 7) {
				f6 =  new FireSkull(tileMap);
				f6.setPosition(points[i].x, points[i].y);
				f6.setLeft(true);
				enemies.add(f6);
			}
			else if( i == 8) {
				f7 =  new FireSkull(tileMap);
				f7.setPosition(points[i].x, points[i].y);
				f7.setLeft(true);
				enemies.add(f7);
			}
			else if( i == 9) {
				f8 =  new FireSkull(tileMap);
				f8.setPosition(points[i].x, points[i].y);
				f8.setLeft(true);
				enemies.add(f8);
			}
			
			else {
			s = new Slime(tileMap);
			s.setPosition(points[i].x, points[i].y);
			enemies.add(s);
			
			}
		}
		
		
	}
	
	public void trapEnemies() {
        
		trapEn = new ArrayList<Enemy>();
		
	
		
		
		de.setPosition(200, 100);
		
	//	FireSkull s;
		Point[] points2 = new Point[] {
		
			//ENEMIES - Fireskull(0-1)
			new Point(2950, 35),  
			new Point(3160, 35),    //L
			new Point(3184, 35),
			new Point(3120, 35),
			new Point(3150, 35),
			new Point(3150, 450)
			
		};
		
		//Creating enemy objects and adding them to the ArrayList
		for(int i = 0; i < points2.length; i++) {
			
				if(i == 0) {
				f9 = new FireSkull(tileMap);
				f9.setPosition(points2[i].x, points2[i].y);
				trapEn.add(f9);
				}
				else if(i == 1){
					
				f10 = new FireSkull(tileMap);
				f10.setPosition(points2[i].x, points2[i].y);
				trapEn.add(f10);
				}
				
		
			else {
			s = new Slime(tileMap);
			s.setPosition(points2[i].x, points2[i].y);
			trapEn.add(s);
			
			}
		}
		
	}
	
	public void update() {
		
		
		//update collectibles
		lp.update();
	    if(player.intersects(lp)) {
	    	lp.setPosition(0, 0);
	    	player.setLives(player.getLives() + 1);
	    	itemPickup.play();
	    }
		
		hp.update();
	    if(player.intersects(hp)) {
	    	hp.setPosition(0, 0);
	    	player.setHealth(5);
	    	itemPickup.play();
	    }
		
		
		//Condition in which player loses
		if(player.dyingCondition(1783, 2891, 540) || player.getHealth() == 0) {
			
			if(player.getLives() == 1) {
				bgMusic.close();
		      	gsm.setState(gsm.DEATHSTATE);
	     	}
			
			//all enemies are removed from the ArrayList and then added again
			enemies.removeAll(enemies);
			populateEnemies();
			
			player.setHealth(5);
			player.setLives(player.getLives() - 1);
			player.setPosition(1410, 279);
			
			hp.setPosition(2207, 467);
			lp.setPosition(2500, 188);
		}
		
		
	  //Level Changing condition
	   if(player.intersects(coin1)) {
		   bgMusic.close();
		   gsm.lives = player.getLives();
			gsm.health = player.getHealth();
		   gsm.setState(gsm.LEVEL3A);
	   }
	  //Level Changing condition
	   if(player.intersects(coin2)){
		   bgMusic.close();
		   gsm.lives = player.getLives();
		   gsm.health = player.getHealth();
		   gsm.setState(gsm.LEVEL3B);
	   }
		
		//update DarkEnergy
		de.update();
		
		//Update FireSkull Enemies
		f1.checkFire(player);
		f2.checkFire(player);
		f3.checkFire(player);
		f4.checkFire(player);
		f5.checkFire(player);
		f6.checkFire(player);
		f7.checkFire(player);
		f8.checkFire(player);
		
		
		if(enemyInit) {
			//Makes FireSkulls shoot
			f9.setClose(true);
			f10.setClose(true);
			
			f10.setLeft(true);
			
			f9.checkFire(player);
			f10.checkFire(player);
			
		}
		
		
		
		//update music
		bgMusic.loop();
		
		
		
		// update player
		player.update();
		
	    //camera Movement
		tileMap.setPosition(
			GamePanel.WIDTH / 2 - player.getx(),
			GamePanel.HEIGHT / 2 - player.gety()
		);
	
		
		
		// set background
		bg1.setPosition(tileMap.getx(), tileMap.gety());
		bg2.setPosition(tileMap.getx(), tileMap.gety());
		bg3.setPosition(tileMap.getx(), tileMap.gety());
		
		// attack enemies
		player.checkAttack(enemies);
		if(enemyInit)
		player.checkAttack(trapEn);
		
		// update explosions
				for(int i = 0; i < explosions.size(); i++) {
					explosions.get(i).update();
					if(explosions.get(i).shouldRemove()) {
						explosions.remove(i);
						i--;
					}
				}
		
	 		
		// update all enemies
		for(int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			e.update();
			if(e.isDead()) {
				
				enemies.remove(i);
				i--;
				explosions.add(
					new Explosion(e.getx(), e.gety()));
			}
		}
		
		//updating when FireSkulls Should Shoot Their PRojectiles
		for(int i = coinNum; i < enemies.size(); i++) {
			if(player.getx() - enemies.get(i).getx() < 100 &&
					enemies.get(i).getx() - player.getx() < 100) {
				enemies.get(i).playerClose(true);
		  }
			else
				enemies.get(i).playerClose(false);
		}
		
		
		//Updating Trap Enemies
		if(enemyInit) {
		for(int i = 0; i < trapEn.size(); i++) {
			Enemy e2 = trapEn.get(i);
			e2.update();
			if(e2.isDead()) {
				
				trapEn.remove(i);
				i--;
				explosions.add(
					new Explosion(e2.getx(), e2.gety()));
			}
		}
		}
		
		
		//Changing the Map Layout when All Enemies have Been Defeated
		if(enemyInit)
			if(enemies.size() == 2 || trapEn.size() == 0) {
				tileMap.loadMap("/Maps/lvl2a.map");
			}
		

		//Spawning New Set of Enemies When Player Crosses a Certain Point
		  if(player.getx() > 3000) {
				if(enemyInit) return;
				trapEnemies();
				enemyInit = true;
			}
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(titleColor);
		g.setFont(titleFont);
		
		//draw DarkEnergy
		de.draw(g);
		
		// draw bg
		bg1.draw(g);
		bg2.draw(g);
		bg3.draw(g);
		
		//draw Collectibles
		
		// draw tilemap
		tileMap.draw(g);
		
		lp.draw(g);
		hp.draw(g);
		
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		if(enemyInit) {
		for(int i = 0; i < trapEn.size(); i++) {
			trapEn.get(i).draw(g);
		 }
		}
		
		// draw player
				player.draw(g);
		
		// draw explosions
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).setMapPosition(
				(int)tileMap.getx(), (int)tileMap.gety());
			explosions.get(i).draw(g);
		}
		
		// draw hud
		hud.draw(g);
		
		
		//draw text
		if((player.getx() > 1380 && player.getx() < 1420)) {
			g.setFont(titleFont);
			
				
				g.setColor(Color.WHITE);
				g.drawString(options[0], 75, 75 + 1 * 15);
			    
			
	}
		if(enemyInit)
		if(enemies.size() == 2 && trapEn.size() == 0) {
			g.setFont(titleFont);
			
				
				g.setColor(Color.WHITE);
				g.drawString(options[1], 75, 75 + 1 * 15);
			    
	
		}
	
		
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_W) player.setJumping(true);
		if(k == KeyEvent.VK_E) player.setGliding(true);
		if(k == KeyEvent.VK_R) player.setScratching();
		if(k == KeyEvent.VK_ESCAPE) gsm.setPaused(true);
		if(gsm.paused) {
			if(k == KeyEvent.VK_ENTER) gsm.setPaused(false);
			if(k == KeyEvent.VK_M) {
				bgMusic.stop();
				gsm.setPaused(false);
				gsm.setState(gsm.MENUSTATE);
			}
		}
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
		if(k == KeyEvent.VK_W) player.setJumping(false);
		if(k == KeyEvent.VK_E) player.setGliding(false);
	}
	
}












