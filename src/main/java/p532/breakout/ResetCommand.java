package p532.breakout;

public class ResetCommand implements Action{

	private Game game;
	private GamePanel gamePanel;
	private GamePanel resetPosition;
	public ResetCommand(Game game, GamePanel gamePanel, GamePanel resetPosition) {
		super();
		this.game = game;
		this.gamePanel = gamePanel;
		this.resetPosition = resetPosition;
	}
	public void performAMove() {
		// TODO Auto-generated method stub
		game.resetGame(this.gamePanel, resetPosition);
	}

}
