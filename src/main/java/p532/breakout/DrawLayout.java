package p532.breakout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLayout extends JPanel{
	
	StartButton startButton;
	ResetButton resetButton;
	UndoButton undoButton;
	PauseButton pauseButton;
	ReplayButton replayButton;
	LoadButton loadButton;
	SaveButton saveButton;
	ChangeLayoutButton changeLayoutButton;
	ClockPanel clockPanel;
	GamePanel gamePanel;
	
	public DrawLayout(){
		this.clockPanel = clockPanel;
		this.gamePanel = gamePanel;
		this.startButton = new StartButton();
		this.resetButton = new ResetButton();
		this.undoButton = new UndoButton();
		this.pauseButton= new PauseButton();
		this.replayButton = new ReplayButton();
		this.loadButton = new LoadButton();
		this.saveButton = new SaveButton();
		this.changeLayoutButton = new ChangeLayoutButton();
	
	}
	
	public void drawFlowLayout(JFrame gameFrame){
		FlowLayout layout=new FlowLayout();
		gameFrame.setLayout(layout);
		add(this.clockPanel);
		add(this.startButton);
		add(this.resetButton);		
		add(this.undoButton);
		add(this.replayButton);
		add(this.pauseButton);
		add(this.loadButton);
		add(this.saveButton);
		add(this.changeLayoutButton);
		this.revalidate();
		this.repaint();
		// Set background color
		setBackground(new Color(200, 200, 200));

		// Enable double buffering of this panel to avoid flickering.
		setDoubleBuffered(true);
		// Set the focus to the GamePanel for keyboard events to work.
		setFocusable(true);
	}
	
	public void drawBorderLayout(){
		JPanel leftPanel =new JPanel(new GridLayout(0,1));
		JPanel rightPanel =new JPanel(new GridLayout(0,1));
		leftPanel.add(startButton);
		leftPanel.add(pauseButton);
		leftPanel.add(resetButton);
		rightPanel.add(loadButton);
		rightPanel.add(saveButton);
		rightPanel.add(undoButton);
		rightPanel.add(replayButton);
		
		Container pane= Driver.gameFrame.getContentPane();
		pane.add(this.clockPanel, BorderLayout.NORTH);
		pane.add(leftPanel, BorderLayout.WEST);
		pane.add(rightPanel, BorderLayout.EAST);
		pane.add(this, BorderLayout.CENTER);
		pane.add(this.changeLayoutButton, BorderLayout.SOUTH);
		this.revalidate();
		this.repaint();
	}
}
