
//https://leetcode.com/problems/evaluate-division/
class Solution {
    HashMap<String, ArrayList<Node>> adjListMap = new HashMap();    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //form Graph
        buildGraph(equations, values);
        
        //search in Graph using dfs
        double[] result = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            String a = query.get(0);
            String b = query.get(1);            
            if(!adjListMap.containsKey(a) || !adjListMap.containsKey(b)){
                 result[i++] = -1.0;
                continue;
            }
            if(a.equals(b)){
                result[i++] = 1.0;
                continue;
            }
            result[i++] =  dfs(a, b);
        }
        return result;
    }
    
    //dfs
    private double dfs(String u, String v){
        HashSet<String> visited = new HashSet();
        double ret = 1.0;
        visited.add(u);
        return dfsUtil(u, v, ret, visited);
        
    }
    
    private double dfsUtil(String u, String v, double ret, HashSet<String> visited){
        if(!adjListMap.containsKey(u)){
            return -1.0;
        }
        if(u.equals(v)){
            return ret;
        }        
        for(Node n : adjListMap.get(u)){
            if(!visited.contains(n.val)){
                visited.add(n.val);
                double prod = dfsUtil(n.val, v, ret * n.wt, visited);
                if(prod != -1.0){
                    return prod;
                }
            }                        
        }
        return -1.0;   
        
    }
    
    private void buildGraph(List<List<String>> equations, double[] values){
        int i = 0;
        for(List<String> equation : equations){
            String u = equation.get(0);
            Node v = new Node(equation.get(1), values[i]);
            addEdge(u,v);
            
            String u1 = equation.get(1);
            Node v1 = new Node(equation.get(0), 1/values[i++]);
            addEdge(u1,v1);
        }
    }
    
    private void addEdge(String u, Node v){
        ArrayList<Node> adjListOfu = adjListMap.getOrDefault(u, new ArrayList<Node>());
        adjListOfu.add(v);
        adjListMap.put(u, adjListOfu);
    }
}

class Node{
    String val;
    double wt;
    
    public Node(String v, double wt){
        this.val = v; 
        this.wt = wt;
    }
}
