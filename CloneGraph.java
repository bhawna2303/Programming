/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming;

import java.util.*;

/**
 *
 * @author bhkumari
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        
        HashMap<Node, Node> map = new HashMap();
        if(node == null){
            return null;
        }
        
        queue.add(node);
        visited.add(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            Node clonedTemp = map.get(temp);
            List<Node> neighbors = clonedTemp.neighbors;
            for(Node item : temp.neighbors){
                if(!visited.contains(item)){
                    visited.add(item);
                    queue.add(item);
                    Node cloneItem = new Node(item.val); 
                    map.put(item, cloneItem);   
                    neighbors.add(cloneItem);
                }
                else{
                    neighbors.add(map.get(item));
                }
                
            }
            
        }
        return map.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
