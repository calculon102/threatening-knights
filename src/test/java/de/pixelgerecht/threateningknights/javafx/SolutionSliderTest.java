package de.pixelgerecht.threateningknights.javafx;

import de.pixelgerecht.threateningknights.rules.Board;
import de.pixelgerecht.threateningknights.solution.Solutions;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class SolutionSliderTest {
    @ClassRule
    public static final JavaFxRule FX_APP = new JavaFxRule();

    @Test
    public void createsPane() throws Exception {
        Solutions solutions = Mockito.mock(Solutions.class);

        ChessBoard chessBoard = Mockito.mock(ChessBoard.class);
        when(chessBoard.getWidth()).thenReturn(1);
        when(chessBoard.getHeight()).thenReturn(1);

        SolutionsSlider solutionsSlider = new SolutionsSlider(solutions, chessBoard);
        Pane pane = solutionsSlider.create();

        assertThat(pane, instanceOf(Pane.class));
        assertThat(pane.getChildren().size(), equalTo(2));
        assertThat(pane.getChildren().get(0), instanceOf(Label.class));

        Node sliderNode = pane.getChildren().get(1);
        assertThat(sliderNode, instanceOf(Slider.class));

        Slider slider = (Slider) sliderNode;
        slider.setValue(1);

        verify(chessBoard, atLeastOnce()).showSituation(any(Board.class));
    }

}
