package de.pixelgerecht.knightproblem.rules;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ThreatTest {
    private SetPiece source;
    private SetPiece target;

    private Threat subject;


    @Before
    public void setUp() throws Exception {
        source = mock(SetPiece.class);
        target = mock(SetPiece.class);

        subject = new Threat(source, target);
    }


    @Test
    public void hasSource() throws Exception {
        assertThat(subject.getSource(), equalTo(source));
    }

    @Test
    public void hasTarget() throws Exception {
        assertThat(subject.getTarget(), equalTo(target));
    }

    @Test
    public void equalIfSourceAndTargetEqual() throws Exception {
        Threat equalThreat = new Threat(source, target);

        assertThat(subject, equalTo(equalThreat));
    }

}