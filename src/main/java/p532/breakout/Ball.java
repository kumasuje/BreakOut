package p532.breakout;
import javax.swing.ImageIcon;

// The Ball class extends Sprite, represents the ball object.
public class Ball extends Sprite implements Commons {
    
    public Ball() {
        super();
        // Set initial moving direction towards south-east/bottom-right.
        dx = 2;
        dy = 2;
        /* Set image using setImage() method (because it also sets width and
         * height)
         */
        setImage(new ImageIcon(
                this.getClass().getResource(Commons.PIC_BALL)).getImage());
        // Put the ball in the initial position.
        reset();
    }
    
    /* Method to update ball's movement. Bounces the ball back when it hits
     * the screen borders.
     */
    public void move() {
        // Update movement.
        x += dx;
        y += dy;
        // Bounce ball back when it hits borders.
        if (x <= 0) { 
            x = 0;
            dx = -dx; // Reverse the horizontal direction.
        } else if (x >= Commons.WIDTH-width) {
            x = Commons.WIDTH-width;
            dx = -dx; // Reverse the horizontal direction.
        }
        if (y <= 94) {
            y = 94;
            dy = -dy; // Reverse the vertical direction.
        }
    }
    
    private void reset() {
        x = Commons.WIDTH / 3;
        y = Commons.HEIGHT / 2;
    }
    
    public void copy(Ball ball){
    	
    	this.dx = ball.dx;
    	this.dy = ball.dy;
    	this.height = ball.height;
    	this.image = ball.image;
    	this.width = ball.width;
    	this.x		= ball.x;
    	this.y		= ball.y;
    	
    }
}