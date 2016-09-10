package p532.breakout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author sujeet 
 * This class acts as Driver class and trigger appropriate command with button clicked
 * 
 */

public class Driver {

	static JFrame gameFrame;
	static Container pane;

	static StartButton startButton = new StartButton();
	static ResetButton resetButton = new ResetButton();
	static UndoButton undoButton = new UndoButton();
	static PauseButton pauseButton = new PauseButton();
	static ReplayButton replayButton = new ReplayButton();
	static LoadButton loadButton = new LoadButton();
	static SaveButton saveButton = new SaveButton();
	static ChangeLayoutButton changeLayoutButton = new ChangeLayoutButton();
	
	
	
	public void startGame() {

		ArrayList<GamePanel> undoStack = new ArrayList<GamePanel>();
		ArrayList<GamePanel> replayStack = new ArrayList<GamePanel>();
		
		gameFrame = new JFrame("Demo");
		GamePanel gamePanel= new GamePanel(new ClockPanel());
		gamePanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT+80));
		TimerPerSecObservable timerObservable = new TimerPerSecObservable(gamePanel);
		Game game= new Game(undoStack, replayStack,gameFrame, timerObservable);;
		game.register(gamePanel);
		
		if(GameStatus.isFlowLayout())
		{	
			FlowLayout layout=new FlowLayout();
			gameFrame.setLayout(layout);
			gameFrame.add(startButton);
			gameFrame.add(resetButton);
			gameFrame.add(pauseButton);
			gameFrame.add(replayButton);
			gameFrame.add(undoButton);
			gameFrame.add(saveButton);
			gameFrame.add(loadButton);
			gameFrame.add(changeLayoutButton);
			 gameFrame.pack();
		        gameFrame.setVisible(true);
		        gamePanel.setFocusable(true);
		      //  GameStatus.setFlowLayout(true);
		        gamePanel.validate();
		        gamePanel.repaint();
			
		}
		else
		{
			//BORDER LAYOUT
			
			BorderLayout layout = new BorderLayout();
			gameFrame.setLayout(layout);
			Container pane = gameFrame.getContentPane();
			if (!(pane.getLayout() instanceof BorderLayout)) {
		            pane.add(new JLabel("Container doesn't use BorderLayout!"));
		            return;
		        }
		        
				pane.setComponentOrientation(
		                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		        
				JPanel leftPanel =new JPanel(new GridLayout(0,1));
				JPanel rightPanel =new JPanel(new GridLayout(0,1));
				leftPanel.add(startButton);
				leftPanel.add(pauseButton);
				leftPanel.add(resetButton);
				rightPanel.add(loadButton);
				rightPanel.add(saveButton);
				rightPanel.add(undoButton);
				rightPanel.add(replayButton);
				
				pane.add(leftPanel, BorderLayout.WEST);
				pane.add(rightPanel, BorderLayout.EAST);
				pane.add(gamePanel, BorderLayout.CENTER);
				pane.add(changeLayoutButton, BorderLayout.SOUTH);
		        
		        //Use the content pane's default BorderLayout. No need for
		        //setLayout(new BorderLayout());
		        //Display the window.
		        gameFrame.pack();
		        gameFrame.setVisible(true);
		        gamePanel.setFocusable(true);
		      //  GameStatus.setFlowLayout(true);
		        gamePanel.validate();
		        gamePanel.repaint();
		}
		
		
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(Commons.WIDTH, Commons.HEIGHT);
		gameFrame.setResizable(false);
		gameFrame.setIgnoreRepaint(true);
		gameFrame.setVisible(true);
		gameFrame.add(gamePanel);
		
	//	GamePanel resetPosition = new GameState(gamePanel).getCurentState();
		StartCommand gameScreen = new StartCommand(game);
		gameScreen.performAMove();
		
		while ( true) {
		
			if (GameStatus.isGameStarted() && !GameStatus.isGameStopped()) {
				StartCommand newStartCommand = new StartCommand(game);
				newStartCommand.performAMove();

			} else if (GameStatus.isGameReset() && GameStatus.isGameStopped()) {
				GamePanel resetPosition = new GameState(gamePanel).getCurentState();
				ResetCommand newResetCommand = new ResetCommand(game, gamePanel, resetPosition);
				newResetCommand.performAMove();

			} else if (GameStatus.isGameStopped() && GameStatus.isGameUndo()) {

				UndoCommand newUndoComment = new UndoCommand(game, gamePanel);
				newUndoComment.performAMove();
				
			} 
			if (GameStatus.isGameReplay()){
								
				ReplayCommand newreplayComment = new ReplayCommand(game,gamePanel);
				newreplayComment.performAMove();
			}
			
			if (GameStatus.isLayoutChanged()){
				
				ChangeLayoutCommand newLayoutComment = new ChangeLayoutCommand(game, gamePanel);
				newLayoutComment.performAMove();
			
			}
		}
	}
}
