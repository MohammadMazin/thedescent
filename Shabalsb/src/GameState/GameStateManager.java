package GameState;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.GamePanel;

public class GameStateManager {
	
	private GameState[] gameStates;
	private int currentState;
	
	static int health = 5;
	static int lives = 3;
	
	private PauseState pauseState;
	boolean paused;
	private static boolean genpose;
	private static int posx,posy,coinnum;
	private static int count = 10;
	
	public static final int NUMGAMESTATES = 15;
	
	//Levels in the Game
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	public static final int LEVEL2A = 2;
	public static final int LEVEL2B = 3;
	public static final int LEVEL3A = 4;
	public static final int LEVEL3B = 5;
	public static final int LEVEL4A = 13;
	public static final int LEVEL4B = 14;
	public static final int TESTSTATE = 6;
	public static final int FINALSTATE = 7;
	public static final int FINALSTATEB = 8;
	public static final int DEATHSTATE = 9;
	public static final int STORYSTATE = 10;
	public static final int CREDITSTATE = 11;
	public static  final int NOTICESTATE=12;
	
	public static int getCoinnum() {
		return coinnum;
	}

	public static void setCoinnum(int coinnum) {
		GameStateManager.coinnum = coinnum;
	}
	public static boolean genpos=true;
	public static boolean isGenpos() {
		return genpos;
	}

	public static void setGenpos(boolean genpos) {
		GameStateManager.genpos = genpos;
	}

	public static int getPosx() {
		return posx;
	}

	public static void setPosx(int posx) {
		GameStateManager.posx = posx;
	}

	public static int getPosy() {
		return posy;
	}

	public static void setPosy(int posy) {
		GameStateManager.posy = posy;
	}


	
	public GameStateManager() {
		
		gameStates = new GameState[NUMGAMESTATES];
		
		
		pauseState = new PauseState(this);
		paused = false;
		
		currentState = MENUSTATE;
		loadState(currentState);
		
	}
	
	//A method that would make an object of the GameStateManager into the
	//state that needs to be loaded
	private void loadState(int state) {
		if(state == MENUSTATE)
			gameStates[state] = new MenuState(this);
		if(state == LEVEL1STATE)
			gameStates[state] = new Level1State(this);
		if(state == LEVEL2A)
			gameStates[state] = new Level2A(this);
		if(state == LEVEL2B)
			gameStates[state] = new Level2B(this);
		if(state == LEVEL3A)
			gameStates[state] = new Level3A(this);
		if(state == LEVEL3B)
			gameStates[state] = new Level3B(this);
		if(state == LEVEL4A)
			gameStates[state] = new Level4A(this);
		if(state == LEVEL4B)
			gameStates[state] = new Level4B(this);
		if(state == FINALSTATE)
			gameStates[state] = new LevelFinal(this);
		if(state == FINALSTATEB)
			gameStates[state] = new LevelFinalB(this);
		if(state == DEATHSTATE)
			gameStates[state] = new DeathState(this);
		if(state == STORYSTATE)
			gameStates[state] = new StoryState(this);
		if(state == CREDITSTATE)
			gameStates[state] = new CreditState(this);
		if(state == NOTICESTATE)
			gameStates[state] = new NoticeState(this);
	}
	
	private void unloadState(int state) {
		gameStates[state] = null;
	}
	
	public void setState(int state) {
		
		//current state needs to stop loading before switching to next one
		
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
		
	}
	
	public void setPaused(boolean b) { paused = b; }
	
	public void update() {
		
		//when paused, the levels update method isnt called so the game stops
		//and only shows the paused state
		
		if(paused) {
			pauseState.update();
			return;
		}
		if(gameStates[currentState] != null) gameStates[currentState].update();
	}
	
	public void draw(java.awt.Graphics2D g) {
		
		//when paused, the levels draw method isnt called so the game stops
		//and only shows the paused state
		
		if(paused) {
			pauseState.draw(g);
			return;
		}
		if(gameStates[currentState] != null) gameStates[currentState].draw(g);
		else {
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		}
	}
	
	public void keyPressed(int k) {
	
		gameStates[currentState].keyPressed(k);
	}
	
	public void keyReleased(int k) {
		gameStates[currentState].keyReleased(k);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
	GameStateManager.count=count;
		
	}

	public boolean isPaused() {
		return paused;
	}

	
}









