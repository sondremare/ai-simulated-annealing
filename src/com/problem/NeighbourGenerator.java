package com.problem;

import com.search.State;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public interface NeighbourGenerator {

    public ArrayList<State> generateNeighbours(State state);
}
