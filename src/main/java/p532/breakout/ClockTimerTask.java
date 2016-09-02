package p532.breakout;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import p532.breakout.GamePanel.GameLoopTask;

public class ClockTimerTask extends TimerTask {

	public ClockPanel clockPanel;
	private final CountDownLatch latch;
	public ClockTimerTask(ClockPanel clockPanel,CountDownLatch latch) {
		super();
		this.clockPanel = clockPanel;
		this.latch=latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if(GameStatus.getStatusFlag()){
		clockPanel.displayTime(20);
		}else{
			
		}
		latch.countDown();
	}

}
