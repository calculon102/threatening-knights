package de.pixelgerecht.knightproblem.solution;

import de.pixelgerecht.knightproblem.rules.Board;
import de.pixelgerecht.knightproblem.rules.BoardThreats;
import de.pixelgerecht.knightproblem.rules.Threat;

import java.util.Iterator;
import java.util.Set;

/**
 * Detection-strategies for board-situations.
 */
enum SituationDetector {
    /**
     * Tests if there are exact two pieces on the board which threaten each other.
     */
    SYMMETRIC_THREAT {
        @Override
        boolean test(Board situation) {
            BoardThreats threats = new BoardThreats(situation);
            Set<Threat> allThreats = threats.detectAll();

            if (allThreats.size() != 2) {
                return false;
            }

            Iterator<Threat> threatIterator = allThreats.iterator();
            Threat firstThreat = threatIterator.next();
            Threat secondThreat = threatIterator.next();

            return firstThreat.getSource().equals(secondThreat.getTarget())
                    && secondThreat.getSource().equals(firstThreat.getTarget());
        }
    };

    abstract boolean test(Board situation);
}
