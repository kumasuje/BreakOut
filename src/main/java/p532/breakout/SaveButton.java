package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class SaveButton extends JPanel implements Buttons {
	
	JButton saveButton;
	public SaveButton(){
		this.saveButton = new JButton("SAVE");
		
		this.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SAVE FUNCTIONALITY
			}
		});
		add(this.saveButton);
		// Set background color
				this.saveButton.setOpaque(true);
				this.saveButton.setForeground(Color.BLACK);
				this.saveButton.setBackground(Color.WHITE);
				//this.setBackground(new Color(200, 200, 200));
				this.saveButton.setVisible(true);
				setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return saveButton;
	}
	
	public void setButton(JButton button){
		saveButton = button;
	}
	
	

}
