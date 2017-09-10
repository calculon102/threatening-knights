package de.pixelgerecht.threateningknights.rules;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void hasSize() throws Exception {
        Board board = new Board(1, 2);

        assertThat(board.getWidth(), equalTo(1));
        assertThat(board.getHeight(), equalTo(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void widthIsAlwaysPositive() throws Exception {
        new Board(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void heightIsAlwaysPositive() throws Exception {
        new Board(1, 0);
    }

    @Test
    public void canAddPieces() throws Exception {
        Board board = new Board(1, 1);

        Optional<SetPiece> actual = board.getPiece(0, 0);
        assertThat(actual.isPresent(), equalTo(false));

        Piece piece = new Piece(Type.KNIGHT, Color.WHITE);
        SetPiece expected = new SetPiece(piece,0,0);

        board = new Board(1, 1, expected);

        actual = board.getPiece(0, 0);

        assertThat(actual.isPresent(), equalTo(true));
        assertThat(actual, equalTo(Optional.of(expected)));
    }

    @Test
    public void tellsValidPosition() throws Exception {
        Board board = new Board(1, 1);

        assertThat(board.isValidPosition(0, 0), equalTo(true));
        assertThat(board.isValidPosition(-1, 0), equalTo(false));
        assertThat(board.isValidPosition(0, -1), equalTo(false));
        assertThat(board.isValidPosition(-1, -1), equalTo(false));
        assertThat(board.isValidPosition(0, 1), equalTo(false));
        assertThat(board.isValidPosition(1, 0), equalTo(false));
        assertThat(board.isValidPosition(1, 1), equalTo(false));
    }
}

