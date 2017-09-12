package de.pixelgerecht.threateningknights.rules;

/**
 * Logical movement on a two-dimensional pane.
 */
public class Move {
    private final int dx;
    private final int dy;

    Move(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Delta of fields to translate on x-axis.
     * @return A signed integer.
     */
    public int getDx() {
        return dx;
    }

    /**
     * Delta of fields to translate on y-axis.
     * @return A signed integer.
     */
    public int getDy() {
        return dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        return dx == move.dx && dy == move.dy;
    }

    @Override
    public int hashCode() {
        int result = dx;
        result = 31 * result + dy;
        return result;
    }

    @Override
    public String toString() {
        return "Move(" + dx + ", " + dy + ')';
    }
}
