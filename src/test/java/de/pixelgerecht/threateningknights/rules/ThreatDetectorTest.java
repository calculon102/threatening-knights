package de.pixelgerecht.threateningknights.rules;

import org.junit.Test;

import java.util.Set;

import static de.pixelgerecht.threateningknights.rules.Color.BLACK;
import static de.pixelgerecht.threateningknights.rules.Color.WHITE;
import static de.pixelgerecht.threateningknights.rules.Type.KNIGHT;
import static java.util.Collections.emptySet;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class ThreatDetectorTest {

    @Test
    public void noThreatsOnEmptyBoard() throws Exception {
        ThreatDetector detector1x1 = new ThreatDetector(new Board(1, 1));
        assertThat(detector1x1.findAll(), equalTo(emptySet()));

        ThreatDetector detector2x2 = new ThreatDetector(new Board(2, 3));
        assertThat(detector2x2.findAll(), equalTo(emptySet()));

        ThreatDetector detector3x3 = new ThreatDetector(new Board(3, 3));
        assertThat(detector3x3.findAll(), equalTo(emptySet()));
    }

    @Test
    public void noThreatsOnBoardWithOneKnight() throws Exception {
        Piece whiteKnight = new Piece(KNIGHT, WHITE);
        SetPiece setWhiteKnight = new SetPiece(whiteKnight, 0, 0);
        Board board = new Board(3, 3, setWhiteKnight);

        ThreatDetector detector = new ThreatDetector(board);

        assertThat(detector.findAll(), equalTo(emptySet()));
    }

    @Test
    public void twoThreatsWithSymmetricKnightsOfDifferentColor() throws Exception {
        Piece whiteKnight = new Piece(KNIGHT, WHITE);
        SetPiece setWhiteKnight = new SetPiece(whiteKnight, 0, 0);

        Piece blackKnight = new Piece(KNIGHT, BLACK);
        SetPiece setBlackKnight = new SetPiece(blackKnight, 1, 2);

        Board board = new Board(3, 3, setWhiteKnight, setBlackKnight);

        ThreatDetector detector = new ThreatDetector(board);
        Set<Threat> actualThreats = detector.findAll();

        assertThat(actualThreats.size(), equalTo(2));

        assertThat(actualThreats, hasItems(
                new Threat(setWhiteKnight, setBlackKnight),
                new Threat(setBlackKnight, setWhiteKnight)
        ));
    }

    @Test
    public void noThreatsWithSymmetricKnightsOfSameColor() throws Exception {
        Piece whiteKnight1 = new Piece(KNIGHT, WHITE);
        SetPiece setWhiteKnight = new SetPiece(whiteKnight1, 0, 0);

        Piece whiteKnight2 = new Piece(KNIGHT, WHITE);
        SetPiece anotherWhiteKnight = new SetPiece(whiteKnight2, 1, 2);
        Board board = new Board(3, 3, setWhiteKnight, anotherWhiteKnight);

        ThreatDetector threatDetector = new ThreatDetector(board);

        Set<Threat> all = threatDetector.findAll();
        assertThat(all.size(), equalTo(0));
    }
}
