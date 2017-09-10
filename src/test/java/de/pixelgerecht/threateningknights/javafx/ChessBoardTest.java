package de.pixelgerecht.threateningknights.javafx;

import de.pixelgerecht.threateningknights.rules.Board;
import de.pixelgerecht.threateningknights.rules.Piece;
import de.pixelgerecht.threateningknights.rules.SetPiece;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.junit.ClassRule;
import org.junit.Test;

import static de.pixelgerecht.threateningknights.rules.Color.WHITE;
import static de.pixelgerecht.threateningknights.rules.Type.KNIGHT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ChessBoardTest {
    @ClassRule
    public static final JavaFxRule FX_APP = new JavaFxRule();

    @Test
    public void createsGridPane() throws Exception {
        ChessBoard chessBoard = new ChessBoard(3 ,4);

        GridPane pane = chessBoard.create();

        assertThat(pane.getRowConstraints().size(), equalTo(4));
        assertThat(pane.getColumnConstraints().size(), equalTo(3));

        assertThat(pane.getMinWidth(), equalTo(400.0d));
        assertThat(pane.getMinHeight(), equalTo(400.0d));
    }

    @Test
    public void showsSolution() throws Exception {
        ChessBoard chessBoard = new ChessBoard(3 ,4);

        GridPane pane = chessBoard.create();

        long previousCount = pane.getChildren().stream()
                .filter(c -> c instanceof Pane)
                .map(c -> (Pane) c)
                .filter(p -> !p.getChildren().isEmpty())
                .count();
        assertThat(previousCount, equalTo(0L));

        chessBoard.showSituation(new Board(3, 4, new SetPiece( new Piece(KNIGHT, WHITE),1, 1)));

        long actualCount = pane.getChildren().stream()
                .filter(c -> c instanceof Pane)
                .map(c -> (Pane) c)
                .filter(p -> !p.getChildren().isEmpty())
                .count();

        assertThat(actualCount, equalTo(1L));

        // Further testing may assert the correct grid.
    }

    @Test(expected = IllegalArgumentException.class)
    public void detectsIllegalSolutionDimension() {
        ChessBoard chessBoard = new ChessBoard(1 ,1);
        chessBoard.create();

        chessBoard.showSituation(new Board(1, 2, new SetPiece( new Piece(KNIGHT, WHITE),0, 1)));
    }

    @Test
    public void hasSize() throws Exception {
        ChessBoard chessBoard = new ChessBoard(1, 2);

        assertThat(chessBoard.getWidth(), equalTo(1));
        assertThat(chessBoard.getHeight(), equalTo(2));
    }
}
