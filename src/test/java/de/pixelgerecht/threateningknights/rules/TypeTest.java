package de.pixelgerecht.threateningknights.rules;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TypeTest {

    @Test
    public void knowsItsMoves() {
        Type type = Type.KNIGHT;

        Set<Move> actual = type.getMoves();
        Set<Move> expected = new HashSet<>(
                Arrays.asList(
                        new Move(1, -2),
                        new Move(2, -1),
                        new Move(2, 1),
                        new Move(1, 2),
                        new Move(-1, 2),
                        new Move(-2, 1),
                        new Move(-2, -1),
                        new Move(-1, -2)
                )
        );

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void implementsToString() throws Exception {
        Type type = Type.KNIGHT;

        assertThat(type.toString(), equalTo("KNIGHT"));
    }
}
