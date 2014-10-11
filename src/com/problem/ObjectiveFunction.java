package com.problem;

import com.search.State;

/**
 * Created by Sondre on 11.10.2014.
 */
public interface ObjectiveFunction {

    double evaluate(State state);

}
