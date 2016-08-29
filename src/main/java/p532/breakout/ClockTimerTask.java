package p532.breakout;

import java.util.TimerTask;

import p532.breakout.GamePanel.GameLoopTask;

public class ClockTimerTask extends TimerTask {

	public ClockPanel clockPanel;
	
	public ClockTimerTask(ClockPanel clockPanel) {
		super();
		this.clockPanel = clockPanel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(GameStatus.getStatusFlag()){
		clockPanel.displayTime(20);
		}else{
			
		}
	}

}
