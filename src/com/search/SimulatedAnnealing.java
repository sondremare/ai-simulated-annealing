package com.search;

import com.problem.NeighbourGenerator;
import com.problem.ObjectiveFunction;
import com.problem.Problem;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public class SimulatedAnnealing {

    State state;
    double temperature;
    double temperatureDecrease = 10;
    final static double T_MAX = 100.0;
    final static double F_TARGET = 100.0;

    ObjectiveFunction objectiveFunction;
    NeighbourGenerator neighbourGenerator;

    public SimulatedAnnealing(Problem problem) {
        this.objectiveFunction = problem.getObjectiveFunction();
        this.neighbourGenerator = problem.getNeighbourGenerator();
    }

    public State search() {

        State initialState = new State();
        temperature = T_MAX;
        State currentState = initialState;
        double stateValue = objectiveFunction.evaluate(initialState);
        while (objectiveFunction.evaluate(initialState) < F_TARGET) {
            ArrayList<State> neighbours = neighbourGenerator.generateNeighbours(initialState);
            double bestNeighbourValue = 0.0;
            double neighbourValue;
            State bestNeighbour = neighbours.get(0);
            for (State neighbour : neighbours) {
                neighbourValue = objectiveFunction.evaluate(neighbour);
                if (neighbourValue > bestNeighbourValue) {
                    bestNeighbourValue = neighbourValue;
                    bestNeighbour = neighbour;
                }
            }
            double q = (bestNeighbourValue - stateValue) / (stateValue); //TODO CHECK IF DOUBLE DIV OR INT DIV
            double p = Math.min(1, Math.exp(-q / temperature));
            double x = Math.random();
            if (x > p) {
                currentState = bestNeighbour;
            } else {
                currentState = chooseRandomNeighbour(neighbours);
            }
            temperature -= temperatureDecrease;
        }
        return currentState;
    }

    public State chooseRandomNeighbour(ArrayList<State> neighbours) {
        int chosenNeighbour = (int)(neighbours.size() * Math.random());
        return neighbours.get(chosenNeighbour);
    }
}
