package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class LoadButton extends JPanel implements Buttons {
	
	JButton loadButton;
	public LoadButton(){
		this.loadButton = new JButton("LOAD");
		
		this.loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LOAD FUNCTIONALITY
			}
		});
		
		add(this.loadButton);
		
		// Set background color
				this.loadButton.setOpaque(true);
				this.loadButton.setForeground(Color.BLACK);
				this.loadButton.setBackground(Color.WHITE);
				//this.setBackground(new Color(200, 200, 200));
				this.loadButton.setVisible(true);
				setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return loadButton;
	}
	
	public void setButton(JButton button){
		loadButton = button;
	}
	
	

}
