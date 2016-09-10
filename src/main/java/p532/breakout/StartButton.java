package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class StartButton extends JPanel implements Buttons {
	
	JButton startButton;
	public StartButton(){
		super();
		
		this.startButton = new JButton("START");
		
		this.startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameStatus.setGameStarted(true);
			}
		});
		
		add(this.startButton);
		
		// Set background color
		this.startButton.setOpaque(true);
		this.startButton.setForeground(Color.BLACK);
		this.startButton.setBackground(Color.WHITE);
		//this.setBackground(new Color(200, 200, 200));
		this.startButton.setVisible(true);
		setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return this.startButton;
	}
	
	public void setButton(JButton button){
		this.startButton = button;
	}
	
	

}
