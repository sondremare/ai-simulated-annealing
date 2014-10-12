package com.puzzles.eggcarton;

import com.problem.NeighbourGenerator;
import com.problem.ObjectiveFunction;
import com.search.State;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public class EggCartonObjectiveFunction implements ObjectiveFunction {

    //TODO CHange to count number of achieved eggs placed minus misplaced ones.

    @Override
    public double evaluate(State state) {
        if (state instanceof EggCartonState) {
            EggCartonState eggCartonState = (EggCartonState) state;
            int numberOfCollisionsAllowed = eggCartonState.getEggsAllowed() - 1;
            ArrayList<Position> eggs = eggCartonState.getEggs();
            int horizontalCollisions, verticalCollisions, diagonalCollisions, invalidPositions;
            int totalDisallowedCollisions = 0;
            for (int i = 0; i < eggs.size(); i++) {
                horizontalCollisions = 0;
                verticalCollisions = 0;
                diagonalCollisions = 0;
                invalidPositions = 0;
                for (int j = i + 1; j < eggs.size(); j++) {
                    if (eggs.get(i).getX() == eggs.get(j).getX()) {
                        horizontalCollisions++;
                    } else if (eggs.get(i).getY() == eggs.get(j).getY()) {
                        verticalCollisions++;
                    } else if (eggs.get(i).getX() + eggs.get(i).getY() == eggs.get(j).getX() + eggs.get(j).getY()) {
                        diagonalCollisions++;
                    } else if (eggs.get(i).getY() - eggs.get(i).getX() == eggs.get(j).getY() - eggs.get(j).getX()) {
                        diagonalCollisions++;
                    }

                    if (eggs.get(i).getY() < 0 || eggs.get(i).getY() >= eggCartonState.getHeight()) {
                        invalidPositions++;
                    }
                    if (eggs.get(i).equals(eggs.get(j))) {
                        invalidPositions++;
                    }
                }
                if (horizontalCollisions > numberOfCollisionsAllowed) {
                    totalDisallowedCollisions += horizontalCollisions - numberOfCollisionsAllowed;
                }
                if (verticalCollisions > numberOfCollisionsAllowed) {
                    totalDisallowedCollisions += verticalCollisions - numberOfCollisionsAllowed;
                }
                if (diagonalCollisions > numberOfCollisionsAllowed) {
                    totalDisallowedCollisions += diagonalCollisions - numberOfCollisionsAllowed;
                }
                totalDisallowedCollisions += invalidPositions;
            }
            if (totalDisallowedCollisions == 0) {
                return 1;
            }
            else {
                double value = Math.exp(-((double)totalDisallowedCollisions/10));
                return value;
            }

        }
        return 0;
    }

}
