package de.pixelgerecht.threateningknights.rules;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static de.pixelgerecht.threateningknights.rules.Color.BLACK;
import static de.pixelgerecht.threateningknights.rules.Color.WHITE;
import static de.pixelgerecht.threateningknights.rules.Type.KNIGHT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SetPieceTest {

    private final Piece expectedPiece;
    private final int expectedX;
    private final int expectedY;

    private final SetPiece subject;

    @Parameterized.Parameters(name="{0} on ({1},{2})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Piece(KNIGHT, WHITE), 0, 1 },
                { new Piece(KNIGHT, BLACK), 1, 0 }
        });
    }

    public SetPieceTest(Piece expectedPiece, int expectedX, int expectedY) {
        this.expectedPiece = expectedPiece;
        this.expectedX = expectedX;
        this.expectedY = expectedY;
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