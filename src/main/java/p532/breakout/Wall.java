package p532.breakout;
import javax.swing.ImageIcon;

public class Wall extends Sprite implements Commons {
	
	public Wall(int x, int y){
		super(x,y);
		setImage(new ImageIcon(
                this.getClass().getResource(Commons.PIC_WALL)).getImage());
		
	}
	
	public void copy(Wall wall){
		
		this.dx = wall.dx;
    	this.dy = wall.dy;
    	this.height = wall.height;
    	this.image = wall.image;
    	this.width = wall.width;
    	this.x		= wall.x;
    	this.y		= wall.y;
	}

}
