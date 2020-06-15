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

public class Level3A extends GameState {
	
	private TileMap tileMap;
	private Background bg1,bg2,bg3;
	
	private DarkEnergy de;
	
	private Player player;
	private String[] options = {
			"You Can Now Shoot Plasma!",
			"Press 'F' to shoot",	
		};
	
	private Color titleColor;
	private Font titleFont;
	
	private ArrayList<Enemy> enemies ,   trapEn;
	private ArrayList<Explosion> explosions;
	private ArrayList<DarkEnergy> darkEn;
    private Coin coin1,coin2;
    private Slime s;
    private FireSkull f1,f2,f3,f4,f5,f6,f7,f8, f9, f10;
    private HealthPack hp;
	
	private int coinNum;
	
	//NEED TO UPDATE MAP

	
	private HUD hud;
	
	private AudioPlayer bgMusic , itemPickup;
	
	//---------------------------------------------------------------------//
	
	public Level3A(GameStateManager gsm) {
		super(gsm);                        //call the superclass
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
		tileMap.loadTiles("/Tilesets/Bmaptileset.png");
		tileMap.loadMap("/Maps/level3a.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(1);
	
		
		bg1 = new Background("/Backgrounds/townbg1.png", 0.1);
		bg2 = new Background("/Backgrounds/townbg2.png", 0.14);
		bg3 = new Background("/Backgrounds/cloudbg.png", 0.2);
		
		player = new Player(tileMap);
		player.setPosition(57, 90);
		player.setFiring(false);
		
		de = new DarkEnergy(tileMap, true);
				
		populateEnemies();
		
		explosions = new ArrayList<Explosion>();
		darkEn = new ArrayList<DarkEnergy>();
		
		hud = new HUD(player);
		
		bgMusic = new AudioPlayer("/Music/alevelmusic.mp3");
		itemPickup = new AudioPlayer("/SFX/menuselect.mp3");
		
		bgMusic.play();
		
		player.setHealth(5);
		player.setMaxHealth(5);
		player.setLives(gsm.lives);

		
	}
	
	private void populateEnemies() {
		
		enemies = new ArrayList<Enemy>();
		
		de.setPosition(200, 100);
		
	
		Point[] points = new Point[] {
			//coins(0 - 1)
			new Point(2240, 880),
			new Point(2520, 880),
			
		    //ENEMIES - Fireskull(2-9)
			new Point(54, 365),  
			new Point(230, 709),
			new Point(670, 252),  
			new Point(1039, 247),
			new Point(1313, 249),  
			new Point(1548, 513),   //R
			new Point(1700, 513),   //L
			new Point(912, 880),   
	     	
	     	//Enemy - Slime
			new Point(95, 376),  
			new Point(115, 376),
			new Point(135, 376),  
			new Point(373, 523),
			new Point(393, 523),  
			new Point(500, 523),
			new Point(520, 523),  
			new Point(254, 700),
			new Point(735, 243),  
			new Point(755, 243),
		    new Point(1097, 243),  
			new Point(1117, 243),
			new Point(1591, 492),
			new Point(1691, 492),
			
		
			
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
				
				enemies.add(f8);
			}
			
			else {
			s = new Slime(tileMap);
			s.setPosition(points[i].x, points[i].y);
			enemies.add(s);
			
			}
			
			
			
			hp = new HealthPack(tileMap);
			hp.setPosition(1618, 515);
		}
		
		
	}
	
	
	
	public void update() {
		
		//Health Pack Update
		hp.update();
	    if(player.intersects(hp)) {
	    	hp.setPosition(0, 0);
	    	player.setHealth(5);
	    	itemPickup.play();
	    }
		
		
		//Player Losing Condition
		if(player.dyingCondition(1223, 2200, 842) || player.getHealth() == 0) {
			
			if(player.getLives() == 1) {
				bgMusic.close();
		      	gsm.setState(gsm.DEATHSTATE);
	     	}
			
			//all enemies are removed from the ArrayList and then added again
			enemies.removeAll(enemies);
			populateEnemies();
			
			player.setHealth(5);
			player.setLives(player.getLives() - 1);
			player.setPosition(57, 90);
			
			hp.setPosition(1618, 530);
		}
		
	   //Level Changing Condition
	   if(player.intersects(coin1)) {
		   bgMusic.close();
		   gsm.lives = player.getLives();
		   gsm.health = player.getHealth();
		   gsm.setState(gsm.LEVEL4A);
	   }
	   if(player.intersects(coin2)){
		   bgMusic.close();
		   gsm.lives = player.getLives();
		   gsm.health = player.getHealth();
		   gsm.setState(gsm.LEVEL4B);
	   }
		
		//Dark Energy Update
		de.update();
		
		//FireSkull Update
		f1.checkFire(player);
		f2.checkFire(player);
		f3.checkFire(player);
		f4.checkFire(player);
		f5.checkFire(player);
		f6.checkFire(player);
		f7.checkFire(player);
		f8.checkFire(player);
		
		//Setting position of FireSkulls
		f3.setRight(true);
		f7.setRight(true);
		f8.setRight(true);
		
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
		
		//Updating When Enemies Shoot Their Projectiles
		for(int i = coinNum; i < enemies.size(); i++) {
			if(player.getx() - enemies.get(i).getx() < 100 &&
					enemies.get(i).getx() - player.getx() < 100) {
				enemies.get(i).playerClose(true);
		  }
			else
				enemies.get(i).playerClose(false);
		}
		
		
		
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(titleColor);
		g.setFont(titleFont);
		
		//Drawing Dark Energy
		de.draw(g);
		
		// draw bg
		bg1.draw(g);
		bg2.draw(g);
		bg3.draw(g);
		
		
		// draw tilemap
		tileMap.draw(g);
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		//Drawing Healthpack
		hp.draw(g);
		
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
		if((player.getx() > 220 && player.getx() < 260) && player.gety() < 138) {
			g.setFont(titleFont);
			
				
				g.setColor(Color.WHITE);
				g.drawString(options[0], 85, 45 + 1 * 15);
				g.drawString(options[1], 85, 45 + 2 * 15);
			    
			
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
		if(k == KeyEvent.VK_F) player.setFiring();
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












