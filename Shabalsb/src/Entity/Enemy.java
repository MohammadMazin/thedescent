package Entity;

import TileMap.TileMap;

public class Enemy extends MapObject {
	
	protected int health;
	protected int maxHealth;
	protected boolean dead;                         //a boolean which determines if enemy is dead or not
	
	protected int damage;
	protected boolean close;
	
	protected boolean flinching;
	protected long flinchTimer;
	
	public Enemy(TileMap tm) {
		super(tm);
	}
	
	public boolean isDead() { return dead; }
	public int getDamage() { return damage; }
	
	public  void playerClose(boolean b) {close = b;}
	
	public void hit(int damage) {
		
		if(dead || flinching) return;             //enemy cannot be hit if already dead or if flinching
		
		health -= damage;                         //health is reduced based on damage value
		if(health < 0) health = 0;
		if(health == 0) dead = true;
		
		flinching = true;
		flinchTimer = System.nanoTime();          //starts timer that is used in subclass
	}
	
	public void update() {}
	
	public void checkFire(Player p) {}

	
	
}














