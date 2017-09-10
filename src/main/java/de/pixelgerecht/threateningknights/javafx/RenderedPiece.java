package de.pixelgerecht.threateningknights.javafx;

import de.pixelgerecht.threateningknights.rules.Color;
import de.pixelgerecht.threateningknights.rules.Piece;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

/**
 * Renders a piece for JavaFX.
 */
final class RenderedPiece {

    private final Piece piece;

    RenderedPiece(Piece piece) {
        this.piece = piece;
    }

    Node asNode() {
        InputStream resource = getImageStream(piece);

        if (resource == null) {
            return createTextLabel(piece);
        }

        return createImageLabel(resource);
    }

    private InputStream getImageStream(Piece piece) {
        String expectedFile = piece.getColor().name().toLowerCase() + "_" + piece.getType().name().toLowerCase()  + ".png";
        return getClass().getResourceAsStream(expectedFile);
    }

    private Node createTextLabel(Piece piece) {
        Label label = new Label();

        String textRepresentation = piece.getType().name().substring(0, 1);
        label.setText(textRepresentation);

        String color = piece.getColor() == Color.WHITE ? "#ffffff" : "#000000";
        String style = "-fx-color: " + color + "; -fx-font-weight: bold;";
        label.setStyle(style);

        return label;
    }

    private Label createImageLabel(InputStream resource) {
        Label label = new Label();

        Image imageIcon = new Image(resource);
        label.setGraphic(new ImageView(imageIcon));

        return label;
    }
}
