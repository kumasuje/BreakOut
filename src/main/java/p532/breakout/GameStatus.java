package p532.breakout;

public class GameStatus {

	private static boolean statusFlag = true;

	public synchronized static boolean getStatusFlag() {
		return statusFlag;
	}

	public synchronized static void setStatusFlag(boolean statusFlag) {
		GameStatus.statusFlag = statusFlag;
	}
	
}
