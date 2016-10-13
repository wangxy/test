package main.java.algorithms.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseCanFinish {
    public boolean canFinish(int numCourses, int[][] dep) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < dep.length; i++) {
            int[] x = dep[i];
            if (!graph.containsKey(x[0])) {
                graph.put(x[0], new ArrayList<Integer>(x[1]));
            }
            graph.get(x[0]).add(x[1]);
        }

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!aux(graph, stack, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean aux(Map<Integer, List<Integer>> graph, Deque<Integer> stack, int i) {
        if (stack.contains(i)) {
            return false;
        }
        if (!graph.containsKey(i)) {
            return true;
        }
        stack.offerLast(i);
        for (Integer x: graph.get(i)) {
            if (!aux(graph, stack, x)) {
                return false;
            }
        }
        stack.pollLast();
        return true;
    }

    public static void main(String[] args) {
        CourseCanFinish cc = new CourseCanFinish();
        System.out.println(cc.canFinish(10, new int[][]{{1, 0}, {0, 2}, {2, 1}}));


    }

}