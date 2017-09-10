package de.pixelgerecht.threateningknights.javafx;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ChessSceneTest {
    @ClassRule
    public static final JavaFxRule FX_APP = new JavaFxRule();


    @Test
    public void createsScene() throws Exception {
        int expectedBoardHeight = 8;
        int expectedBoardWidth = 8;

        ChessScene chessScene = new ChessScene(expectedBoardWidth, expectedBoardHeight);

        Scene actual = chessScene.create();

        assertThat(actual.getRoot(), instanceOf(ScrollPane.class));
    }
}
