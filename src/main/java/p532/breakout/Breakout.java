package p532.breakout;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
/**
 * @author sujeet & Karun
 * The main window, acts as the main entry point.
 * 
 */
public class Breakout extends JFrame implements Commons {

	public Breakout() {

		JFrame gameFrame = new JFrame("Demo ");
		GamePanel gamePanel = new GamePanel(new ClockPanel());
		gamePanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));

		GameLogic gameLogic = new GameLogic(gamePanel);

		TimerPerSecObservable timerObservable = new TimerPerSecObservable(gamePanel);

		timerObservable.registerObservers(gamePanel.clockPanel);
		timerObservable.registerObservers(gamePanel);
		timerObservable.start();

		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		gameFrame.setLayout(layout);

		gameFrame.add(gamePanel);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(Commons.WIDTH, Commons.HEIGHT + 80);
		gameFrame.setResizable(false);
		gameFrame.setIgnoreRepaint(true);
		gameFrame.setVisible(true);

	}

	public static void main(String[] args) {

		Breakout game = new Breakout();
	}
}
