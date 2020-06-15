package Handler;

public class Stats {

	static int tempLives = 3;
	
	public Stats() {}
	
	public void setTempLives(int tempLives) {
		if(tempLives > 3)
			tempLives = 3;
		
		this.tempLives = tempLives;}
	public int getTempLives() {return tempLives;}
	
}
