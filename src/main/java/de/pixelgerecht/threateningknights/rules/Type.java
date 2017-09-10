package de.pixelgerecht.threateningknights.rules;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Type of piece with specific behaviour.
 */
public enum Type {
    KNIGHT {
        @Override
        public Set<Move> getMoves() {
            return new HashSet<>(
                    Arrays.asList(
                            new Move(1, -2),
                            new Move(2, -1),
                            new Move(2, 1),
                            new Move(1, 2),
                            new Move(-1, 2),
                            new Move(-2, 1),
                            new Move(-2, -1),
                            new Move(-1, -2)
                    )
            );
        }
    };


    public abstract Set<Move> getMoves();

    @Override
    public String toString() {
        return this.name();
    }
}
