package p532.breakout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/* This is the GamePanel class which extends JPanel. This is where the graphics
 * are drawn. It also has the game loop and timer functionality, which are responsible
 * for updating the game objects and drawing them to the panel.
 */
@SuppressWarnings("serial")
public class ClockPanel extends JPanel implements Commons {
	// Variable declaration

	JLabel label;
	public int milliSecCounter=0;
	public int secCounter=0;
	public int minCounter=0;
	public int hrCounter=0;
	public ClockPanel() {
		// Set background color
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(Commons.WIDTH, Commons.CLOCK_HEIGHT));
		addTimerLabel();
		
		setDoubleBuffered(true);
		// Set the focus to the GamePanel for keyboard events to work.
		setFocusable(true);
		// Start up the game

	}

	public void addTimerLabel() {
		
		label = new JLabel();
		label.setFont(new Font("Arial", Font.BOLD, 36));
		label.setText(" CLOCK    "+hrCounter+":"+minCounter+":"+secCounter);
		add(label);

	}

	public void displayTime(int msCounter) {
		milliSecCounter += msCounter;
		showTime();
	}
	
	public void showTime(){
		
		if(milliSecCounter >= 1000){
			secCounter++;
			milliSecCounter = 0;
		}
		if(secCounter >= 60){
			minCounter++;
			secCounter=0;
		}
		if(minCounter >=60){
			hrCounter++;
			minCounter=0;
		}
		label.setText(" Clock     "+hrCounter+":"+minCounter+":"+secCounter);
		
	}

	public void copy(ClockPanel clock){
		
		this.milliSecCounter = clock.milliSecCounter;
		this.hrCounter		 = clock.hrCounter;
		this.minCounter		 = clock.milliSecCounter;
		this.secCounter		 = clock.secCounter;
	}
	
}
