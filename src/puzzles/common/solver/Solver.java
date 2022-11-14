package puzzles.common.solver;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solver {

    public static ArrayList<Configuration> solver(Configuration start){

        HashMap<Configuration, Configuration> predecessor = new HashMap<>();
        predecessor.put(start, null);

        Queue<Configuration> queue = new LinkedList<>();
        queue.add(start);

        int totalConfig = 0;
        while(!queue.isEmpty() && !queue.peek().isSolution()){
            Configuration currConfig = queue.remove();
            for(Configuration neighbor : currConfig.getNeighbors()){
                totalConfig += 1;
                if(!predecessor.containsKey(neighbor)){
                    predecessor.put(neighbor, currConfig);
                    queue.add(neighbor);
                }
            }
        }

        if(queue.isEmpty()){
            return new ArrayList<>();
        } else {
            ArrayList<Configuration> path = new ArrayList<>();
            path.add(0, queue.peek());
            Configuration config = predecessor.get(queue.peek());
            while(config != null){
                path.add(0, config);
                config = predecessor.get(config);
            }
            System.out.println("Total configs: " + totalConfig);
            System.out.println("Unique configs: " + predecessor.size());
            return path;
        }
    }
}
