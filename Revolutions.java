import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Revolutions extends Application {
    private double radians = 0.0;
    private Circle earth = new Circle();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle sun = new Circle();

        sun.setCenterX(250);
        sun.setCenterY(250);
        sun.setRadius(150);
        sun.setFill(Color.YELLOW);

        earth.setCenterX(425);
        earth.setCenterY(250);
        earth.setRadius(25);
        earth.setFill(Color.DEEPSKYBLUE);

        Pane root = new Pane();
        root.getChildren().addAll(sun, earth);

        Scene scene = new Scene(root, 500, 500);

        AnimationTimer timer = new MyTimer();
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Revolution Demo");
        primaryStage.show();
    }

    private class MyTimer extends AnimationTimer {
        public void handle(long now) {
            radians += 0.01;
            earth.setCenterX(250 + Math.cos(radians) * 200);
            earth.setCenterY(250 + Math.sin(radians) * 250);
        }
    }
}
