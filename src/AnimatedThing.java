import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private ImageView spriteSheet;
    protected int attitude;
    private int index;
    private int durationBetweenFrames;
    private int maxIndex;
    protected final int windowSizeX;
    protected final int windowSizeY;
    protected final int offsetBetweenFrames;
    public AnimatedThing(double x, double y, int attitude, String fileName, int index, int durationBetweenFrames,
                         int maxIndex, int windowSizeX, int windowSizeY, int offsetBetweenFrames) {
        this.attitude = attitude;
        this.index = index;
        this.durationBetweenFrames = durationBetweenFrames;
        this.maxIndex = maxIndex;
        this.windowSizeX = windowSizeX;
        this.windowSizeY = windowSizeY;
        this.offsetBetweenFrames = offsetBetweenFrames;
        Image image = new Image(fileName);
        this.spriteSheet = new ImageView(image);
        this.spriteSheet.setViewport(createViewport(index));
        this.spriteSheet.setX(x);
        this.spriteSheet.setY(y);

    }

    public abstract Rectangle2D createViewport(int index);
    public ImageView getSpriteSheet() {
        return spriteSheet;
    }
    public int getIndex() {
        return index;
    }
    public int getMaxIndex() {
        return maxIndex;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public void setX(double x) {
        this.spriteSheet.setX(x);
    }
    public double getX() {
        return this.spriteSheet.getX();
    }
    public void setY(double y) {
        this.spriteSheet.setY(y);
    }
    public double getY() {
        return this.spriteSheet.getY();
    }



}
