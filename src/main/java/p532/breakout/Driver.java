package p532.breakout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.PortableServer.ServantRetentionPolicyValue;


/**
 * @author sujeet 
 * This class acts as Driver class and trigger appropriate command with button clicked
 * 
 */

public class Driver {

	static JFrame gameFrame;
	static Container pane;
	public void startGame() {

		ArrayList<GamePanel> undoStack = new ArrayList<GamePanel>();
		ArrayList<GamePanel> replayStack = new ArrayList<GamePanel>();
		
		gameFrame = new JFrame("Demo");
		
		
		FlowLayout flowLayout;
		BorderLayout borderLayout;
		
		DrawLayout drawLayout = new DrawLayout();
		//ChangeLayoutCommand clc = new ChangeLayoutCommand(gameFrame, drawLayout);
		
		GamePanel gamePanel= new GamePanel(new ClockPanel());
		gamePanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		
		
		if(GameStatus.isFlowLayout())
		{
			borderLayout=null;
			flowLayout=new FlowLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(10);
			gameFrame.setLayout(flowLayout);
			JPanel mainPanel = new JPanel();
			gameFrame.add(mainPanel);
			gameFrame.add(gamePanel);
//			gameFrame.add(gamePanel.clockPanel);
			mainPanel.add(drawLayout.startButton);
			mainPanel.add(drawLayout.resetButton);		
			mainPanel.add(drawLayout.undoButton);
			mainPanel.add(drawLayout.replayButton);
			mainPanel.add(drawLayout.pauseButton);
			mainPanel.add(drawLayout.loadButton);
			mainPanel.add(drawLayout.saveButton);
			mainPanel.add(drawLayout.changeLayoutButton);
			mainPanel.setVisible(true);
		}
		else
		{
			flowLayout = null;
			borderLayout=new BorderLayout();
			borderLayout.setHgap(10);
			borderLayout.setVgap(10);
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
//			pane.add(gamePanel.clockPanel, BorderLayout.NORTH);
			pane.add(leftPanel, BorderLayout.WEST);
			pane.add(rightPanel, BorderLayout.EAST);
			pane.add(gamePanel, BorderLayout.CENTER);
			pane.add(drawLayout.changeLayoutButton, BorderLayout.SOUTH);
			
			
		}
		
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(Commons.WIDTH, Commons.HEIGHT);
		gameFrame.setResizable(false);
		gameFrame.setIgnoreRepaint(true);
		
		gameFrame.revalidate();
		gameFrame.pack();
		gameFrame.setVisible(true);
		
		
		
		TimerPerSecObservable timerObservable = new TimerPerSecObservable(gamePanel);
		
		Game game= new Game(undoStack, replayStack,gameFrame, timerObservable);
		game.register(gamePanel);
		
		
		
		GamePanel resetPosition = new GameState(gamePanel).getCurentState();
		StartCommand gameScreen = new StartCommand(game);
		gameScreen.performAMove();
		
		while ( true) {
		
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
			if (GameStatus.isGameReplay()){
								
				ReplayCommand newreplayComment = new ReplayCommand(game,gamePanel);
				newreplayComment.performAMove();
			}
			
			if (GameStatus.isLayoutChanged()){
				
				ChangeLayoutCommand newLayoutComment = new ChangeLayoutCommand(game, gameFrame, drawLayout);
				newLayoutComment.performAMove();
			
			}
		}
	}

}
