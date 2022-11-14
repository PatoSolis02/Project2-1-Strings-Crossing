package puzzles.crossing;

import puzzles.common.solver.Configuration;

import java.util.ArrayList;
import java.util.Collection;

public class CrossingConfig implements Configuration {

    private int pupsLeft;
    private int wolvesLeft;
    private int pupsRight;
    private int wolvesRight;
    private boolean boatLeft;

    public CrossingConfig(int pups, int wolves){
        pupsLeft = pups;
        wolvesLeft = wolves;
        pupsRight = 0;
        wolvesRight = 0;
        boatLeft = true;
    }

    public CrossingConfig(CrossingConfig current, int movePups, int moveWolves){
        if(current.boatLeft){
            pupsLeft = current.pupsLeft - movePups;
            pupsRight = current.pupsRight + movePups;
            wolvesLeft = current.wolvesLeft - moveWolves;
            wolvesRight = current.wolvesRight + moveWolves;
            boatLeft = false;
        } else {
            pupsLeft = current.pupsLeft + movePups;
            pupsRight = current.pupsRight - movePups;
            wolvesLeft = current.wolvesLeft + moveWolves;
            wolvesRight = current.wolvesRight - moveWolves;
            boatLeft = true;
        }
    }

    @Override
    public boolean isSolution() {
        return pupsLeft == 0 && wolvesLeft == 0;
    }

    @Override
    public Collection<Configuration> getNeighbors() {
        ArrayList<Configuration> successors = new ArrayList<>();

        if(!boatLeft){
            successors.add(new CrossingConfig(this, 1, 0));
        } else {
            successors.add(new CrossingConfig(this, 1, 0));
            successors.add(new CrossingConfig(this, 2, 0));
            successors.add(new CrossingConfig(this, 0, 1));
        }

        return successors;
    }

    @Override
    public boolean equals(Object other) {
        boolean equal = false;
        if(other instanceof CrossingConfig otherConfig){
            equal = pupsLeft == otherConfig.pupsLeft && wolvesLeft == otherConfig.wolvesLeft
                    && boatLeft == otherConfig.boatLeft;
        }
        return equal;
    }

    @Override
    public int hashCode() {
        int add = 0;
        if(boatLeft){
            add = 1;
        }
        return pupsLeft + pupsRight + add;
    }

    @Override
    public String toString() {
        if(boatLeft){
            return "(BOAT)  left=[" + pupsLeft + ", " + wolvesLeft + "], right=["
                    + pupsRight + ", " + wolvesRight + "]";
        } else {
            return "        left=[" + pupsLeft + ", " + wolvesLeft + "], right=["
                    + pupsRight + ", " + wolvesRight + "] (BOAT)";
        }
    }
}
