package main.java.algorithms.src;

import main.java.algorithms.graph.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // memorize which has been cloned
        // be able to lookup graph node
        Map<Integer, UndirectedGraphNode> nodeLookup = new HashMap<Integer, UndirectedGraphNode>();
        Deque<UndirectedGraphNode> toVisit = new ArrayDeque<UndirectedGraphNode>();
        Set<Integer> visited = new HashSet<Integer>();
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
        // clone neighbor
        for (UndirectedGraphNode n : node.neighbours) {
            UndirectedGraphNode x = new UndirectedGraphNode(n.label);
            toVisit.add(n); // remember which one to visit
            nodeLookup.put(n.label, x);
            newRoot.neighbours.add(x);
        }
        visited.add(newRoot.label);

        while (toVisit.size() > 0) {
            UndirectedGraphNode next = toVisit.pop();
            UndirectedGraphNode cloned = nodeLookup.get(next.label);

            for (UndirectedGraphNode n : next.neighbours) {
                // check whether we have already created an object for it.

            }


        }

        return null;
    }
}