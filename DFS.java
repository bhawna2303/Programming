/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming;

import Programming.Graph.Edge;
import java.util.*;

/**
 *
 * @author bhkumari
 */
public class DFS {
    
    public void dsftraverseUtil(String u , Map<String, Boolean> visited, Graph graph){
        visited.put(u,true);
        System.out.println(u);
        
        List<Edge> edgesofU = graph.getConnections(u);
        Iterator<Edge> i = edgesofU.listIterator();
        while(i.hasNext()){
            Edge temp = i.next();
            String tempu = temp.getV();
            if(!visited.getOrDefault(tempu, Boolean.FALSE)){
                dsftraverseUtil(tempu, visited, graph);
            }
        }
    }
    
    public void dfsTraverse(String u, Graph graph){
        Map<String, Boolean> visited = new HashMap<>();
        
        dsftraverseUtil(u, visited, graph);
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
        DFS dfs = new DFS();
        dfs.dfsTraverse("S", graph);
    }
    
}
