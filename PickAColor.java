import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.shape.Circle;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import java.util.ArrayList;

public class PickAColor extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		ArrayList<String> colors = PickAColor.getColors();

		Circle circle = new Circle();
		circle.setRadius(100);

		ComboBox<String> colorBox = new ComboBox<>();
		colorBox.getItems().addAll(colors);
		colorBox.setValue(colors.get(0));
		circle.setStyle("-fx-fill: " + colorBox.getValue());

		colorBox.setOnAction(event -> {
			circle.setStyle("-fx-fill: " + colorBox.getValue());
		});

		VBox vbox = new VBox(20, circle, colorBox);
		vbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vbox, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.setTitle("All the Colors of the Rain");
		primaryStage.show();
	}

	public static ArrayList<String> getColors() {
		Field[] fields = Color.class.getDeclaredFields();
		ArrayList<String> colors = new ArrayList<>();

		for (int index = 7; index < fields.length; index++) {
		    if (Modifier.isStatic(fields[index].getModifiers())) {
		    	String[] fieldTokens = fields[index].toString().split("\\.");
		        colors.add(fieldTokens[fieldTokens.length - 1]);
		    }
		}

		return colors;
	}
}