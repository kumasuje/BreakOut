package p532.breakout;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PauseButton extends JPanel implements Buttons {
	
	JButton pauseButton;
	public PauseButton(){
		this.pauseButton = new JButton("PAUSE");
		
		this.pauseButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(GameStatus.isGamePaused() == false){
					GameStatus.setGamePaused(true);
					pauseButton.setText("RESUME");
				}
				
				else if(GameStatus.isGamePaused() == true){
					GameStatus.setGamePaused(false);
					pauseButton.setText("PAUSE");
				}
			}
		});
		
//		Container pane=Driver.gameFrame.getContentPane();
//		pane.add(this.pauseButton, BorderLayout.EAST);
		
		add(this.pauseButton);
		// Set background color
				this.pauseButton.setOpaque(true);
				this.pauseButton.setForeground(Color.BLACK);
				this.pauseButton.setBackground(Color.WHITE);
				//this.setBackground(new Color(200, 200, 200));
				this.pauseButton.setVisible(true);
				setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return pauseButton;
	}
	
	public void setButton(JButton button){
		pauseButton = button;
	}
	
	

}