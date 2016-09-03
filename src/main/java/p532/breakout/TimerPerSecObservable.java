package p532.breakout;

import java.util.ArrayList;

import java.util.Timer;
import java.util.concurrent.CountDownLatch;
<<<<<<< HEAD
=======

//public class TimerPerSecObservable implements Runnable{
>>>>>>> refs/remotes/origin/master

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

<<<<<<< HEAD
	public void updateObserver() {
		CountDownLatch latch = new CountDownLatch(2);
		
=======
	public void updateObserver(ArrayList<GamePanel> undoStack) {

		CountDownLatch latch = new CountDownLatch(2);
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
				GameLogic gamelogic=new GameLogic(gamePanel,latch);
				timer.schedule(gamelogic, 10);
				//timer.scheduleAtFixedRate(new GameLogic(gamePanel), 1000, 17);
			}
			if (obj instanceof ClockPanel) {
				ClockTimerTask clocktimertask=new ClockTimerTask(gamePanel.clockPanel,latch);
				timer.schedule(clocktimertask,10);
				//timer.scheduleAtFixedRate(new ClockTimerTask(gamePanel.clockPanel), 1000, 17);
			}
		}
=======
				if (!GameStatus.isGameOver() && !GameStatus.isGameStopped()) {

					GameState currentState = new GameState(gamePanel);
					undoStack.add(currentState.getCurentState());
				}
				timer.schedule(new GameLogic(gamePanel, latch, undoStack), 17);
			}
			if (obj instanceof ClockPanel) {

				timer.schedule(new ClockTimerTask(gamePanel.clockPanel, latch), 17);
			}
		}

>>>>>>> refs/remotes/origin/master
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
	}

	public void run() {
		// TODO Auto-generated method stub
		//updateObserver();
=======
>>>>>>> refs/remotes/origin/master
	}

}
