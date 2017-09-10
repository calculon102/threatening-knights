package de.pixelgerecht.knightproblem.rules;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Sets the given piece on board. Will replace any other piece previously set on specific position.
     * @param piece Piece to be set.
     */
    private void addPiece(SetPiece piece) {
        if (!isValidPosition(piece.getX(), piece.getY())) {
            throw new IllegalArgumentException("piece has invalid position!!");
        }

        pieces[piece.getX()][piece.getY()] = piece.getPiece();
    }

    /**
     * Gets the piece on the given position.
     * @param x Position on width-axis beginning with 0.
     * @param y Position on height-axis beginning with 0.
     * @return Piece on position or empty if none present.
     */
    public Optional<SetPiece> getPiece(int x, int y) {
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
