package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;


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

        // всплвыющая подсказка
        AtomicReference<Double> myProgress = new AtomicReference<>(0.0); // атомарная переменная, для числа
        Tooltip tooltip = new Tooltip(); // создание самой подсказки
        slider.setTooltip(tooltip); // где будем подсказывать, при наведении куда?
        progressBar.setTooltip(tooltip);

        // действие на ползунке
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            progressBar.setProgress(newValue.doubleValue()/100); // изменяем прогресс
            progressIndicator.setProgress(newValue.doubleValue()/100);
            myProgress.set(progressIndicator.getProgress());  // наша атомарная переменная
            tooltip.setText((myProgress)+"");                   // которую мы закидываем в подсказку
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