package com.puzzles.eggcarton;

import com.problem.NeighbourGenerator;
import com.problem.Problem;
import com.search.State;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public class EggCarton extends Problem {

    public EggCarton(EggCartonState state, EggCartonObjectiveFunction objectiveFunction, EggCartonNeighbourGenerator neighbourGenerator) {
        super(state, objectiveFunction, neighbourGenerator);
    }

}
