package de.pixelgerecht.threateningknights.rules;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/**
 * All threats on a given board.
 */
public class ThreatDetector {
    private final Board board;

    public ThreatDetector(Board board) {
        this.board = board;
    }

    /**
     * Detects all current threats on the board.
     * @return Unmodifiable set of all current threats on board.
     */
    public Set<Threat> findAll() {
        return findAllThreatsOnBoard(board);
    }

    private Set<Threat> findAllThreatsOnBoard(Board board) {
        Set<Threat> result = new HashSet<>();

        int width = board.getWidth();
        int height = board.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Optional<SetPiece> setPiece = board.getPiece(x, y);
                if (!setPiece.isPresent()) {
                    continue;
                }

                Set<Threat> threats = findAllThreatsByPiece(setPiece.get());
                result.addAll(threats);
            }
        }

        return unmodifiableSet(result);
    }

    private Set<Threat> findAllThreatsByPiece(SetPiece source) {
        Set<Threat> result = new HashSet<>();

        Set<Move> possibleMoves = source.getPiece().getType().getMoves();
        for (Move move : possibleMoves) {
            Optional<Threat> threat = findThreat(source, move);

            threat.ifPresent(result::add);
        }

        return result;
    }

    private Optional<Threat> findThreat(SetPiece source, Move move) {
        int tx = source.getX() + move.getDx();
        int ty = source.getY() + move.getDy();

        Optional<SetPiece> target = board.getPiece(tx, ty);
        if (!target.isPresent()) {
            return Optional.empty();
        }

        boolean sameColor = target.get().getPiece().getColor() == source.getPiece().getColor();
        if (sameColor) {
            return Optional.empty();
        }

        Threat newThreat = new Threat(source, target.get());
        return Optional.of(newThreat);
    }
}
