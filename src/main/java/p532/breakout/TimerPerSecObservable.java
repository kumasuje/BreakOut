package p532.breakout;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;

import java.util.Timer;
import java.util.concurrent.CountDownLatch;

public class TimerPerSecObservable implements Runnable {

	public TimerPerSecObservable(GamePanel gamePanel) {
		super();
		this.timer = new Timer();
		this.gamePanel = gamePanel;
	}

	private Timer timer;
	private GamePanel gamePanel;
	private ArrayList<Object> observer = new ArrayList<Object>();

	public void registerObservers(Object obj) {

//		System.out.println(" Register");
		observer.add(obj);
	}

	// Use Index to unregister the Observers
	public void unregisterObservers(int index) {

		observer.remove(index);
	}

	public void start(ArrayList<GamePanel> undoStack, ArrayList<GamePanel> replayStack) {

		updateObserver(undoStack, replayStack);
	}

	public void undoMove(ArrayList<GamePanel> undoStack) {
		CountDownLatch latch = new CountDownLatch(1);
		timer.schedule(new GameLogic(gamePanel, latch, undoStack, null), 00);
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public void replayMove(ArrayList<GamePanel> replayStack) {
		CountDownLatch latch = new CountDownLatch(2);
		timer.schedule(new GameLogic(gamePanel, latch, null, replayStack), 17);
		timer.schedule(new ClockTimerTask(gamePanel.clockPanel, latch), 17);
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public void updateObserver(ArrayList<GamePanel> undoStack, ArrayList<GamePanel> replayStack) {

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
				if (!GameStatus.isGameOver() && !GameStatus.isGameStopped() && !GameStatus.isGamePaused()) {

					GameState currentState = new GameState(gamePanel);

					if (GameStatus.getRecordStateTimer() > 59) {

						GameStatus.setRecordStateTimer(0);
						undoStack.add(currentState.getCurentState());

					} else {
						GameStatus.setRecordStateTimer(GameStatus.getRecordStateTimer() + 1);
					}
					replayStack.add(currentState.getCurentState());
				}
				timer.schedule(new GameLogic(gamePanel, latch, undoStack, replayStack), 17);
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

	public void run() {
		// TODO Auto-generated method stub
		// updateObserver();
	}

}
