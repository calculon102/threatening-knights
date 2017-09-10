package de.pixelgerecht.threateningknights.rules;

/**
 * Relation between a positioned-piece (source) and another one (target), where the source threatens the target. 
 */
public class Threat {
    private final SetPiece source;
    private final SetPiece target;

    Threat(SetPiece source, SetPiece target) {
        this.source = source;
        this.target = target;
    }

    public SetPiece getSource() {
        return source;
    }

    public SetPiece getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Threat threat = (Threat) o;

        return source.equals(threat.source) && target.equals(threat.target);
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + target.hashCode();
        return result;
    }
}
