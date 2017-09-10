package de.pixelgerecht.knightproblem.rules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PieceTest {

    @Parameterized.Parameters(name="{0} {1}")
    public static Collection<Object[]> data() {
        List<Object[]> parameters = new LinkedList<>();

        for (Type type : Type.values()) {
            for (Color color : Color.values()) {
                parameters.add(new Object[] {
                   type, color
                });
            }
        }

        return parameters;
    }


    private final Type expectedType;
    private final Color expectedColor;
    private final Piece subject;


    public PieceTest(Type expectedType, Color expectedColor) {
        this.expectedType = expectedType;
        this.expectedColor = expectedColor;

        subject = new Piece(expectedType, expectedColor);
    }


    @Test
    public void hasType() throws Exception {
        Type type = subject.getType();

        assertThat(type, equalTo(this.expectedType));
    }

    @Test
    public void hasColor() throws Exception {
        Color color = subject.getColor();

        assertThat(color, equalTo(this.expectedColor));
    }

    @Test
    public void implementsToString() throws Exception {
        assertThat(subject.toString(), equalTo(expectedColor + " " + expectedType));
    }

}
