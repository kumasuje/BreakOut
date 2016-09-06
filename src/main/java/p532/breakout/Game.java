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

	 	public Game(ArrayList<GamePanel> undoStack, ArrayList<GamePanel> replayStack, JFrame gameFrame, TimerPerSecObservable timerObservable) {

		super();
		this.undoStack = undoStack;
		this.replayStack = replayStack;
		this.gameFrame = gameFrame;
		this.timerObservable = timerObservable;
	}

		ArrayList<GamePanel>  undoStack;
		ArrayList<GamePanel>  replayStack;
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
			
			this.timerObservable.start(undoStack,replayStack);
		}

		public void resetGame(GamePanel gamePanel, GamePanel resetPosition){
			GameStatus.setGameReset(false);
			GameStatus.setGameStarted(true);
			GameStatus.setGameStopped(false);
			gamePanel.copy(resetPosition);
			this.timerObservable.start(undoStack,replayStack);
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
		
		public void replayGame(GamePanel gamePanel){
			GameStatus.setGameReplay(false);
			GameStatus.setGameStopped(false);
			for (int i = 0 ; i < replayStack.size(); i++) {
				GamePanel lastState = new GameState(replayStack.get(i)).getCurentState();
				gamePanel.copy(lastState);
				timerObservable.replayMove(replayStack);
			}
		}
}
