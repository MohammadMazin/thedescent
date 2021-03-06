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

public class Level4B extends GameState {
	
	private TileMap tileMap;
	private Background bg1,bg2,bg3,bg4,bg5;
	private boolean work=false;
	private Player player;
	private DarkEnergy de;
	private int count;
	private ArrayList<Enemy> enemies;
	private ArrayList<Explosion> explosions;
	private ArrayList<Enemy>coin;
	private ArrayList<DarkEnergy> darkEn;
	private HUD hud;
	
	private String[] options = {
			"FIND THE SECRET DOOR TO PROCEED",
			"COLLECT COINS TO INCREASE YOUR CHANCES"
			
		};
	
	private AudioPlayer bgMusic, itemPickup;
	private Coin c1,c2,c3;
	
	private HealthPack hp1,hp2,hp3,hp4;
	private LivesPack lp1, lp2;
	
	private FireSkull f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15;
	private Slime s;
	
	
	
	public Level4B (GameStateManager gsm) {
		super(gsm);           //calling the super class
		init();
	}
	
	public void init() {
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/mergedimage.png");
		tileMap.loadMap("/Maps/level4b.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(1);
		
		bg1 = new Background("/Backgrounds/cavebg1.png", 0.1);
		bg2 = new Background("/Backgrounds/cavebg2.png", 0.12);
		bg3 = new Background("/Backgrounds/cavebg3.png", 0.14);
		bg4 = new Background("/Backgrounds/cavebg4.png", 0.16);
		bg5 = new Background("/Backgrounds/cavebg5.png", 0.2);
		
		player = new Player(tileMap);
		if(GameStateManager.isGenpos()) {
		player.setPosition(51, 136);}
		else {
			player.setPosition(GameStateManager.getPosx(),GameStateManager.getPosy());
		}
		de = new DarkEnergy(tileMap, true);
		populateEnemies();
		populateCoins();
		
		explosions = new ArrayList<Explosion>();
		darkEn = new ArrayList<DarkEnergy>();
		
		hud = new HUD(player);
		
		bgMusic = new AudioPlayer("/Music/BlevelMusic.mp3");
       itemPickup = new AudioPlayer("/SFX/menuselect.mp3");
		
		bgMusic.play();
		
		hp1 = new HealthPack(tileMap);
		hp2 = new HealthPack(tileMap);
		hp3 = new HealthPack(tileMap);
		hp4 = new HealthPack(tileMap);
		
		lp1 = new LivesPack(tileMap);
		lp2 = new LivesPack(tileMap);
		
		hp1.setPosition( 160, 1271);
		hp2.setPosition(2320, 1178);
		hp3.setPosition(3450,  370);
		hp4.setPosition( 800,  345);
		
		lp1.setPosition(2200, 1209);
		lp2.setPosition(1930, 1089);
		
		player.setHealth(gsm.health);
		player.setLives(gsm.lives);



		
	}
	
	private void populateEnemies() {
		
		enemies = new ArrayList<Enemy>();
		
		
		Point[] points = new Point[] {
			new Point(406,667),//1
			new Point(530,667),//2
			new Point(570,667),//3
			new Point(1547,700),//4
			new Point(1350,700),//5
			new Point(1627,700),//6
			new Point(1738,700),//7
			new Point(2617,383),//8
			new Point(2412,400),//9
			new Point(1528,169),//10
			new Point(2044,182),//11
			new Point(2527,177),//12
			new Point(793,1002),//13
			new Point(1409,1042),//14
			new Point(2760,996),//15
			new Point(3267,992),//16
			new Point(3126,1301),//17
			new Point(118,1268),//18
			new Point(2209,1209),//19
			new Point(1294,1297),//20

			//fireskulls
			new Point(583,188),//1,20
			new Point(256,334),//2,21
			new Point(465,386),//3,22
			new Point(1274,675),//4,23
			new Point(1878,429),//5,24    L
			new Point(3376,178),//6,25
			new Point(3674,184),//7,26
			new Point(3669,991),//8,27    L
			new Point(736,429),//9,28
			new Point(794,347),//10,29
			new Point(3759,1175),//11,30  L
			new Point(3491,1178),//12,31  L
			new Point(1878,522),//13,32   L
			new Point(1278,1149),//14,34  
			new Point(70,1000),//15,35
			//Slimes
			new Point(253,1000),
			new Point(1081,188),
			new Point(1657,1295),
			
			
		};
		
		//Creating enemy objects and adding them to the ArrayList
		for(int i = 0; i < points.length; i++) {
			
			
			
			if(i==20)
				{
				f1 =  new FireSkull(tileMap);
				f1.setPosition(points[i].x, points[i].y);
				enemies.add(f1);
			}
			if(i==21)
			{f2 =  new FireSkull(tileMap);
			f2.setPosition(points[i].x, points[i].y);
			enemies.add(f2);
			}
			if(i==22)
			{
				f3 =  new FireSkull(tileMap);
				f3.setPosition(points[i].x, points[i].y);;
				enemies.add(f3);
			}
			if(i==23)
			{
				f4 =  new FireSkull(tileMap);
				f4.setPosition(points[i].x, points[i].y);
				enemies.add(f4);
			}
			if(i==24)
			{
		f5 = new FireSkull(tileMap);
		f5.setPosition(points[i].x, points[i].y);
		f5.setLeft(true);
		enemies.add(f5);
			}
			if(i==25)
			{
				f6 = new FireSkull(tileMap);
		f6.setPosition(points[i].x, points[i].y);
		enemies.add(f6);
			}
			if(i==26)
			{
				f7 = new FireSkull(tileMap);
		f7.setPosition(points[i].x, points[i].y);
		enemies.add(f7);
			}
			if(i==27)
			{
				f8 = new FireSkull(tileMap);
		f8.setPosition(points[i].x, points[i].y);
		f8.setLeft(true);
		enemies.add(f8);
			}
			
			if(i==28)
			
			{f9 = new FireSkull(tileMap);
				
		f9.setPosition(points[i].x, points[i].y);
		enemies.add(f9);
			}
			if(i==29)
			{
				f10= new FireSkull(tileMap);
		f10.setPosition(points[i].x, points[i].y);
		enemies.add(f10);
			}
			if(i==30)
			{
				f11= new FireSkull(tileMap);
		f11.setPosition(points[i].x, points[i].y);
		f11.setLeft(true);
		enemies.add(f11);}
			if(i==31)
			{
				f12= new FireSkull(tileMap);
		f12.setPosition(points[i].x, points[i].y);
		f12.setLeft(true);
		enemies.add(f12);}
			if(i==32)
			{
				f13= new FireSkull(tileMap);
		f13.setPosition(points[i].x, points[i].y);
		f13.setLeft(true);
		enemies.add(f13);
			}
			if(i==33)
			{f14= new FireSkull(tileMap);
				
		f14.setPosition(points[i].x, points[i].y);
		enemies.add(f14);}
			if(i==34)
			{f15= new FireSkull(tileMap);
				f15.setRight(false);
		f15.setPosition(points[i].x, points[i].y);
		enemies.add(f15);}
			else {
				s = new Slime(tileMap);
			s.setPosition(points[i].x, points[i].y);
			enemies.add(s);
			}
			
		    
			
		}
		
	}
	private void populateCoins() {
		coin = new ArrayList<Enemy>();
		Point[] points = new Point[] {
				new Point(405, 580),
				new Point(825,1120)
				
			};
			

		//Creating enemy objects and adding them to the ArrayList
			for(int i = 0; i < points.length; i++) {
				c1 = new Coin(tileMap,"/Sprites/Enemies/gatea.png");
			c2=new Coin(tileMap,"/Sprites/Enemies/gatea.png");
				if(i==1)
				c1.setPosition(points[i].x, points[i].y);
				else {
				c2.setPosition(points[i].x, points[i].y);
				}
				coin.add(c1);
				coin.add(c2);
				
			}
		
	}
	public void update() {
		
		//Update Collectibles
		lp1.update();
	    if(player.intersects(lp1)) {
	    	lp1.setPosition(0, 0);
	    	player.setLives(player.getLives() + 1);
	    	itemPickup.play();
	    }
	  //Update Collectibles
	    lp2.update();
	    if(player.intersects(lp2)) {
	    	lp2.setPosition(0, 0);
	    	player.setLives(player.getLives() + 1);
	    	itemPickup.play();
	    }
		
	  //Update Collectibles
		hp1.update();
	    if(player.intersects(hp1)) {
	    	hp1.setPosition(0, 0);
	    	player.setHealth(5);
	    	itemPickup.play();
	    }
	    //Update Collectibles
	    hp2.update();
	    if(player.intersects(hp2)) {
	    	hp2.setPosition(0, 0);
	    	player.setHealth(5);
	    	itemPickup.play();
	    }
	    //Update Collectibles
	    hp3.update();
	    if(player.intersects(hp3)) {
	    	hp3.setPosition(0, 0);
	    	player.setHealth(5);
	    	itemPickup.play();
	    }
	    //Update Collectibles
	    hp4.update();
	    if(player.intersects(hp4)) {
	    	hp4.setPosition(0, 0);
	    	player.setHealth(5);
	    	itemPickup.play();
	    }
		
		// update player
		player.update();
		tileMap.setPosition(
			GamePanel.WIDTH / 2 - player.getx(),
			GamePanel.HEIGHT / 2 - player.gety()
		);
		
		//Update Coins
		c1.update();
		c2.update();
		
		//Executed when player interacts with wrong gate
		if((((player.getx()<84&&player.getx()>24)&&(player.gety()<390&&player.gety()>330))||
				((player.getx()<770&&player.getx()>728)&&(player.gety()<360&&player.gety()>300))||
				((player.getx()<3229&&player.getx()>3187)&&(player.gety()<390&&player.gety()>330))||
				((player.getx()<3411&&player.getx()>3366)&&(player.gety()<390&&player.gety()>330))||
				((player.getx()<321&&player.getx()>277)&&(player.gety()<600&&player.gety()>540))||
				((player.getx()<2300&&player.getx()>2256)&&(player.gety()<720&&player.gety()>660))||
				((player.getx()<172&&player.getx()>125)&&(player.gety()<840&&player.gety()>780))
				||((player.getx()<347&&player.getx()>306)&&(player.gety()<930&&player.gety()>870))
				||((player.getx()<3834&&player.getx()>3787)&&(player.gety()<1020&&player.gety()>960))
				||((player.getx()<111&&player.getx()>66)&&(player.gety()<1290&&player.gety()>1230))
				||((player.getx()<617&&player.getx()>580)&&(player.gety()<1110&&player.gety()>1050))
				||((player.getx()<2419&&player.getx()>2378)&&(player.gety()<1200&&player.gety()>1140))
				||((player.getx()<2904&&player.getx()>2857)&&(player.gety()<1320&&player.gety()>1260))
				||((player.getx()<3743&&player.getx()>3699)&&(player.gety()<1320&&player.gety()>1260)))
				&&work) {
			GameStateManager.setPosx(player.getx());
			GameStateManager.setPosy(player.gety());
			GameStateManager.setGenpos(false);
			bgMusic.stop();
			gsm.setState(GameStateManager.NOTICESTATE);
			count=gsm.getCount();
			count--;
			gsm.setCount(count);
		}
		
		//Executes when player interacts with correct gate
		if((player.getx()<1194&&player.getx()>1148)&&(player.gety()<1110&&player.gety()>1050)&& work)
		{
			GameStateManager.setGenpos(true);
			bgMusic.stop();
			gsm.lives = player.getLives();
			gsm.health = player.getHealth();
			gsm.setState(GameStateManager.FINALSTATE);
		}
		if(Player.getHealth()==0) {
			if(player.getLives() == 1) {
				
				bgMusic.close();
		      	gsm.setState(GameStateManager.DEATHSTATE);
	     	}
			
			
			//all enemies are removed from the ArrayList and then added again
			enemies.removeAll(enemies);
			populateEnemies();
			
			Player.setHealth(3);
			player.setLives(player.getLives() - 1);
			player.setPosition(48,863);
			
			hp1.setPosition( 160, 1271);
			hp2.setPosition(2320, 1178);
			hp3.setPosition(3450,  370);
			hp4.setPosition( 800,  345);
			
			lp1.setPosition(2200, 1209);
			lp2.setPosition(1930, 1089);
		}
		
		
		// set background
		bg1.setPosition(tileMap.getx());
		bg2.setPosition(tileMap.getx());
		bg3.setPosition(tileMap.getx());
		bg5.setPosition(tileMap.getx());
		
		bg4.update();
		
	    //update player attacks
		player.checkAttack(enemies);
		
		//Update DarkEnergy
		de.update();
		
		
		//Update and Set FireSkulls to Shoot
		f1.checkFire(player);
        f1.setClose(true);	
        
        f2.checkFire(player);
        f2.setClose(true);	
        
        f3.checkFire(player);
        f3.setClose(true);	
        
        f4.checkFire(player);
        f4.setClose(true);	
        
        f5.checkFire(player);
        f5.setClose(true);	
        
        f6.checkFire(player);
        f6.setClose(true);	
        
        f7.checkFire(player);
        f7.setClose(true);	
        
        f8.checkFire(player);
        f8.setClose(true);	
        
        f9.checkFire(player);
        f9.setClose(true);	
        
        f10.checkFire(player);
        f10.setClose(true);	
        
        f11.checkFire(player);
        f11.setClose(true);	
        
        f12.checkFire(player);
        f12.setClose(true);	
        
        f13.checkFire(player);
        f13.setClose(true);	
        
        f14.checkFire(player);
        f14.setClose(true);	
        
        f15.checkFire(player);
        f15.setClose(true);	
        
        
		// attack enemies
		
		 for(int i = 0 ; i < coin.size(); i++){
		        if(player.intersects(coin.get(i))) {
		        	itemPickup.play();
		               coin.remove(i);      
			 count=gsm.getCount();
				count++;
				gsm.setCount(count);}
	           
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
		
		
		// update explosions
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).update();
			if(explosions.get(i).shouldRemove()) {
				explosions.remove(i);
				i--;
			}
		}
		
	}
	public void pause() {
		
		//setting values of static variables in gameStateManager
		GameStateManager.setPosx(player.getx());
		GameStateManager.setPosy(player.gety());
		GameStateManager.setGenpos(false);
		bgMusic.stop();
		
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg1.draw(g);
		bg2.draw(g);
		bg3.draw(g);
		bg4.draw(g);
		bg5.draw(g);
		
		// draw tilemap
		tileMap.draw(g);
		
		//draw Collectibles
		hp1.draw(g);
		hp2.draw(g);
		hp3.draw(g);
		hp4.draw(g);
		
		lp1.draw(g);
		lp2.draw(g);
		
		
		// draw player
		player.draw(g);
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
			
			
		}
		for(int i = 0; i < coin.size(); i++) {
			coin.get(i).draw(g);
			
		
		}
		// draw explosions
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).setMapPosition(
				(int)tileMap.getx(), (int)tileMap.gety());
			explosions.get(i).draw(g);
		}
		
		// draw hud
		hud.draw(g);
		
		de.draw(g);
		
		if(player.getx() >  100 && player.getx() < 140 && player.gety() < 220) {
			g.setFont(new Font(
					"Century Gothic",
					Font.BOLD,
					11));
			
			
			g.setColor(Color.WHITE);
			g.drawString(options[0], 75, 35 + 1 * 15);
			g.drawString(options[1], 75, 35 + 2 * 15);
			
		    
		
         }
		
		g.setFont(new Font("Century Gothic",Font.BOLD,11));
		if(gsm.getCount() > 3) {
		g.setColor(Color.WHITE);
		g.drawString("Chances: " + gsm.getCount(), 5, 85);}
		else {
			g.setColor(Color.RED);
			g.drawString("Chances: " + gsm.getCount(), 5, 85);}
		}
		
		
		
	
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_W) player.setJumping(true);
		if(k == KeyEvent.VK_E) player.setGliding(true);
		if(k == KeyEvent.VK_ENTER)enter();
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
		if(k == KeyEvent.VK_ENTER)work=false;
	}
	
	public void enter() {
		if(gsm.isPaused())gsm.setPaused(false);
		else{work=true;}
	}
}












