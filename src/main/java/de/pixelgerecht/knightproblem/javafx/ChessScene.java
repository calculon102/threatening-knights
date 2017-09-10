package de.pixelgerecht.knightproblem.javafx;

import de.pixelgerecht.knightproblem.rules.Board;
import de.pixelgerecht.knightproblem.solution.Solutions;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

/**
 * Composites a whole chess-scene.
 */
final class ChessScene {

    private final ChessBoard chessBoard;
    private final SolutionsSlider solutionsSlider;

    ChessScene(int boardWidth, int boardHeight) {
        chessBoard = new ChessBoard(boardWidth, boardHeight);

        Solutions solutions = new Solutions(new Board(boardWidth, boardHeight));
        solutionsSlider = new SolutionsSlider(solutions, chessBoard);
    }

    Scene create() {
        return new Scene(createChessPane());
    }


    private Parent createChessPane() {
        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(chessBoard.create());
        borderPane.setBottom(solutionsSlider.create());

        ScrollPane boardScrollPane = new ScrollPane(borderPane);
        boardScrollPane.setFitToHeight(true);
        boardScrollPane.setFitToWidth(true);

        return boardScrollPane;
    }
}
