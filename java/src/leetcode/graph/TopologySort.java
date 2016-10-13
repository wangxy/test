package main.java.algorithms.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by xwang on 9/12/16.
 */
public class TopologySort {
    private static class Graph {
        int value;
        List<Graph> neighbours;
        Graph(int value) {
            this.value = value;
            this.neighbours = new ArrayList<Graph>();
        }
        public void addNeighbour(Graph g) {
            this.neighbours.add(g);
        }
    }

    public void topSort(Graph g) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        aux (visited, stack, g);
        while (!stack.isEmpty()) {
            System.out.println(stack.poll());
        }
    }

    private void aux(Set<Integer> visited, Deque<Integer> stack, Graph node) {
        visited.add(node.value);
        for (Graph neighbours : node.neighbours) {
            if (visited.contains(neighbours.value)) {
                continue; // no need to
            }
            aux(visited, stack, neighbours);
        }
        stack.offerFirst(node.value);
    }

    public static void main(String[] args) {
        Graph g = new Graph(1);
        Graph x = new Graph(2);
        g.addNeighbour(x);
        x.addNeighbour(new Graph(3));

        TopologySort topsort = new TopologySort();
        topsort.topSort(g);

    }

}
