package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class ChangeLayoutButton extends JPanel implements Buttons {
	
	private JButton changeLayoutButton;
	
	public ChangeLayoutButton(){
		
		this.changeLayoutButton = new JButton("LAYOUT");

		this.changeLayoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameStatus.setLayoutChanged(true);
				if(GameStatus.isFlowLayout())
				{
					GameStatus.setBorderLayout(true);
				}
				else{
					GameStatus.setFlowLayout(true);
				}
			}
		});
		add(this.changeLayoutButton);
		// Set background color
				this.changeLayoutButton.setOpaque(true);
				this.changeLayoutButton.setForeground(Color.BLACK);
				this.changeLayoutButton.setBackground(Color.WHITE);
				//this.setBackground(new Color(200, 200, 200));
				this.changeLayoutButton.setVisible(true);
				setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return changeLayoutButton;
	}
	
	public void setButton(JButton button){
		changeLayoutButton = button;
	}
	
	

}
