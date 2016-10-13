package main.java.algorithms.src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseOrder {
    public int[] findOrder(int numCourses, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> ord = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < edges.length; i++){
            int[] x = edges[i];
            HashSet<Integer> child = ord.get(x[1]);
            if (child == null) {
                child = new HashSet<Integer>();
                ord.put(x[1], child);
            }
            child.add(x[0]);
        }

        // How to detect circle.
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> toVisit = new Stack<Integer>();
        Stack<Integer> order = new Stack<Integer>();

        for (int key = 0; key < numCourses; key++) {
            if (visited.contains(key)) {
                continue;
            }
            toVisit.push(key);
            while (toVisit.size() > 0) {
                int cur = toVisit.peek();
                if (visited.contains(cur)) {
                    toVisit.pop();
                    continue;
                }
                Set<Integer> children = ord.get(cur);
                if (children == null || visited.containsAll(children)) {
                    order.push(cur);
                    visited.add(cur);
                    toVisit.pop();
                } else {
                    for (int x : children) {
                        if (!visited.contains(x)) {
                            toVisit.push(x);
                        }
                    }
                }
                if (toVisit.size() > edges.length) {
                    return new int[0];
                }
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!order.empty()) {
            res[index] = order.pop();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
         int[][] input = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        CourseOrder order = new CourseOrder();
        order.findOrder(8, input);


    }
}