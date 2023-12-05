import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

import java.awt.event.ActionEvent;



public class Hero extends AnimatedThing{

    private Timeline timeline;
    private int maxJumpStrenth = 20;
    private int jumpStrenth = maxJumpStrenth;

    public Hero(double x, double y, int index) {
        super(x, y, 0, "/assets/img/heros.png", 2, 100, 5, 85, 100, 22);
        this.timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> update(e)));
        this.timeline.setCycleCount(maxJumpStrenth*2 + 1);

    }

    private void update(javafx.event.ActionEvent e) {

        this.setY(this.getY() - jumpStrenth);

        jumpStrenth--;
        if(jumpStrenth == -maxJumpStrenth-1){
            jumpStrenth = maxJumpStrenth;
        }

    }

    public Rectangle2D createViewport(int index)
    {
        // Calculate the coordinates for the current frame based on index and offset
        double startX = index * windowSizeX;
        double startY = attitude * (windowSizeY + 3 * offsetBetweenFrames);

        return new Rectangle2D(startX, startY, windowSizeX, windowSizeY);
    }
    public void jump(){
        this.timeline.play();
    }


}
