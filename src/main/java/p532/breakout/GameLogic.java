package p532.breakout;

import java.util.TimerTask;

class GameLogic extends TimerTask {
    /* This is where the game loop logic goes. Here, the objects are
     * updated and then drawn to the panel.
     * Code for updating game objects should be separate from the code for
     * rendering them. That's why, the code for updating the ball and the
     * paddle and collision handling is not included in the paint() method.
     */
	private GamePanel gamePanel;
	
	public GameLogic(GamePanel gamePanel) {
		this.gamePanel = gamePanel;

	}

    @Override
    public void run() {
    	gamePanel.ball.move(); // Update ball's position.
    	gamePanel.paddle.move(); // Update the paddle's position.
        
        // If ball goes below screen, lose game.
        if (gamePanel.ball.getY() > Commons.HEIGHT) {
        	gamePanel.message = "Game Over";
        	gamePanel.stopGame();
        }
        // Else if all bricks are destroyed, win game.
        else if (gamePanel.bricksRemaining == 0) {
        	gamePanel.message = "Congratulations! You won!";
        	gamePanel.stopGame();
        }
        // Detect and handle collisions between different objects.
        gamePanel.handleCollisions();
        gamePanel.repaint();
    }
 }