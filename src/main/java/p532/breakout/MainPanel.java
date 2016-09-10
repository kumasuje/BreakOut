//package p532.breakout;
//
//import java.awt.BorderLayout;
//import java.awt.Container;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class MainPanel extends JPanel implements Commons {
//	
//	static JFrame gameFrame;
//	StartButton startButton;
//	ResetButton resetButton;
//	UndoButton undoButton;
//	PauseButton pauseButton;
//	ReplayButton replayButton;
//	LoadButton loadButton;
//	SaveButton saveButton;
//	ChangeLayoutButton changeLayoutButton;
//	GamePanel gamePanel;
//	ClockPanel clockPanel;
//	
//	public MainPanel(ClockPanel clockPanel, GamePanel gamePanel){
//		gameFrame =new JFrame("Main");
//		this.clockPanel = clockPanel;
//		this.gamePanel = gamePanel;
//		this.startButton = new StartButton();
//		this.resetButton = new ResetButton();
//		this.undoButton = new UndoButton();
//		this.pauseButton= new PauseButton();
//		this.replayButton = new ReplayButton();
//		this.loadButton = new LoadButton();
//		this.saveButton = new SaveButton();
//		this.changeLayoutButton = new ChangeLayoutButton();
//		
//		
//		BorderLayout layout = new BorderLayout();
//		layout.setHgap(10);
//		layout.setVgap(10);
//		gameFrame.setLayout(layout);
//		Container pane = gameFrame.getContentPane();
//		pane.add(this.clockPanel, BorderLayout.PAGE_START);
//		pane.add(this.gamePanel, BorderLayout.CENTER);
//		pane.add(this.startButton, BorderLayout.LINE_START);
//		pane.add(this.resetButton, BorderLayout.LINE_START);		
//		pane.add(this.undoButton, BorderLayout.LINE_START);
//		pane.add(this.replayButton, BorderLayout.LINE_END);
//		pane.add(this.pauseButton, BorderLayout.LINE_END);
//		pane.add(this.loadButton, BorderLayout.LINE_END);
//		pane.add(this.saveButton, BorderLayout.LINE_END);
//		pane.add(this.changeLayoutButton, BorderLayout.PAGE_END);
//		
//		
//		
//	}
//
//}
