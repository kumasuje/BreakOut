package p532.breakout;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

class GameLogic extends TimerTask {
    /* This is where the game loop logic goes. Here, the objects are
     * updated and then drawn to the panel.
     * Code for updating game objects should be separate from the code for
     * rendering them. That's why, the code for updating the ball and the
     * paddle and collision handling is not included in the paint() method.
     */
	private GamePanel gamePanel;
<<<<<<< HEAD
	private final CountDownLatch latch;
	public GameLogic(GamePanel gamePanel,CountDownLatch latch) {
		this.gamePanel = gamePanel;
		this.latch=latch;
=======
	private  ArrayList<GamePanel>  undoStack;
	private final CountDownLatch latch;
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
>>>>>>> refs/remotes/origin/master
	}

	public GameLogic(GamePanel gamePanel,CountDownLatch latch, ArrayList<GamePanel>  undoStack) {
		
		//
		this.gamePanel = gamePanel;
		this.latch = latch;
		this.undoStack=undoStack;

	}
	
	//public GameLogic(){}
	
    @Override
    public void run() {
    	
//    	if(GameStatus.getStatusFlag()){
//    		
////    		GameStatus.getUndoStack().add(gamePanel);
////    		ArrayList<GamePanel> some = GameStatus.getUndoStack();
////    		System.out.println("adding");
////    		System.out.println(gamePanel.ball.getX()+" "+gamePanel.ball.getY()+" "+gamePanel.ball.getWidth()+" "+gamePanel.ball.getHeight());
//
//    	//	undoStack.add(gamePanel);
//    		
//    	}else{
//    		
//    		System.out.println();
//    	}
    	
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
<<<<<<< HEAD
        gamePanel.handleCollisions();
        gamePanel.repaint();
=======
//        if(GameStatus.getStatusFlag()){

            gamePanel.handleCollisions();
            gamePanel.repaint();
//        }else{
//        	
//        	GameStatus.something();
//        }
>>>>>>> refs/remotes/origin/master
        latch.countDown();
    }
 }