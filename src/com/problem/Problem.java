package com.problem;

/**
 * Created by Sondre on 11.10.2014.
 */
public class Problem {

    private ObjectiveFunction objectiveFunction;
    private NeighbourGenerator neighbourGenerator;

    public Problem(ObjectiveFunction objectiveFunction, NeighbourGenerator neighbourGenerator) {
        this.objectiveFunction = objectiveFunction;
        this.neighbourGenerator = neighbourGenerator;
    }

    public ObjectiveFunction getObjectiveFunction() {
        return objectiveFunction;
    }

    public NeighbourGenerator getNeighbourGenerator() {
        return neighbourGenerator;
    }
}
