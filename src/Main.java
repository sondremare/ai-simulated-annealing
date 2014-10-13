import com.problem.Problem;
import com.puzzles.eggcarton.EggCarton;
import com.puzzles.eggcarton.EggCartonNeighbourGenerator;
import com.puzzles.eggcarton.EggCartonObjectiveFunction;
import com.puzzles.eggcarton.EggCartonState;
import com.search.SimulatedAnnealing;
import com.search.State;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        EggCartonState state = new EggCartonState(10, 10, 3);
        EggCartonNeighbourGenerator neighbourGenerator = new EggCartonNeighbourGenerator();
        EggCartonObjectiveFunction objectiveFunction = new EggCartonObjectiveFunction();
        Problem problem = new Problem(state, objectiveFunction, neighbourGenerator);
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(problem);
        EggCartonState state2 = (EggCartonState) simulatedAnnealing.search();
        System.out.println("WINNING");
        System.out.println(state2.toString());
        System.out.println(state2.getEggs());
        double test = objectiveFunction.evaluate(state2);
        System.out.println(test);
    }
}
