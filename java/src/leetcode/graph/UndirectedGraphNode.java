package main.java.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwang on 5/5/16.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbours = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label){
        this.label = label;
    }
}
