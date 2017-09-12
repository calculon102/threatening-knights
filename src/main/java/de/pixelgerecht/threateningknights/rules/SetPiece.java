package de.pixelgerecht.threateningknights.rules;

/**
 * Combines a piece with a two-dimensional position.
 */
public class SetPiece {
    private final Piece piece;
    private final int x;
    private final int y;

    public SetPiece(Piece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    /**
     * The piece on this position.
     * @return A {@link Piece}.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Portion of this piece on x-axis on board.
     * @return A non-negative integer.
     */
    int getX() {
        return x;
    }

    /**
     * Portion of this piece on y-axis on board.
     * @return A non-negative integer.
     */
    int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetPiece setPiece = (SetPiece) o;

        return x == setPiece.x && y == setPiece.y && piece.equals(setPiece.piece);
    }

    @Override
    public int hashCode() {
        int result = piece.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return piece + " (" + x + ", " + y + ")";
    }
}
