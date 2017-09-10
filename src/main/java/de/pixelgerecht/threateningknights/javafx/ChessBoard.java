package de.pixelgerecht.threateningknights.javafx;

import de.pixelgerecht.threateningknights.rules.Board;
import de.pixelgerecht.threateningknights.rules.SetPiece;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.Optional;

/**
 * Creates the pane of the board-grid itself.
 */
class ChessBoard {
    private final int width;
    private final int height;

    private final BorderPane[][] fieldPanes;

    ChessBoard(int width, int height) {
        this.width = width;
        this.height = height;

        this.fieldPanes = new BorderPane[width][height];
    }

    GridPane create() {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 400);

        addConstraints(gridPane);

        for (int x = 0; x < width; x++) {
            String firstColor = x % 2 == 0 ? "#8B4513" : "#FFF8DC";
            String secondColor = x % 2 == 0 ? "#FFF8DC" : "#8B4513";

            for (int y = 0; y < height; y++) {
                BorderPane field = new BorderPane();

                String color = y % 2 == 0 ? secondColor : firstColor;

                field.setStyle("-fx-background-color: " + color + ";");
                gridPane.add(field, x, y);

                fieldPanes[x][y] = field;
            }
        }
        return gridPane;
    }

    private void addConstraints(GridPane gridPane) {
        for (int x = 0; x < width; x++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100.0d / (double) width);
            cc.setMinWidth(10);
            cc.setFillWidth(true);
            gridPane.getColumnConstraints().add(cc);
        }

        for (int y = 0; y < height; y++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100.0d / (double) height);
            rc.setMinHeight(10);
            rc.setFillHeight(true);
            gridPane.getRowConstraints().add(rc);
        }
    }


    void showSituation(Board situation) {
        if (situation.getWidth() != width || situation.getHeight() != height) {
            throw new IllegalArgumentException(situation + " has different dimension than this (" + width + ", " + height + ")");
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (fieldPanes[x][y] == null) {
                    throw new IllegalStateException("Call create() first!");
                }

                fieldPanes[x][y].getChildren().clear();

                Optional<SetPiece> piece = situation.getPiece(x, y);
                if (piece.isPresent()) {
                    RenderedPiece renderedPiece = new RenderedPiece(piece.get().getPiece());
                    fieldPanes[x][y].setCenter(renderedPiece.asNode());
                }
            }
        }
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}
