package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Audio.AudioPlayer;

public class DeathState extends GameState{
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	private AudioPlayer bgMusic;
	
	public DeathState (GameStateManager gsm){
		
		super(gsm);            //calls the superclass
		
		//loads fonts and music
		try {
		titleColor = new Color(255,255,255);
		titleFont = new Font(
				"Times New Roman",
				Font.BOLD,
				36);
		
		font = new Font("Arial", Font.BOLD, 12);
		
		bgMusic = new AudioPlayer("/Music/DeathMusic.mp3");
		
		bgMusic.play();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
    
	@Override
	public void draw(Graphics2D g) {
		//sets font and style to draw on the screen
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 45, 100);
		
		g.setColor(titleColor);
		g.setFont(font);
		g.drawString("Press 'ENTER' To Go To Main Menu", 60, 150);
		
	}

	@Override
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_ENTER) {
			bgMusic.close();
			gsm.setState(gsm.MENUSTATE);
		}
	}

	@Override
	public void keyReleased(int k) {
		
		
	}

}
