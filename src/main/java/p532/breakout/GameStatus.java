package p532.breakout;

import java.util.ArrayList;

public class GameStatus {

	public synchronized static boolean isGameOver() {
		return gameOver;
	}

	public synchronized static void setGameOver(boolean gameOver) {
		GameStatus.gameOver = gameOver;
	}

	public synchronized static boolean isGameStopped() {
		return gameStopped;
	}

	public synchronized  static void setGameStopped(boolean gameStopped) {
		GameStatus.gameStopped = gameStopped;
	}

	public synchronized static boolean isGameStarted() {
		return gameStarted;
	}

	public synchronized static void setGameStarted(boolean gameStarted) {
		GameStatus.gameStarted = gameStarted;
	}

	private static boolean gameOver = false;
	private static boolean gameStopped = false;
	private static boolean gameStarted = false;
	private static boolean gameReset = false;
	private static boolean gameUndo = false;
	private static boolean gameReplay = false;
	
	private static int recordStateTimer = 0;
	
	
	public static synchronized int getRecordStateTimer() {
		return recordStateTimer;
	}

	public static synchronized void setRecordStateTimer(int recordStateTimer) {
		GameStatus.recordStateTimer = recordStateTimer;
	}

	public static synchronized boolean isGameUndo() {
		return gameUndo;
	}
	
	public static synchronized boolean isGameReplay() {
		return gameReplay;
	}

	public static synchronized void setGameUndo(boolean gameUndo) {
		GameStatus.gameUndo = gameUndo;
	}
	
	public static synchronized void setGameReplay(boolean gameReplay) {
		GameStatus.gameReplay = gameReplay;
	}

	public synchronized static boolean isGameReset() {
		return gameReset;
	}

	public synchronized static void setGameReset(boolean gameReset) {
		GameStatus.gameReset = gameReset;
	}

	private  ArrayList<GamePanel>  undoStack = new ArrayList<GamePanel>();
	private  ArrayList<GamePanel>  replayStack = new ArrayList<GamePanel>();

	public  synchronized  ArrayList<GamePanel> getUndoStack() {
		return undoStack;
	}
	
	public  synchronized  ArrayList<GamePanel> getReplayStack() {
		return replayStack;
	}

	public  synchronized void setUndoStack(ArrayList<GamePanel> undoStack) {
		this.undoStack = undoStack;
	}
	
	public synchronized void setReplayStack(ArrayList<GamePanel> replayStack){
		this.replayStack = replayStack;
	}
}
