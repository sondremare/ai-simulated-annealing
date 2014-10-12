package com.problem;

import com.search.State;

/**
 * Created by Sondre on 11.10.2014.
 */
public class Problem {

    private ObjectiveFunction objectiveFunction;
    private NeighbourGenerator neighbourGenerator;
    private State initialState;

    public Problem() {

    }

    public Problem(State state, ObjectiveFunction objectiveFunction, NeighbourGenerator neighbourGenerator) {
        this.initialState = state;
        this.objectiveFunction = objectiveFunction;
        this.neighbourGenerator = neighbourGenerator;
    }

    public ObjectiveFunction getObjectiveFunction() {
        return objectiveFunction;
    }

    public NeighbourGenerator getNeighbourGenerator() {
        return neighbourGenerator;
    }

    public State getInitialState() {
        return initialState;
    }
}
