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
		this.latch      = latch;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!GameStatus.isGameOver()){
			System.out.println(this.clockPanel.hrCounter+" "+this.clockPanel.minCounter+" "+this.clockPanel.secCounter);
		clockPanel.displayTime(20);
		}else{
			
		}
		latch.countDown();
	}

}
