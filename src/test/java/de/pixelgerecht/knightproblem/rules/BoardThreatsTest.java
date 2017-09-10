package de.pixelgerecht.knightproblem.rules;

import org.junit.Test;

import java.util.Set;

import static de.pixelgerecht.knightproblem.rules.Color.BLACK;
import static de.pixelgerecht.knightproblem.rules.Color.WHITE;
import static de.pixelgerecht.knightproblem.rules.Type.KNIGHT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class BoardThreatsTest {

    @Test
    public void noThreatsOnEmptyBoard() throws Exception {
        Board board = new Board(1, 1);

        BoardThreats boardThreats = new BoardThreats(board);

        assertThat(boardThreats.detectAll().isEmpty(), equalTo(true));
    }

    @Test
    public void twoThreatsWithSymmetricKnightsOfDifferentColor() throws Exception {
        Board board = new Board(3, 3);

        // First no boardThreats
        BoardThreats boardThreats = new BoardThreats(board);
        assertThat(boardThreats.detectAll().isEmpty(), equalTo(true));

        // Add first piece
        Piece whiteKnight = new Piece(KNIGHT, WHITE);
        SetPiece setWhiteKnight = new SetPiece(whiteKnight, 0, 0);
        board = new Board(3, 3, setWhiteKnight);

        // Still no boardThreats with only one piece
        boardThreats = new BoardThreats(board);
        assertThat(boardThreats.detectAll().isEmpty(), equalTo(true));

        // Add second piece
        Piece blackKnight = new Piece(KNIGHT, BLACK);
        SetPiece setBlackKnight = new SetPiece(blackKnight, 1, 2);
        board = new Board(3, 3, setWhiteKnight, setBlackKnight);

        // Now expect two Threats on board.
        boardThreats = new BoardThreats(board);

        Set<Threat> actualThreats = boardThreats.detectAll();
        assertThat(actualThreats.size(), equalTo(2));

        assertThat(actualThreats, hasItems(
                new Threat(setWhiteKnight, setBlackKnight),
                new Threat(setBlackKnight, setWhiteKnight)
        ));
    }


    @Test
    public void noThreatsWithSymmetricKnightsOfSameColor() throws Exception {
        // Add first piece
        Piece whiteKnight1 = new Piece(KNIGHT, WHITE);
        SetPiece setWhiteKnight = new SetPiece(whiteKnight1, 0, 0);

        Piece whiteKnight2 = new Piece(KNIGHT, WHITE);
        SetPiece anotherWhiteKnight = new SetPiece(whiteKnight2, 1, 2);
        Board board = new Board(3, 3, setWhiteKnight, anotherWhiteKnight);

        // There should be no threats
        BoardThreats boardThreats = new BoardThreats(board);

        Set<Threat> all = boardThreats.detectAll();
        assertThat(all.size(), equalTo(0));
    }

}
