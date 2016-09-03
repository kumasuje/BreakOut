package p532.breakout;

public class GameState {

	private GamePanel curentState;

	public GamePanel getCurentState() {
		return curentState;
	}

	public void setCurentState(GamePanel curentState) {
		this.curentState = curentState;
	}

	public GameState(GamePanel curentState) {
		super();
		this.curentState = new GamePanel(new ClockPanel(), curentState.topBar.startButton,
				curentState.topBar.resetButton, curentState.topBar.undoButton, curentState.topBar.replayButton);
		
		this.curentState.ball.copy(curentState.ball);
		for (int i = 0; i < this.curentState.bricks.length; i++) {

			this.curentState.bricks[i].copy(curentState.bricks[i]);
		}
		this.curentState.bricksRemaining = curentState.bricksRemaining;
		this.curentState.clockPanel.copy(curentState.clockPanel);
		this.curentState.message = curentState.message;
		this.curentState.paddle.copy(curentState.paddle);
		//undoStack.add(newGamePanel);
	} 
	
}
