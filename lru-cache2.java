class LRUCache {
    private Node head = null;
    private Node end = null;
    private HashMap<Integer, Node> map;
    private final int CACHE_SIZE;

    public LRUCache(int capacity) {        
        map = new HashMap();
        this.CACHE_SIZE = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node temp = map.get(key);            
            remove(temp);
            addFirst(temp);
            return temp.value;
        }
        
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size() == this.CACHE_SIZE){
                Node k = end;
                remove(end);
                map.remove(k.key);
            }
            Node t = new Node(key,value);
            addFirst(t);
            map.put(key,t);
        } 
        else{
            Node temp = map.get(key);
            remove(temp);  
            Node tt = new Node(key, value);
            addFirst(tt);
            map.put(key, tt);
        }       
                
    }
    
    private void addFirst(Node node){
        node.prev = null;
        if(head == null){
            head = node;
            end = node;
        }
        else{
            node.next = head;
            head.prev = node;
        }
        
        head = node;
    }
    
    private void remove(Node node){
        Node prev = node.prev;        
        Node next = node.next;
        //node.next = node.prev = null;
        if(prev == null && next == null){
            head = null;
            end = null;
            return;
        }
        if(prev == null){
            head = next;
            next.prev = null;
            return;
        }
        if(next == null){
            prev.next = null;
            end = prev;
            return;
        }        
          prev.next = next;
          next.prev = prev; 
    }
}

class Node{
    int key;
    int value;
    Node prev, next;
    public Node(int k, int v){
        this.key = k;
        this.value = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
