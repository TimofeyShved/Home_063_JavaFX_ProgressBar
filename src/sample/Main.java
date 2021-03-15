package sample;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ProgressBar"); // заголовок формы

        // наша панель
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(70);

        // создание пргресса ProgressBar, ProgressIndicator
        ProgressBar progressBar = new ProgressBar(0); // прямоугольник
        ProgressIndicator progressIndicator = new ProgressIndicator(0); // круг
        Slider slider = new Slider(0,100,0); // наш ползунок

        // действие на ползунке
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            progressBar.setProgress(newValue.doubleValue()/100); // изменяем прогресс
            progressIndicator.setProgress(newValue.doubleValue()/100);
        });

        // расположение на форме
        GridPane.setConstraints(slider, 0, 0);
        GridPane.setConstraints(progressBar, 1, 0);
        GridPane.setConstraints(progressIndicator, 2, 0);

        // добавить на панель
        root.getChildren().addAll(slider, progressBar, progressIndicator);

        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }


    public static void main(String[] args) {
        launch(args);
    }
}