package p532.breakout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author sujeet The main window, acts as the main entry point.
 * 
 */

public class Game {

	public Game(ArrayList<GamePanel> undoStack, ArrayList<GamePanel> replayStack, JFrame gameFrame,
			TimerPerSecObservable timerObservable) {

		super();
		this.undoStack = undoStack;
		this.replayStack = replayStack;
		this.gameFrame = gameFrame;
		this.timerObservable = timerObservable;
	}

	ArrayList<GamePanel> undoStack;
	ArrayList<GamePanel> replayStack;
	JFrame gameFrame;

	JButton startButton;
	JButton resetButton;
	JButton undoButton;
	JButton replyButton;
	TimerPerSecObservable timerObservable;

	public void register(GamePanel gamePanel) {

		this.timerObservable.registerObservers(gamePanel.clockPanel);
		this.timerObservable.registerObservers(gamePanel);
	}

	public void startGame() {

		this.timerObservable.start(undoStack, replayStack);
	}

	public void resetGame(GamePanel gamePanel, GamePanel resetPosition) {
		GameStatus.setGameReset(false);
		GameStatus.setGameStarted(true);
		GameStatus.setGameStopped(false);
		GameStatus.setGamePaused(false);
		gamePanel.copy(resetPosition);
		this.timerObservable.start(undoStack, replayStack);
	}

	public void undoGame(GamePanel gamePanel) {
		GameStatus.setGameUndo(false);
		GameStatus.setGameStopped(false);
		if (undoStack.size() > 0) {
			GamePanel lastState = new GameState(undoStack.remove(undoStack.size() - 1)).getCurentState();
			gamePanel.copy(lastState);
			this.timerObservable.undoMove(undoStack);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void replayGame(GamePanel gamePanel) {

		for (int i = 0; i < replayStack.size(); i++) {
			GamePanel lastState = new GameState(replayStack.get(i)).getCurentState();
			gamePanel.copy(lastState);
			//this.timerObservable.start(undoStack, replayStack);
			this.timerObservable.replayMove(replayStack);
		}
		GameStatus.setGameReplay(false);
	}
	
	public void changeLayoutGame(JFrame gameFrame, DrawLayout drawLayout) {
		FlowLayout flowLayout;
		BorderLayout borderLayout;
		GamePanel gamePanel= new GamePanel(new ClockPanel());
		gamePanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		
		
		if(GameStatus.isFlowLayout())
		{
			borderLayout=null;
			flowLayout=new FlowLayout();
//			gameFrame.setLayout(flowLayout);
////			gameFrame.add(gamePanel.clockPanel);
//			gameFrame.add(drawLayout.startButton);
//			gameFrame.add(drawLayout.resetButton);		
//			gameFrame.add(drawLayout.undoButton);
//			gameFrame.add(drawLayout.replayButton);
//			gameFrame.add(drawLayout.pauseButton);
//			gameFrame.add(drawLayout.loadButton);
//			gameFrame.add(drawLayout.saveButton);
//			gameFrame.add(drawLayout.changeLayoutButton);
//			gameFrame.add(gamePanel);


			gameFrame.setLayout(flowLayout);
			JPanel mainPanel = new JPanel();
			gameFrame.add(mainPanel);
//			gameFrame.add(gamePanel.clockPanel);
			mainPanel.add(drawLayout.startButton);
			mainPanel.add(drawLayout.resetButton);		
			mainPanel.add(drawLayout.undoButton);
			mainPanel.add(drawLayout.replayButton);
			mainPanel.add(drawLayout.pauseButton);
			mainPanel.add(drawLayout.loadButton);
			mainPanel.add(drawLayout.saveButton);
			mainPanel.add(drawLayout.changeLayoutButton);
			mainPanel.revalidate();
			mainPanel.setVisible(true);
		}
		else
		{
			flowLayout=null;
			borderLayout=new BorderLayout();
			gameFrame.setLayout(borderLayout);
			JPanel leftPanel =new JPanel(new GridLayout(0,1));
			JPanel rightPanel =new JPanel(new GridLayout(0,1));
			leftPanel.add(drawLayout.startButton);
			leftPanel.add(drawLayout.pauseButton);
			leftPanel.add(drawLayout.resetButton);
			rightPanel.add(drawLayout.loadButton);
			rightPanel.add(drawLayout.saveButton);
			rightPanel.add(drawLayout.undoButton);
			rightPanel.add(drawLayout.replayButton);
			
			Container pane= Driver.gameFrame.getContentPane();
			pane.add(gamePanel.clockPanel, BorderLayout.NORTH);
			pane.add(leftPanel, BorderLayout.WEST);
			pane.add(rightPanel, BorderLayout.EAST);
			pane.add(gamePanel, BorderLayout.CENTER);
			pane.add(drawLayout.changeLayoutButton, BorderLayout.SOUTH);
			
		}
		
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(Commons.WIDTH, Commons.HEIGHT);
		gameFrame.setResizable(false);
		gameFrame.setIgnoreRepaint(true);
		gameFrame.validate();
		gameFrame.repaint();
		gameFrame.setVisible(true);
	}
}
