package de.pixelgerecht.threateningknights.javafx;

import de.pixelgerecht.threateningknights.rules.Board;
import de.pixelgerecht.threateningknights.rules.Color;
import de.pixelgerecht.threateningknights.rules.Piece;
import de.pixelgerecht.threateningknights.rules.Type;
import de.pixelgerecht.threateningknights.solution.Solutions;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * User-access to different solutions.
 */
class SolutionsSlider {
    // TODO These should be made configurable, too.
    private final Piece whitePiece = new Piece(Type.KNIGHT, Color.WHITE);
    private final Piece blackPiece = new Piece(Type.KNIGHT, Color.BLACK);

    private final Solutions solutions;
    private final ChessBoard chessBoard;

    SolutionsSlider(Solutions solutions, ChessBoard chessBoard) {
        this.solutions = solutions;
        this.chessBoard = chessBoard;
    }


    Pane create() {
        VBox vBox = new VBox(6);
        vBox.setPadding(new Insets(6,6,6,6));

        vBox.getChildren().add(new Label("Choose Solution:"));

        List<Board> solutionBoards = solutions.findSymmetricThreats(whitePiece, blackPiece);

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(solutionBoards.size());
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        int majorTickUnit = solutionBoards.size() / 10;
        slider.setMajorTickUnit(majorTickUnit <= 0 ? 1 : majorTickUnit);
        slider.setMinorTickCount(1);

        slider.valueProperty().addListener(
                c -> chessBoard.showSituation(getSolution(solutionBoards, (int) slider.getValue()))
        );

        chessBoard.showSituation(getSolution(solutionBoards, (int) slider.getValue()));

        vBox.getChildren().add(slider);

        return vBox;
    }

    private Board getSolution(List<Board> solutionBoards, int index) {
        if (index < 0) {
            return solutionBoards.get(0);
        }

        if (solutionBoards.isEmpty()) {
            return new Board(chessBoard.getWidth(), chessBoard.getHeight());
        }

        if (index >= solutionBoards.size()) {
            return solutionBoards.get(solutionBoards.size() - 1);
        }

        return solutionBoards.get(index);
    }
}
