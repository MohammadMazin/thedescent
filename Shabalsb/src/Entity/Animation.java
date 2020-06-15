package Entity;

import java.awt.image.BufferedImage;

public class Animation {
	
	private BufferedImage[] frames;
	private int currentFrame;           //stores value of current frame that is being shown
	
	private long startTime;             //determines start of a frame
	private long delay;                 //sets how long each frame will be played
	 
	private boolean playedOnce;         //boolean to show if a certain frame has played once or not
	
	public Animation() {
		playedOnce = false;
	}
	
	public void setFrames(BufferedImage[] frames) {
		this.frames = frames;             
		currentFrame = 0;                     //sets current frame to first frame in the BuffferedImage
		startTime = System.nanoTime();        //starts a timer
		playedOnce = false;  
	}
	
	public void setDelay(long d) { delay = d; }
	public void setFrame(int i) { currentFrame = i; }
	
	public int getFrame() { return currentFrame; }
	public BufferedImage getImage() { return frames[currentFrame]; }
	public boolean hasPlayedOnce() { return playedOnce; }
	
	
	public void update() {
		
		if(delay == -1) return;                                     //current sprite does not change
		
		long elapsed = (System.nanoTime() - startTime) / 1000000;   //to calculate elapsed time for the current frame
		
		if(elapsed > delay) {                                       //executes when elapsed time is greater than the defined delay time
			currentFrame++;                                         //shifts to next frame
			startTime = System.nanoTime();                          //timer restarts
		}
		
		if(currentFrame == frames.length) {                         
			playedOnce = true;
			currentFrame = 0;
			
		}
		
	}
	
	
	
}
















