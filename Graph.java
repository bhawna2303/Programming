/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming;

import java.util.*;

/**
 *
 * @author bhkumari
 */
public class Graph {
    private Map<String, List<Edge>> hm;
    
    public static class Edge{
        private String u, v;
        private int distance;

        public String getV() {
            return v;
        }

        public int getDistance() {
            return distance;
        }        
        
        public String getU(){
            return u;
        }

        public Edge(String u, String v, int distance) {
            this.u = u;
            this.v = v;
            this.distance = distance;
        }
        
         public Edge(Edge edge) {
            this.u = edge.u;
            this.v = edge.v;
            this.distance = edge.distance;
        }

        @Override
        public String toString() {
            return "Edge{" + "u=" + u + ", v=" + v + ", distance=" + distance + '}';
        }         
        
    }
    
    public Graph(){
        hm = new HashMap<>();
    }

    public Map<String, List<Edge>> getHm() {
        return hm;
    }
    
    

    @Override
    public String toString() {
        return "Graph{" + "hm=" + hm.toString() + '}';
    }
    
    public void addEdge(Edge edge){
        List<Edge> listOfEdges = hm.get(edge.u);
        if(listOfEdges != null){
            listOfEdges.add(edge);
        }
        else{
            listOfEdges = new ArrayList<Edge>();
            listOfEdges.add(edge);
            hm.put(edge.u, listOfEdges);
        }
    }
    
    public List<Edge> getConnections(String u){
        return hm.get(u);
    }
    
    public static void main(String args[]){
        Graph graph = new Graph();
         graph.addEdge(new Graph.Edge("S", "A", 7));
        graph.addEdge(new Graph.Edge("S", "B", 2));
        graph.addEdge(new Graph.Edge("S", "C", 3));
        graph.addEdge(new Graph.Edge("A", "S", 7));
        graph.addEdge(new Graph.Edge("A", "B", 3));
        graph.addEdge(new Graph.Edge("A", "D", 4));
        graph.addEdge(new Graph.Edge("B", "S", 2));
        graph.addEdge(new Graph.Edge("B", "A", 3));
        graph.addEdge(new Graph.Edge("B", "D", 4));
        graph.addEdge(new Graph.Edge("B", "H", 1));
        graph.addEdge(new Graph.Edge("C", "S", 3));
        graph.addEdge(new Graph.Edge("C", "L", 2));
        graph.addEdge(new Graph.Edge("D", "A", 4));
        graph.addEdge(new Graph.Edge("D", "B", 4));
        graph.addEdge(new Graph.Edge("D", "F", 5));
        graph.addEdge(new Graph.Edge("E", "G", 2));
        graph.addEdge(new Graph.Edge("E", "K", 5));
        graph.addEdge(new Graph.Edge("F", "D", 5));
        graph.addEdge(new Graph.Edge("F", "H", 3));
        graph.addEdge(new Graph.Edge("G", "H", 2));
        graph.addEdge(new Graph.Edge("G", "E", 2));
        graph.addEdge(new Graph.Edge("H", "B", 1));
        graph.addEdge(new Graph.Edge("H", "F", 3));
        graph.addEdge(new Graph.Edge("H", "G", 2));
        graph.addEdge(new Graph.Edge("I", "L", 4));
        graph.addEdge(new Graph.Edge("I", "J", 6));
        graph.addEdge(new Graph.Edge("I", "K", 4));
        graph.addEdge(new Graph.Edge("J", "L", 4));
        graph.addEdge(new Graph.Edge("J", "I", 6));
        graph.addEdge(new Graph.Edge("J", "K", 4));
        graph.addEdge(new Graph.Edge("K", "I", 4));
        graph.addEdge(new Graph.Edge("K", "J", 4));
        graph.addEdge(new Graph.Edge("K", "E", 5));
        graph.addEdge(new Graph.Edge("L", "C", 2));
        graph.addEdge(new Graph.Edge("L", "I", 4));
        graph.addEdge(new Graph.Edge("L", "J", 4));
        System.out.println(graph.toString());
    }
}
