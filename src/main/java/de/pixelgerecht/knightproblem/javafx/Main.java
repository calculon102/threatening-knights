package de.pixelgerecht.knightproblem.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Entry-point for JavaFX-view.
 */
public class Main extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Knight problem");

        int width = 8;
        int height = 8;

        ChessScene chessScene = new ChessScene(width, height);

        primaryStage.setScene(chessScene.create());
        primaryStage.show();
    }
}
