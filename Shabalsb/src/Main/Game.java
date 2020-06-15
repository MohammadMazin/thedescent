package Main;

import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args) {
		
		//Creating Jfram and setting the title of the window
		JFrame window = new JFrame("The Descent");
		window.setContentPane(new GamePanel());   //Creating the pane
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //so program closes when it is exited
		window.setResizable(false);     //prevents window from being resized
		window.pack();                  //sets proper size of the window
		window.setVisible(true);        //shows the window on the screen
		
	}
	
}
