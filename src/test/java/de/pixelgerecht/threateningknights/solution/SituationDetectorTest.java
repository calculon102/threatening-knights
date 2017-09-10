package de.pixelgerecht.threateningknights.solution;

import de.pixelgerecht.threateningknights.rules.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SituationDetectorTest {
    private final SituationDetector subject;
    private final boolean expectedResult;
    private final Board situation;


    @Parameterized.Parameters(name = "{0}={1} with {2}")
    public static Collection<Object[]> data() {
        Piece whiteKnight = new Piece(Type.KNIGHT, Color.WHITE);
        Piece blackKnight = new Piece(Type.KNIGHT, Color.BLACK);

        return asList(new Object[][] {
                {
                        SituationDetector.SYMMETRIC_THREAT,
                        false,
                        new Board(
                                3,
                                3,
                                new SetPiece(whiteKnight, 0, 0), new SetPiece(blackKnight, 1, 0)
                        )
                },
                {
                        SituationDetector.SYMMETRIC_THREAT,
                        true,
                        new Board(
                                3,
                                3,
                                new SetPiece(whiteKnight, 0, 0), new SetPiece(blackKnight, 2, 1)
                        )
                },


        });
    }

    public SituationDetectorTest(SituationDetector subject, boolean expectedResult, Board situation) {
        this.subject = subject;
        this.expectedResult = expectedResult;
        this.situation = situation;
    }

    @Test
    public void detectsSituation() throws Exception {
        boolean actual = subject.test(situation);

        assertThat(actual, equalTo(expectedResult));
    }
}
