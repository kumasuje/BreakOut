package p532.breakout;

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

		System.out.println(" Register");
		observer.add(obj);
	}

	// Use Index to unregister the Observers
	public void unregisterObservers(int index) {

		observer.remove(index);
	}

	public void start() {

		updateObserver();
	}

	public void updateObserver() {
		CountDownLatch latch = new CountDownLatch(2);
		
		for (Object obj : observer) {
			if (obj instanceof GamePanel) {
				/*
				 * The timer object is used to schedule the game loop.
				 * scheduleAtFixedRate() is used to execute the GameLoopTask
				 * object (extended from TimerTask) which contains the game
				 * loop. The task runs at nearly 60 FPS. So 1000ms/60 = nearly
				 * 20 ms.
				 */
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
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		//updateObserver();
	}

}
