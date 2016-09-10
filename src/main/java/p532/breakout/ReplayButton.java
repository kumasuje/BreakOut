package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ReplayButton extends JPanel implements Buttons {
	
	JButton replayButton;
	public ReplayButton(){
		this.replayButton = new JButton("REPLAY");
		
		this.replayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameStatus.setGameReplay(true);
			}
		});
		
		add(this.replayButton);
		// Set background color
				this.replayButton.setOpaque(true);
				this.replayButton.setForeground(Color.BLACK);
				this.replayButton.setBackground(Color.WHITE);
				//this.setBackground(new Color(200, 200, 200));
				this.replayButton.setVisible(true);
				setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return replayButton;
	}
	
	public void setButton(JButton button){
		replayButton = button;
	}
	
	

}
