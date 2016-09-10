package p532.breakout;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	public void changeLayoutGame(Game game, GamePanel gamePanel) {

		Container pane;
		
		if(!GameStatus.isBorderLayout())
		{
//			FlowLayout layout=new FlowLayout();
//			JPanel linearPanel = new JPanel();
//			linearPanel.setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
//			linearPanel.setLayout(layout);
//			linearPanel.add(Driver.startButton);
//			linearPanel.add(Driver.resetButton);
//			linearPanel.add(Driver.pauseButton);
//			linearPanel.add(Driver.replayButton);
//			linearPanel.add(Driver.undoButton);
//			linearPanel.add(Driver.saveButton);
//			linearPanel.add(Driver.loadButton);
//			linearPanel.add(Driver.changeLayoutButton);
//			gameFrame.add(linearPanel);
//			gameFrame.add(gamePanel);
//			linearPanel.revalidate();
//			linearPanel.repaint();
			
			FlowLayout layout=new FlowLayout();
			pane = gameFrame.getContentPane();
	 		pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			pane.setLayout(new GridBagLayout());
		    JButton button;
			pane.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			JPanel top1 = new JPanel();
			top1.setLayout(layout);
			top1.add(Driver.startButton);
			top1.add(Driver.resetButton);
			top1.add(Driver.pauseButton);
			
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			pane.add(top1, c);

			JPanel top2 = new JPanel();
			top2.setLayout(layout);
			top2.add(Driver.replayButton);
			top2.add(Driver.undoButton);
			top2.add(Driver.saveButton);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 1;
			c.gridy = 0;
			pane.add(top2, c);

			JPanel top3 = new JPanel();
			top3.setLayout(layout);
			
			top3.add(Driver.loadButton);
			top3.add(Driver.changeLayoutButton);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 2;
			c.gridy = 0;
			pane.add(top3, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady = 40;      //make this component tall
			c.weightx = 0.0;
			c.gridwidth = 3;
			c.gridx = 0;
			c.gridy = 1;
			pane.add(gamePanel, c);   
			   
			
		//	 //Use the content pane's default BorderLayout. No need for
	        //setLayout(new BorderLayout());
	        //Display the window.
	      //  GameStatus.setFlowLayout(true);
	      //  linearPanel.revalidate();
	      //  linearPanel.repaint();
	       // TopBottomPanel.revalidate();
	       // TopBottomPanel.repaint();

	        gameFrame.pack();
	        gameFrame.setVisible(true);
	        gamePanel.setFocusable(true);
		}
		else
		{
			//BORDER LAYOUT
			BorderLayout layout = new BorderLayout();
			gameFrame.setLayout(layout);
			pane = gameFrame.getContentPane();
			if (!(pane.getLayout() instanceof BorderLayout)) {
		            pane.add(new JLabel("Container doesn't use BorderLayout!"));
		            return;
		        }
		        
				pane.setComponentOrientation(
		                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		        
				JPanel leftPanel =new JPanel(new GridLayout(0,1));
				JPanel rightPanel =new JPanel(new GridLayout(0,1));
				leftPanel.add(Driver.startButton);
				leftPanel.add(Driver.pauseButton);
				leftPanel.add(Driver.resetButton);
				rightPanel.add(Driver.loadButton);
				rightPanel.add(Driver.saveButton);
				rightPanel.add(Driver.undoButton);
				rightPanel.add(Driver.replayButton);
				
				pane.add(leftPanel, BorderLayout.WEST);
				pane.add(rightPanel, BorderLayout.EAST);
				pane.add(gamePanel, BorderLayout.CENTER);
				pane.add(Driver.changeLayoutButton, BorderLayout.NORTH);
		        
		        //Use the content pane's default BorderLayout. No need for
		        //setLayout(new BorderLayout());
		        //Display the window.
		        gameFrame.pack();
		        gameFrame.setVisible(true);
		        gamePanel.setFocusable(true);
		      //  GameStatus.setFlowLayout(true);
		        leftPanel.revalidate();
		        leftPanel.repaint();
		        rightPanel.revalidate();
		        rightPanel.repaint();
		        pane.revalidate();
		        pane.repaint();
		        gameFrame.revalidate();
		        gameFrame.repaint();
		        gamePanel.validate();
		        gamePanel.repaint();
		}
		GameStatus.setLayoutChanged(false);
	}
}
