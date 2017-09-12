package de.pixelgerecht.threateningknights.rules;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ThreatTest {
    private final SetPiece source = mock(SetPiece.class);
    private final SetPiece target = mock(SetPiece.class);

    private final Threat subject = new Threat(source, target);


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