package p532.breakout;

public class ReplayCommand implements Action {

	private Game game;
	private GamePanel gamePanel;
	public ReplayCommand(Game game, GamePanel gamePanel) {
		// TODO Auto-generated constructor stub
		super();
		this.game = game;
		this.gamePanel = gamePanel;
	}
	public void performAMove() {
		// TODO Auto-generated method stub
		this.game.replayGame(gamePanel);
	}

}
