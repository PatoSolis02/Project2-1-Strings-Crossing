package puzzles.strings;

import puzzles.common.solver.Configuration;
import puzzles.common.solver.Solver;

import java.util.ArrayList;
import java.util.Optional;

public class Strings {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(("Usage: java Strings start finish"));
        } else {
            // TODO
            String start = args[0];
            String end = args[1];
            System.out.println("Start: " + start + ", End: " + end);

            StringsConfig initConfig = new StringsConfig(start, end);

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
