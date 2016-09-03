package p532.breakout;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class ClockTimerTask extends TimerTask {

	public ClockPanel clockPanel;
	private final CountDownLatch latch;
	public ClockTimerTask(ClockPanel clockPanel,CountDownLatch latch) {
		super();
		this.clockPanel = clockPanel;
<<<<<<< HEAD
		this.latch=latch;
=======
		this.latch      = latch;
>>>>>>> refs/remotes/origin/master
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		
		if(GameStatus.getStatusFlag()){
=======
		if(!GameStatus.isGameOver()){
>>>>>>> refs/remotes/origin/master
		clockPanel.displayTime(20);
		}else{
			
		}
		latch.countDown();
	}

}
