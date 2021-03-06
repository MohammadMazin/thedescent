package TileMap;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Background {
	
	private BufferedImage image;
	
	private double x;
	private double y;
	
	private double dx;
	private double dy;
	
	
	private double moveScale;
	
	//Constrcutor to be called if no horizontal movement of background is not needed
public Background(String s) {
		
	//loads sprites
		try {
			image = ImageIO.read(
				getClass().getResourceAsStream(s)
			);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
   //Constrcutor to be called if no horizontal movement of background is needed 
	public Background(String s, double ms) {
		
		//loads sprites
		try {
			image = ImageIO.read(
				getClass().getResourceAsStream(s)
			);
			moveScale = ms;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void setPosition(double x) {
		this.x = (x * moveScale) % GamePanel.WIDTH;
		
	}
	
	
	public void setPosition(double x, double y) {
		this.x = (x * moveScale) % GamePanel.WIDTH;
		this.y = (y * moveScale) % GamePanel.HEIGHT;
	}
	
	//Method which moves background vertically and horizontally
	public void setVector(double dx, double dy) {
		this.dx = dx;
	    this.dy = dy;
	}
	
	public void update() {
		
		//only horizontal movement of background
		x += dx;
		
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, (int)x, (int)y, null);
		
		if(x < 0) {
			g.drawImage(
				image,
				(int)x + GamePanel.WIDTH,
				(int)y,
				null
			);
		}
		if(x > 0) {
			g.drawImage(
				image,
				(int)x - GamePanel.WIDTH,
				(int)y,
				null
			);
		}
	}
	
}







