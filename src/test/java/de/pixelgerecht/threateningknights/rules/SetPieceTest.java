package de.pixelgerecht.threateningknights.rules;

import org.junit.Before;
import org.junit.Test;

import static de.pixelgerecht.threateningknights.rules.Color.WHITE;
import static de.pixelgerecht.threateningknights.rules.Type.KNIGHT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SetPieceTest {

    private Piece expectedPiece;
    private int expectedX;
    private int expectedY;

    private SetPiece subject;

    @Before
    public void setUp() throws Exception {
        expectedPiece = new Piece(KNIGHT, WHITE);
        expectedX = 0;
        expectedY = 1;
        subject = new SetPiece(expectedPiece, expectedX, expectedY);
    }

    @Test
    public void hasPiece() throws Exception {
        assertThat(subject.getPiece(), equalTo(expectedPiece));
    }

    @Test
    public void hasX() throws Exception {
        assertThat(subject.getX(), equalTo(expectedX));
    }

    @Test
    public void hasY() throws Exception {
        assertThat(subject.getY(), equalTo(expectedY));
    }

    @Test
    public void sameStateMeansEqual() throws Exception {
        SetPiece equalSetPiece = new SetPiece(expectedPiece, expectedX, expectedY);

        assertThat(equalSetPiece, equalTo(subject));
    }

    @Test
    public void implementsToString() throws Exception {
        assertThat(subject.toString(), equalTo(expectedPiece + " (" + expectedX + ", " + expectedY + ")"));
    }
}