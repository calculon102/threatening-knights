package de.pixelgerecht.threateningknights.rules;

import java.util.Optional;

/**
 * Two-dimensional board, accepting rules to be set on coordinates.
 */
public class Board {
    private final int width;
    private final int height;
    private final Piece[][] pieces;

    /**
     * Initializes a new board.
     * @param width Width of board. Minimum 1.
     * @param height Height of board. Minimum 1.
     */
    public Board(int width, int height, SetPiece... initialPieces) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be non-negative!");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be non-negative!");
        }

        this.width = width;
        this.height = height;
        pieces = new Piece[width][height];

        for (SetPiece piece : initialPieces) {
            addPiece(piece);
        }
    }

    /**
     * Number of fields of this board on x-axis.
     * @return An integer.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Number of fields of this board on y-axis.
     * @return An integer.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the given piece on board. Will replace any other piece previously set on specific position.
     * @param piece Piece to be set.
     */
    private void addPiece(SetPiece piece) {
        int x = piece.getX();
        int y = piece.getY();

        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("piece has invalid position!!");
        }

        pieces[x][y] = piece.getPiece();
    }

    /**
     * Gets the piece on the given position.
     * @param x Position on width-axis beginning with 0.
     * @param y Position on height-axis beginning with 0.
     * @return Piece on position or empty if none present.
     */
    public Optional<SetPiece> getPiece(int x, int y) {
        if (!isValidPosition(x, y)) {
            return Optional.empty();
        }

        Piece piece = pieces[x][y];
        if (piece == null) {
            return Optional.empty();
        }

        return Optional.of(new SetPiece(piece, x, y));
    }

    /**
     * Checks if given coordinates define a valid position on this board.
     * @param x Position on width-axis beginning with 0.
     * @param y Position on height-axis beginning with 0.
     * @return true if this is the case. Otherwise false.
     */
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && y >=0 && x < width && y < height;
    }
}
