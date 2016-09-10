package p532.breakout;

import javax.swing.JFrame;

public class ChangeLayoutCommand implements Action {

	private Game game;
	private JFrame gameFrame;
	private DrawLayout drawLayout;
	
	
	public ChangeLayoutCommand(Game game, JFrame gameFrame, DrawLayout drawLayout) {
		super();
		this.game = game;
		this.gameFrame = gameFrame;
		this.drawLayout = drawLayout;
	}
	public void performAMove() {
		// TODO Auto-generated method stub
		
		game.changeLayoutGame(gameFrame, drawLayout);
	}

}
