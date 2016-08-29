package p532.breakout;
import javax.swing.ImageIcon;

public class Wall extends Sprite implements Commons {
	
	public Wall(int x, int y){
		super(x,y);
		setImage(new ImageIcon(
                this.getClass().getResource(Commons.PIC_WALL)).getImage());
		
	}
	

}
