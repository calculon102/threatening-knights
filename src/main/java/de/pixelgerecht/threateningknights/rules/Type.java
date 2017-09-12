package de.pixelgerecht.threateningknights.rules;

import java.util.*;

/**
 * Type of piece with specific behaviour.
 */
public enum Type {
    KNIGHT(Arrays.asList(
            new Move(1, -2),
            new Move(2, -1),
            new Move(2, 1),
            new Move(1, 2),
            new Move(-1, 2),
            new Move(-2, 1),
            new Move(-2, -1),
            new Move(-1, -2)));


    private final Set<Move> moves;

    Type(Collection<Move> moves) {
        this.moves = Collections.unmodifiableSet(new HashSet<>(moves));
    }

    /**
     * All possible translations on a two-dimensional board.
     * @return Unmodifiable set.
     */
    public Set<Move> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
