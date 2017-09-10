package de.pixelgerecht.threateningknights.rules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class MoveTest {

    private final Move subject;
    private final int expectedDx;
    private final int expectedDy;
    private final String expectedToString;

    @Parameterized.Parameters(name = "{2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {0, 0, "Move(0, 0)"},
                        {1, 2, "Move(1, 2)"},
                        {2, 1, "Move(2, 1)"},
                        {-3,-5, "Move(-3, -5)"},
                }
        );
    }

    public MoveTest(int dx, int dy, String expectedToString) {
        this.subject = new Move(dx, dy);
        this.expectedDx = dx;
        this.expectedDy = dy;
        this.expectedToString = expectedToString;
    }

    @Test
    public void hasDeltaX() throws Exception {
        assertThat(subject.getDx(), equalTo(expectedDx));
    }

    @Test
    public void hasDeltaY() throws Exception {
        assertThat(subject.getDy(), equalTo(expectedDy));
    }

    @Test
    public void implementsToString() throws Exception {
        assertThat(subject.toString(), equalTo(expectedToString));
    }

    @Test
    public void implementsEquals() throws Exception {
        assertThat(subject, equalTo(new Move(expectedDx, expectedDy)));
    }

    @Test
    public void implementsHashSet() throws Exception {
        assertThat(subject.hashCode(), equalTo(new Move(expectedDx, expectedDy).hashCode()));
    }
}
