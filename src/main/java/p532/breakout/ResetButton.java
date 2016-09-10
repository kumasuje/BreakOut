package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class ResetButton extends JPanel implements Buttons{
	
	JButton resetButton;
	public ResetButton(){
		
		
		this.resetButton = new JButton("RESET");
		
		this.resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameStatus.setGameStopped(true);
				GameStatus.setGameReset(true);
			}
		});
		add(this.resetButton);
		
		// Set background color
		this.resetButton.setOpaque(true);
		this.resetButton.setForeground(Color.BLACK);
		this.resetButton.setBackground(Color.WHITE);
		//this.setBackground(new Color(200, 200, 200));
		this.resetButton.setVisible(true);
		setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return resetButton;
	}
	
	public void setButton(JButton button){
		resetButton = button;
	}
	
	

}
