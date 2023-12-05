import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

public class GameScene extends Scene{
    private final Camera camera;
    private final Pane panel;

    private StaticThing backgroundLeft;
    private StaticThing backgroundRight;
    private Hero hero;


    public GameScene(Pane panel, double width, double height, Camera camera){
        super(panel, width, height);
        this.camera = camera;
        this.panel = panel;
        this.backgroundLeft = new StaticThing(width, height,"assets/img/desert.png");
        this.backgroundRight = new StaticThing(width, height,"assets/img/desert.png");
        this.panel.getChildren().addAll(
                backgroundLeft.getImageView(),
                backgroundRight.getImageView());
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(7), e -> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        this.hero = new Hero(80, 250, 0);
        panel.getChildren().add(hero.getSpriteSheet());
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(200), e -> updateHero()));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.SPACE){
                    hero.jump();
                }
            }
        });


    }

    public void render(){
        double cameraX = camera.getX();
        double width = backgroundLeft.getImageView().getFitWidth();
        double leftBackgroundX =  - cameraX % width;
        double rightBackgroundX =  width + leftBackgroundX ;
        backgroundLeft.getImageView().setX(leftBackgroundX);
        backgroundLeft.getImageView().setY(0);

        backgroundRight.getImageView().setX(rightBackgroundX);
        backgroundRight.getImageView().setY(0);

    }
    public void update(){
        camera.setX(camera.getX() + 1);
        render();
    }
    private void updateHero() {
        hero.setIndex((hero.getIndex() + 1)%hero.getMaxIndex());
        hero.getSpriteSheet().setViewport(hero.createViewport(hero.getIndex()));


    }
}
