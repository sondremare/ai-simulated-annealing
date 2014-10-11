package com.search;

/**
 * Created by Sondre on 11.10.2014.
 */
public class SimulatedAnnealing {

    State state;
    double temperature;
    final static double T_MAX = 100.0;


    public SimulatedAnnealing() {

    }

    public void search() {
        State initialState = new State();
        temperature = T_MAX;

    }
}
