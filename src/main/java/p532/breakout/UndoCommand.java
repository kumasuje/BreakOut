package p532.breakout;

public class UndoCommand implements Action{

	private Game game;
	private GamePanel gamePanel;
	public UndoCommand(Game game,GamePanel gamePanel) {
		super();
		this.game = game;
		this.gamePanel = gamePanel;
	}
	public void performAMove() {
		// TODO Auto-generated method stub
		this.game.undoGame(this.gamePanel);
	}
}
