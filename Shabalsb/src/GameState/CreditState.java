package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Audio.AudioPlayer;
import Main.GamePanel;
import TileMap.Background;
import TileMap.TileMap;

public class CreditState extends GameState{

	
	private TileMap tileMap;
	private Background bg;
	private AudioPlayer breeze, bgMusic;
	
	private boolean exitCredit;
	
	private String[] storyEnd = {
			"With The Beast Finally Destroyed",
			"The Villagers Started To Return Back",
			"To Their Homes",
			////////
			"The Return of the Hero was Celebrated",
			"For his Bravery, he was rewarded",
			"For his kindness, he was respected",
			"For His Sacrifice, he became...",
			///
			"A LEGEND!"
			
			
	};
	
	private String[] options = {
			"THE DESCENT",
			////////
			"MADE BY",
			"Syed Mohammad Mazin",
			"Hannan Aamir",
			"Wajahat Hasan",
			/////////
			"THANKS TO",
			"legacyYT tutorials",
		    ////////
			"SPRITES USED",
			"From itch.io",
			"and Designed by Ourselves",
			////////
			"MUSIC",
			"Attack on Titan",
			"and Other Places!",
			///////
			"Thank You for Playing!",
			"YeeHaw!",
			//////
			"Press 'M' To Go Exit Credits"
		};
	private Color titleColor;
	private Font titleFont;
	
	private int time, count, textx;
	
	public CreditState(GameStateManager gsm2) {
		super(gsm2);
		// TODO Auto-generated constructor stub
		titleColor = new Color(128, 0, 0);
		titleFont = new Font(
				"Century Gothic",
				Font.BOLD,
				11);
		
		time = 0;
		textx = 80;
		
		bg = new Background("/Backgrounds/creditsbg.png");
		breeze = new AudioPlayer("/Music/breeze.mp3");
		bgMusic = new AudioPlayer("/Music/creditmusic.mp3");
		
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		breeze.play();
		bgMusic.play();
		count = 0;
		
		exitCredit = false;
	}
   
	@Override
	public void update() {
		
		//executes when player sets boolean to true and moves to Main Menu
		if(exitCredit) {
			breeze.stop();
			bgMusic.stop();
			gsm.setState(gsm.MENUSTATE);
		}
		
		
		breeze.loop();
		
		//executes to switch between text
		if(time > 300) {
			time = 0;
			count++;
		}
		
		//keeps increasing value of time
		time++;
		
	
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		//Series of text that should be drawn depending on value of count
		
		if(count == 0) {
			
	     	bg.draw(g);
			g.setFont(titleFont);
			g.setColor(Color.WHITE);
			g.drawString(storyEnd[0], textx, 75 + 1 * 15);	
			g.drawString(storyEnd[1], textx, 75 + 2 * 15);
			g.drawString(storyEnd[2], textx, 75 + 3 * 15);	
		}
		else if(count == 1){
			    
			   bg.draw(g);
		     	
				g.setFont(titleFont);
				g.setColor(Color.WHITE);
				
				g.drawString(storyEnd[3], textx, 75 + 1 * 15);	
				g.drawString(storyEnd[4], textx, 75 + 2 * 15);	
				g.drawString(storyEnd[5], textx, 75 + 3 * 15);	
				g.drawString(storyEnd[6], textx, 75 + 4 * 15);	
				
		}
		else if(count == 3){
		    
			   bg.draw(g);
		     	
				g.setFont(titleFont);
				g.setColor(Color.WHITE);
				
				g.drawString(storyEnd[7], 130, 100 + 1 * 15);	
			
				
				
				
		}
		
       if(count == 5) {
			
	     	bg.draw(g);
			g.setFont(new Font("Times New Roman",Font.BOLD,11));
			g.setColor(Color.BLACK);
			g.drawString(options[0], 130, 100 + 1 * 15);	
		}
		else if(count == 6){
			    
			   bg.draw(g);
		     	
				g.setFont(titleFont);
				g.setColor(Color.BLACK);
				g.drawString(options[1], textx, 75 + 1 * 15);
				g.setColor(Color.WHITE);
				g.drawString(options[2], textx, 75 + 2 * 15);	
				g.drawString(options[3], textx, 75 + 3 * 15);	
				g.drawString(options[4], textx, 75 + 4 * 15);	
				
				
			
				
		}
		else if(count == 7){
		    
			   bg.draw(g);
		     	
				g.setFont(titleFont);
				g.setColor(Color.BLACK);
				g.drawString(options[5], textx, 75 + 1 * 15);
				
				g.setColor(Color.WHITE);
				g.drawString(options[6], textx, 75 + 2 * 15);	
				
				
				
		}
		else if(count == 8){
		    
			   bg.draw(g);
		     	
				g.setFont(titleFont);
				g.setColor(Color.BLACK);
				g.drawString(options[7], textx, 75 + 1 * 15);
				
				g.setColor(Color.WHITE);
				g.drawString(options[8], textx, 75 + 2 * 15);	
				g.drawString(options[9], textx, 75 + 3 * 15);	
				
				
				
		}
		else if(count == 9){
		    
			   bg.draw(g);
		     	
			   g.setFont(titleFont);
				g.setColor(Color.BLACK);
				g.drawString(options[10], textx, 75 + 1 * 15);
				
				g.setColor(Color.WHITE);
				g.drawString(options[11], textx, 75 + 2 * 15);	
				g.drawString(options[12], textx, 75 + 3 * 15);	;	
				
				
				
		}
		else if(count == 10){
		    
			   bg.draw(g);
		     	
			   g.setFont(titleFont);
				g.setColor(Color.BLACK);
				g.drawString(options[13], 100, 100 + 1 * 15);
				
				g.setColor(Color.WHITE);
				g.drawString(options[14], 130, 100 + 2 * 15);	
					;	
				
				
				
		}
		else if(count == 11){
		    
			    g.setFont(titleFont);
				g.setColor(Color.BLACK);
				g.drawString(options[15], 100, 135 + 6 * 15);
				
				
		}
		
		
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER) count++; time = 0;
		
		if(count >= 11) {
			if(k == KeyEvent.VK_M) exitCredit = true;
		}
		
	}

	@Override
	public void keyReleased(int k) {}

}
