package de.pixelgerecht.threateningknights.solution;

import de.pixelgerecht.threateningknights.rules.Board;
import de.pixelgerecht.threateningknights.rules.Move;
import de.pixelgerecht.threateningknights.rules.Piece;
import de.pixelgerecht.threateningknights.rules.SetPiece;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Finds solutions on a given board for specific situations.
 */
public class Solutions {

    private final Board initial;

    public Solutions(Board initialSituation) {
        this.initial = initialSituation;
    }


    /**
     * Finds all situations where the two given pieces threat each other.
     * @param firstPiece First piece on board.
     * @param secondPiece Second piece on board.
     * @return Detected situations.
     */
    public List<Board> findSymmetricThreats(Piece firstPiece, Piece secondPiece) {
        List<Board> result = new LinkedList<>();

        for (int x = 0; x < initial.getWidth(); x++) {
            for (int y = 0; y < initial.getHeight(); y++) {
                SetPiece source = new SetPiece(firstPiece, x, y);

                Set<Move> moves = firstPiece.getType().getMoves();
                for (Move move : moves) {
                    int tx = x + move.getDx();
                    int ty = y + move.getDy();

                    if ( !initial.isValidPosition(tx, ty)) {
                        continue;
                    }

                    SetPiece target = new SetPiece(secondPiece, tx, ty);

                    Board situation = new Board(initial.getWidth(), initial.getHeight(), source, target);

                    if (SituationDetector.SYMMETRIC_THREAT.test(situation)) {
                        result.add(situation);
                    }
                }
            }
        }

        return result;
    }
}
