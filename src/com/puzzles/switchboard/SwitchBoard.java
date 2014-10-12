package com.puzzles.switchboard;

import com.problem.Problem;

/**
 * Created by Sondre on 11.10.2014.
 */
public class SwitchBoard extends Problem {

    public SwitchBoard(SwitchBoardState state, SwitchBoardObjectiveFunction objectiveFunction, SwitchBoardNeighbourGenerator neighbourGenerator) {
        super(state, objectiveFunction, neighbourGenerator);
    }

}
