package com.search;

import com.problem.NeighbourGenerator;
import com.problem.ObjectiveFunction;
import com.problem.Problem;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public class SimulatedAnnealing {

    double temperature;
    double temperatureDecrease = 0.0001;
    final static double T_MAX = 1000;
    final static double F_TARGET = 1;

    ObjectiveFunction objectiveFunction;
    NeighbourGenerator neighbourGenerator;
    State initialState;

    public SimulatedAnnealing(Problem problem) {
        this.objectiveFunction = problem.getObjectiveFunction();
        this.neighbourGenerator = problem.getNeighbourGenerator();
        this.initialState = problem.getInitialState();
    }

    public State search() {
        temperature = T_MAX;
        State currentState = initialState;
        double stateValue;
        while ((stateValue = objectiveFunction.evaluate(currentState)) < F_TARGET && temperature > 0) {
            ArrayList<State> neighbours = neighbourGenerator.generateNeighbours(currentState);
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
            double q = (bestNeighbourValue - stateValue) / (stateValue);
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
