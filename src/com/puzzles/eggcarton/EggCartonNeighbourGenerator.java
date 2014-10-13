package com.puzzles.eggcarton;

import com.problem.NeighbourGenerator;
import com.search.State;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public class EggCartonNeighbourGenerator implements NeighbourGenerator {

    enum Action {
        NORTH, SOUTH;
    }

    @Override
    public ArrayList<State> generateNeighbours(State state) {
        if (state instanceof  EggCartonState){
            EggCartonState currentState = (EggCartonState) state;
            ArrayList<State> neighbours = new ArrayList<State>();
            for (int i = 0; i<currentState.getEggs().size(); i++) {
                for (Action action : Action.values()) {
                    EggCartonState neighbour = new EggCartonState(currentState);
                    if (action.equals(Action.NORTH)) {
                        neighbour.getEggs().get(i).setY(neighbour.getEggs().get(i).getY()+1);
                    } else {
                        neighbour.getEggs().get(i).setY(neighbour.getEggs().get(i).getY()-1);
                    }
                    if (neighbour.getEggs().get(i).getY() >= 0 && neighbour.getEggs().get(i).getY() < neighbour.getHeight()) {
                        neighbours.add(neighbour);
                    }
                }

            }
            return neighbours;
        }
        return null;
    }
}
