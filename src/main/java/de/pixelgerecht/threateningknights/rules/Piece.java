package de.pixelgerecht.threateningknights.rules;

/**
 * Piece for a game with a type and color.
 */
public class Piece {
    private final Type type;
    private final Color color;

    public Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Type of this piece.
     * @return A {@link Type}.
     */
    public Type getType() {
        return type;
    }

    /**
     * Color of this piece.
     * @return A {@link Color}.
     */
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " " + type;
    }
}
