package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TopOptionBar extends JPanel implements Commons{

	public JButton getStartButton() {
		return startButton;
	}
	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}
	public JButton getStopButton() {
		return resetButton;
	}
	public void setStopButton(JButton stopButton) {
		this.resetButton = stopButton;
	}
	public JButton getUndoButton() {
		return undoButton;
	}
	public void setUndoButton(JButton undoButton) {
		this.undoButton = undoButton;
	}
	public JButton getReplyButton() {
		return replayButton;
	}
	public void setReplyButton(JButton replyButton) {
		this.replayButton = replyButton;
	}
	public JButton getPauseButton() {
		return pauseButton;
	}
	public void setPauseButton(JButton pauseButton) {
		this.pauseButton = pauseButton;
	}
	JButton startButton;
	JButton resetButton;
	JButton undoButton;
	JButton replayButton;
	JButton pauseButton;
	
	public TopOptionBar(JButton startButton, JButton resetButton, JButton undoButton, JButton replayButton, JButton pausButton) {

	super();
		
		this.startButton = new JButton("START");
		this.resetButton = new JButton("RESET");
		this.undoButton = new JButton("UNDO");
		this.replayButton = new JButton("REPLAY");
		this.pauseButton = new JButton("PAUSE");
		
		this.startButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				GameStatus.setGameStarted(true);
			}
		});

		
		this.resetButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				GameStatus.setGameStopped(true);
				GameStatus.setGameReset(true);
			}
		});
		
		this.undoButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				GameStatus.setGameStopped(true);
				GameStatus.setGameUndo(true);
			}
		});
		
		this.pauseButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				GameStatus.setGameStopped(true);
			}
		});
		
		add(this.startButton);
		add(this.resetButton);
		add(this.undoButton);
		add(this.replayButton);
		add(this.pauseButton);

		// Set background color
		this.setOpaque(true);
		this.setBackground(Color.BLACK);
		//this.setBackground(new Color(200, 200, 200));
		this.setVisible(true);
		setPreferredSize(new Dimension(Commons.WIDTH, Commons.TOP_OPTION_BAR_HEIGHT));
	}
	
	
}
