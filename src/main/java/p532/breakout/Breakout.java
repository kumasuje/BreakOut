package p532.breakout;

<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
=======

import javax.swing.JFrame;
>>>>>>> refs/remotes/origin/master

/**
 * @author sujeet 
 * The main window, acts as the main entry point.
 * 
 */

<<<<<<< HEAD
public class Breakout extends JFrame implements Commons , ActionListener{
	JPanel panel;
	JButton start;
	static boolean start_state;
	boolean restart_state;
	JButton restart;
	GamePanel gamePanel ;
	JFrame gameFrame;
	TimerPerSecObservable timerObservable;
	public Breakout() {
		restart_state=false;
		gameFrame = new JFrame("DEMO");
		
		//To create the initial panel.
		createPanel(gameFrame);
		
		gamePanel = new GamePanel(new ClockPanel());
		gamePanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		
		timerObservable = new TimerPerSecObservable(gamePanel);
		timerObservable.registerObservers(gamePanel.clockPanel);
		timerObservable.registerObservers(gamePanel);
		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		gameFrame.setLayout(layout);
		gameFrame.add(gamePanel);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(Commons.WIDTH, Commons.HEIGHT + 100);
		gameFrame.setResizable(false);
		gameFrame.setIgnoreRepaint(true);
		gameFrame.setVisible(true);
		
		//Wait for the user to press Start button.
		while(!start_state){
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//remove the start button once the game has started.
		panel.remove(start);
		//start_state=false;
		
		//keep running the game until one looses or finishes the entire game.
		while(GameStatus.getStatusFlag()){
				if(!restart_state)
					timerObservable.start();
				else
					break;
		}
		
		//wait until user presses restart button to restart the game after the game is over.
		if(!GameStatus.getStatusFlag()){
			while(!restart_state){
				try {
				       Thread.sleep(3);
			    } catch(InterruptedException e) {
			    }
			}
		}
		GameStatus.setStatusFlag(true);
		restart_game();
	}
	
	//method to restart game.
	public void restart_game(){
		gameFrame.dispose();
		new Breakout();
	}
	
	public void createPanel(JFrame gameframe){
		panel= new JPanel();
		start=new JButton("START");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start_state=true;
				
			}
		});
		panel.add(start);
		restart=new JButton("RESTART");
		panel.add(restart);
		gameframe.add(panel);
		gameframe.repaint();
		
		//action listener for restart button.
		restart.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				restart_state=true;
				//delay the game by a few milliseconds so that the user is ready to play the new game.
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e){
	}
	
	public static void main(String[] args) {
		Breakout game=new Breakout();
=======
@SuppressWarnings("serial")
public class Breakout extends JFrame implements Commons {

	public static void main(String[] args) {
		
		Driver gameDriver = new Driver();
		gameDriver.playGame();
>>>>>>> refs/remotes/origin/master
	}
}
