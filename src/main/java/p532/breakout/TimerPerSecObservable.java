package p532.breakout;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;

import java.util.Timer;
import java.util.concurrent.CountDownLatch;

//public class TimerPerSecObservable implements Runnable{

public class TimerPerSecObservable {

	public TimerPerSecObservable(GamePanel gamePanel) {
		super();
		this.timer = new Timer();
		this.gamePanel = gamePanel;
	}

	private Timer timer;
	private GamePanel gamePanel;
	private ArrayList<Object> observer = new ArrayList<Object>();

	public void registerObservers(Object obj) {

		System.out.println(" Register");
		observer.add(obj);
	}

	// Use Index to unregister the Observers
	public void unregisterObservers(int index) {

		observer.remove(index);
	}

	public void start(ArrayList<GamePanel> undoStack) {

		updateObserver(undoStack);
	}

	public void undoMove(ArrayList<GamePanel> undoStack) {
		CountDownLatch latch = new CountDownLatch(1);
		timer.schedule(new GameLogic(gamePanel, latch, undoStack), 00);
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateObserver(ArrayList<GamePanel> undoStack) {

		CountDownLatch latch = new CountDownLatch(2);
		for (Object obj : observer) {

			if (obj instanceof GamePanel) {

				/*
				 * The timer object is used to schedule the game loop.
				 * scheduleAtFixedRate() is used to execute the GameLoopTask
				 * object (extended from TimerTask) which contains the game
				 * loop. The task runs at nearly 60 FPS. So 1000ms/60 = nearly
				 * 20 ms.
				 *
				 */
				if (!GameStatus.isGameOver() && !GameStatus.isGameStopped()) {
					System.out.println("Adding "+undoStack.size());
					if(GameStatus.getRecordStateTimer() > 59){
						
						GameStatus.setRecordStateTimer(0);
						GameState currentState = new GameState(gamePanel);
						undoStack.add(currentState.getCurentState());
						
					}else{
						GameStatus.setRecordStateTimer(GameStatus.getRecordStateTimer()+1);
					}
					
				}
				timer.schedule(new GameLogic(gamePanel, latch, undoStack), 17);
			}
			if (obj instanceof ClockPanel) {
				
				timer.schedule(new ClockTimerTask(gamePanel.clockPanel, latch), 17);
			}
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
