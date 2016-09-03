package p532.breakout;

public class StartCommand implements Action {

	private Game game;
	public StartCommand(Game game) {
		super();
		this.game = game;
	}
	public void performAMove() {
		// TODO Auto-generated method stub
		
		game.startGame();
	}

}
