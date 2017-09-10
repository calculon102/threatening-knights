package de.pixelgerecht.threateningknights.rules;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/**
 * All threats on a given board.
 */
public class BoardThreats {
    private final Board board;

    public BoardThreats(Board ofBoard) {
        this.board = ofBoard;
    }

    /**
     * Detects all current threats on the board.
     * @return Set of detectAll currents threats on board.
     */
    public Set<Threat> detectAll() {
        return detectThreats(board);
    }


    private Set<Threat> detectThreats(Board board) {
        Set<Threat> result = new HashSet<>();

        int width = board.getWidth();
        int height = board.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Optional<SetPiece> setPiece = board.getPiece(x, y);
                if (!setPiece.isPresent()) {
                    continue;
                }

                Set<Threat> threatsFromPosition = detectThreatsFromPosition(setPiece.get());
                result.addAll(threatsFromPosition);
            }
        }

        return unmodifiableSet(result);
    }


    private Set<Threat> detectThreatsFromPosition(SetPiece source) {
        Set<Threat> result = new HashSet<>();

        for (Move move : source.getPiece().getType().getMoves()) {
            int tx = source.getX() + move.getDx();
            int ty = source.getY() + move.getDy();

            if (!board.isValidPosition(tx, ty)) {
                continue;
            }

            Optional<SetPiece> target = board.getPiece(tx, ty);
            if (!target.isPresent()) {
                continue;
            }

            boolean sameColor = target.get().getPiece().getColor() == source.getPiece().getColor();
            if (sameColor) {
                continue;
            }

            result.add(new Threat(source, target.get()));
        }

        return result;
    }
}
