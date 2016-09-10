package p532.breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class UndoButton extends JPanel implements Buttons{
	
	JButton undoButton;
	public UndoButton(){
		this.undoButton = new JButton("UNDO");
		
		this.undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameStatus.setGameStopped(true);
				GameStatus.setGameUndo(true);
			}
		});
		
		add(this.undoButton);
		// Set background color
				this.undoButton.setOpaque(true);
				this.undoButton.setForeground(Color.BLACK);
				this.undoButton.setBackground(Color.WHITE);
				//this.setBackground(new Color(200, 200, 200));
				this.undoButton.setVisible(true);
				setPreferredSize(new Dimension(Commons.WIDTH/9, Commons.TOP_OPTION_BAR_HEIGHT));
		
	}
	
	public  JButton getButton(){
		return undoButton;
	}
	
	public void setButton(JButton button){
		undoButton = button;
	}
	
	

}
