package de.pixelgerecht.knightproblem.solution;

import de.pixelgerecht.knightproblem.rules.Board;
import de.pixelgerecht.knightproblem.rules.Color;
import de.pixelgerecht.knightproblem.rules.Piece;
import de.pixelgerecht.knightproblem.rules.Type;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SolutionsTest {
    private final Piece whiteKnight = new Piece(Type.KNIGHT, Color.WHITE);
    private final Piece blackKnight = new Piece(Type.KNIGHT, Color.BLACK);


    @Test
    public void noSymmetricThreatsBetweenKnightsOn1x1Threat() throws Exception {
        Solutions situations = new Solutions(new Board(1, 1));

        List<Board> solutions = situations.findSymmetricThreats(whiteKnight, blackKnight);

        assertThat(solutions.size(), equalTo(0));
    }

    @Test
    public void noSymmetricThreatsBetweenKnightsOn2x2Threat() throws Exception {
        Solutions situations = new Solutions(new Board(2, 2));

        List<Board> solutions = situations.findSymmetricThreats(whiteKnight, blackKnight);

        assertThat(solutions.size(), equalTo(0));
    }

    @Test
    public void fourSymmetricThreatsBetweenKnightsOn3x2Threat() throws Exception {
        Solutions situations = new Solutions(new Board(3, 2));

        List<Board> solutions = situations.findSymmetricThreats(whiteKnight, blackKnight);

        assertThat(solutions.size(), equalTo(4));
    }

    @Test
    public void sixteenSymmetricThreatsBetweenKnightsOn3x3Threat() throws Exception {
        Solutions situations = new Solutions(new Board(3, 3));

        List<Board> solutions = situations.findSymmetricThreats(whiteKnight, blackKnight);

        assertThat(solutions.size(), equalTo(16));
    }
}
