package puzzles.crossing;

import puzzles.common.solver.Configuration;
import puzzles.common.solver.Solver;

import java.util.ArrayList;

public class Crossing {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(("Usage: java Crossing pups wolves"));
        } else {
            int pups = Integer.parseInt(args[0]);
            int wolves = Integer.parseInt(args[1]);
            System.out.println("Pups: " + pups + ", Wolves: " + wolves);

            CrossingConfig initConfig = new CrossingConfig(pups, wolves);

            ArrayList<Configuration> solution = Solver.solver(initConfig);

            if(solution.isEmpty()){
                System.out.println("No solution found!");
            } else {
                for(int i = 0; i < solution.size(); i++){
                    System.out.println("Step " + i + ": " + solution.get(i).toString());
                }
            }
        }
    }
}
