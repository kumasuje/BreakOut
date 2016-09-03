package p532.breakout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * @author sujeet 
 * The main window, acts as the main entry point.
 * 
 */

public class Driver {

	public void playGame() {

		ArrayList<GamePanel> undoStack = new ArrayList<GamePanel>();
		JFrame gameFrame = new JFrame("Demo ");

		JButton startButton = new JButton("START");
		JButton resetButton = new JButton("RESET");
		JButton undoButton = new JButton("UNDO");
		JButton replyButton = new JButton("REPLAY");

		GamePanel gamePanel = new GamePanel(new ClockPanel(), startButton, resetButton, undoButton, replyButton);
		gamePanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		TimerPerSecObservable timerObservable = new TimerPerSecObservable(gamePanel);

		Game game = new Game(undoStack, gameFrame, startButton, resetButton, undoButton, replyButton, timerObservable);
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

			System.out.println(" Game not Over");
			if (GameStatus.isGameStarted() && !GameStatus.isGameStopped()) {
				StartCommand newStartCommand = new StartCommand(game);
				newStartCommand.performAMove();

			} else if (GameStatus.isGameReset() && GameStatus.isGameStopped()) {

				ResetCommand newRestCommand = new ResetCommand(game, gamePanel, resetPosition);
				newRestCommand.performAMove();

			} else if (GameStatus.isGameStopped() && GameStatus.isGameUndo()) {

				UndoCommand newUndoComment = new UndoCommand(game, gamePanel);
				newUndoComment.performAMove();
			}

		}
	}
}
