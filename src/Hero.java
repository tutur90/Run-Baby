import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    public Hero(double x, double y, int index) {
        super(x, y, 0, "/assets/img/heros.png", 2, 100, 5, 85, 100, 22);
    }
    public Rectangle2D createViewport(int index)
    {
        // Calculate the coordinates for the current frame based on index and offset
        double startX = index * windowSizeX;
        double startY = attitude * (windowSizeY + 3 * offsetBetweenFrames);

        return new Rectangle2D(startX, startY, windowSizeX, windowSizeY);
    }
}
