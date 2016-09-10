package p532.breakout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;


/**
 * @author sujeet 
 * The main window, acts as the main entry point.
 * 
 */


@SuppressWarnings("serial")
public class Breakout extends JFrame implements Commons {

	public static void main(String[] args) {
		
		Driver gameDriver = new Driver();
		
		gameDriver.startGame();
	}
	
	

}
