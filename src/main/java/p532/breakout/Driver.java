package p532.breakout;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 * @author sujeet 
 * This class acts as Driver class and trigger appropriate command with button clicked
 * 
 */

public class Driver {

	public void startGame() {

		ArrayList<GamePanel> undoStack = new ArrayList<GamePanel>();
		JFrame gameFrame = new JFrame("Demo ");

		GamePanel gamePanel = new GamePanel(new ClockPanel());
		gamePanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		TimerPerSecObservable timerObservable = new TimerPerSecObservable(gamePanel);

		Game game = new Game(undoStack, gameFrame, timerObservable);
		game.register(gamePanel);
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

		GamePanel resetPosition = new GameState(gamePanel).getCurentState();
		StartCommand gameScreen = new StartCommand(game);
		gameScreen.performAMove();
		while (!GameStatus.isGameOver()) {

			if (GameStatus.isGameStarted() && !GameStatus.isGameStopped()) {
				StartCommand newStartCommand = new StartCommand(game);
				newStartCommand.performAMove();

			} else if (GameStatus.isGameReset() && GameStatus.isGameStopped()) {

				ResetCommand newResetCommand = new ResetCommand(game, gamePanel, resetPosition);
				newResetCommand.performAMove();

			} else if (GameStatus.isGameStopped() && GameStatus.isGameUndo()) {

				UndoCommand newUndoComment = new UndoCommand(game, gamePanel);
				newUndoComment.performAMove();
			}

		}
	}
}
