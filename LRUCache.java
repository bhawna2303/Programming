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
class Entry{
        int value;
        Entry left, right;
        public Entry(int value){
            this.value = value;
            this.left = this.right = null;
        }
    }
public class LRUCache {
        
    private HashMap<Integer, Entry> hm;
    Entry start, end;
    int LRU_SIZE = 4;
    
    public LRUCache(){
        hm = new HashMap<Integer, Entry>();
    }
    
    public int getEntry(int key){
        if(hm.containsKey(key)){
            Entry node = hm.get(key);
            if(start == node){
                return node.value;
            }
            removeNode(node);
            addAtTop(node);
            return node.value;
        }
        else
            return -1;
    }
    
    public void addAtTop(Entry node){
        node.right = start;
        node.left = null;
        if(start != null){
            start.left = node;
        }
        start = node;
        if(end == null){
            end = start;
        }
    }
    
    public void removeNode(Entry node){
        if(node.left != null){
            node.left.right = node.right;
        }
        else{
            start = node.right;
            start.left = null;
        }
        if(node.right != null){
            node.right.left = node.left;
        }
        else{
            end = node.left;
            end.right = null;
        }
    }
    
    public void putEntry(int key, int value){
        if(hm.containsKey(key)){
            Entry node = hm.get(key);
            node.value = value;
            this.removeNode(node);
            this.addAtTop(node);
        }
        else{
            Entry node = new Entry(value);
            if(hm.size() > LRU_SIZE){
                hm.remove(key);
                this.removeNode(end);
                this.addAtTop(node);
            }
            else{
                this.addAtTop(node);
            }
            
            hm.put(key, node);
        }
    }
    
    public static void main(String args[]){
        LRUCache lru = new LRUCache();
        lru.putEntry(2, 2);
        System.out.print(lru.getEntry(2));
    }
    
}
