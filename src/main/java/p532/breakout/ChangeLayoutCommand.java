package p532.breakout;


public class ChangeLayoutCommand implements Action {

	private Game game;
	private GamePanel gamePanel;
	
	public ChangeLayoutCommand(Game game, GamePanel gamePanel) {
		super();
		this.game = game;
		this.gamePanel = gamePanel;
	}
	public void performAMove() {
		// TODO Auto-generated method stub
		
		game.changeLayoutGame(game,gamePanel);
	}

}
