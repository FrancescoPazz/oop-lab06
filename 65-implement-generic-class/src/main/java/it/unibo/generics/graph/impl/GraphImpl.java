package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

/**
 * @param <N>
 *            node type
 */
public class GraphImpl<N> implements Graph<N> {

    private Set<N> nodes;
    private Map< N, Set<N> > edges;

    public <N> GraphImpl(){
        this.nodes = new LinkedHashSet<>();
        this.edges = new HashMap<>();
    }

    public void addNode(N node){
        if (!nodes.contains(node)){
            nodes.add(node);
        }
    }

    public void addEdge(N source, N target){
        if (edges.containsKey(source)){
            edges.get(source).add(target);
        } else {
            Set<N> edgeNodes = new LinkedHashSet<>();
            edges.put(source, edgeNodes);
            edges.get(source).add(target);
        }
    }

    public Set<N> nodeSet(){
        return this.nodes;
    }

    public Set<N> linkedNodes(N node){
        return this.edges.get(node);
    }

    public List<N> getPath(N source, N target){
        List<N> path = new LinkedList<>();
        boolean OK = true;
        if( this.edges.get(source).contains(target) ){
            for (N n : this.edges.get(source)) {
                if (OK){
                    path.add(n);
                    OK = false;
                }
            }
            return path;
        }
        return null;
    }

}
