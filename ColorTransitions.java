import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ColorTransitions extends Application {
    private int red = 255;
    private int green = 0;
    private int blue = 0;
    private Label lbl;
    private boolean increasingRed = false;
    private boolean increasingGreen = true;
    private boolean increasingBlue = false;

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();

        lbl = new Label("JavaFX");
        lbl.setFont(Font.font(48));
        root.getChildren().add(lbl);

        AnimationTimer timer = new MyTimer();
        timer.start();

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("AnimationTimer");
        stage.setScene(scene);
        stage.show();
    }

    private class MyTimer extends AnimationTimer {
        @Override
        public void handle(long now) {
            if (increasingGreen)
                increaseGreen();
            else if (increasingBlue)
                increaseBlue();
            else
                increaseRed();
        }

        private void increaseGreen() {
            red -= 1;
            green += 1;
            lbl.setTextFill(Color.rgb(red, green, blue));

            if (red == 0) {
                increasingGreen = false;
                increasingBlue = true;
            }
        }

        private void increaseBlue() {
            green -= 1;
            blue += 1;
            lbl.setTextFill(Color.rgb(red, green, blue));

            if (green == 0) {
                increasingBlue = false;
                increasingRed = true;
            }
        }

        private void increaseRed() {
            blue -= 1;
            red += 1;
            lbl.setTextFill(Color.rgb(red, green, blue));

            if (blue == 0) {
                increasingRed = false;
                increasingGreen = true;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}