package de.pixelgerecht.knightproblem.rules;

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

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " " + type;
    }
}
