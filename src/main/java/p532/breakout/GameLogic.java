package p532.breakout;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFrame;

class GameLogic extends TimerTask {
    /* This is where the game loop logic goes. Here, the objects are
     * updated and then drawn to the panel.
     * Code for updating game objects should be separate from the code for
     * rendering them. That's why, the code for updating the ball and the
     * paddle and collision handling is not included in the paint() method.
     */
	private GamePanel gamePanel;
	private  ArrayList<GamePanel>  undoStack;
	private  ArrayList<GamePanel> replayStack;
	private final CountDownLatch latch;
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public GameLogic(GamePanel gamePanel,CountDownLatch latch, ArrayList<GamePanel>  undoStack, ArrayList<GamePanel> replayStack) {
		
		//
		this.gamePanel = gamePanel;
		this.latch = latch;
		this.undoStack=undoStack;
		this.replayStack = replayStack;
	}
	
	//public GameLogic(){}
	
    @Override
    public void run() {

    	if(GameStatus.isGamePaused()==false){
    		gamePanel.ball.move(); // Update ball's position.
    	gamePanel.paddle.move(); // Update the paddle's position.
    	}
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

//        if(GameStatus.getStatusFlag()){

            gamePanel.handleCollisions();
            if(GameStatus.isGamePaused() == false)
            gamePanel.repaint();
//        }else{
//        	
//        	GameStatus.something();
//        }
           

        latch.countDown();
    	
    	
    }
 }