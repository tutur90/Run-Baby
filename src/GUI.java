import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");

        Group root = new Group();
        Pane pane = new Pane(root);
        Camera camera = new Camera(0,0);


        // Use GameScene instead of Scene
        GameScene gameScene = new GameScene(pane, 600, 400, camera);
        gameScene.render();

        primaryStage.setScene(gameScene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
