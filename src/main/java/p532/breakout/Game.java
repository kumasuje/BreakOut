package p532.breakout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author sujeet 
 * The main window, acts as the main entry point.
 * 
 */

public class Game {

	 	public Game(ArrayList<GamePanel> undoStack, JFrame gameFrame, TimerPerSecObservable timerObservable) {
		super();
		this.undoStack = undoStack;
		this.gameFrame = gameFrame;
		this.timerObservable = timerObservable;
	}

		ArrayList<GamePanel>  undoStack;
		JFrame gameFrame;
		
		JButton startButton;
		JButton resetButton;
		JButton undoButton;
		JButton replyButton;
		TimerPerSecObservable timerObservable;
		
		public void register(GamePanel gamePanel){
			
			this.timerObservable.registerObservers(gamePanel.clockPanel);
			this.timerObservable.registerObservers(gamePanel);
		}
		
		public void startGame(){
			
			this.timerObservable.start(undoStack);
		}

		public void resetGame(GamePanel gamePanel, GamePanel resetPosition){
			GameStatus.setGameReset(false);
			GameStatus.setGameStarted(true);
			GameStatus.setGameStopped(false);
			gamePanel.copy(resetPosition);
			this.timerObservable.start(undoStack);
		}
		
		public void undoGame(GamePanel gamePanel){
			GameStatus.setGameUndo(false);
			GameStatus.setGameStopped(false);
			if(undoStack.size()>0){
				GamePanel lastState = new GameState(undoStack.remove(undoStack.size()-1)).getCurentState();
				gamePanel.copy(lastState);
				timerObservable.undoMove(undoStack);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
