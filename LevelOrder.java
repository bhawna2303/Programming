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
/* Class to represent Tree node */
class BinaryTreeNode { 
    int data; 
    BinaryTreeNode left, right; 
  
    public BinaryTreeNode(int item) { 
        data = item; 
        left = null; 
        right = null; 
    } 
    public int ToString(BinaryTreeNode node){
        return node.data;
    }
} 

/* Class to print Level Order Traversal */
public class LevelOrder {
    
    public static ArrayList<ArrayList<BinaryTreeNode>> levelOrder(BinaryTreeNode root){
        if(root == null){
            return null;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        
        ArrayList<ArrayList<BinaryTreeNode>> result = new ArrayList<>();
        ArrayList<BinaryTreeNode> levelRes = new ArrayList<>();
        
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();            
            if(tmp != null){
                levelRes.add(tmp);
                if(tmp.left != null){
                    q.offer(tmp.left);
                }
                 if(tmp.right != null){
                    q.offer(tmp.right);
                }
            }
            else{
                if(levelRes.size() == 0){
                    break;
                }
                ArrayList<BinaryTreeNode> cloneLevelRes = levelRes;
                result.add(cloneLevelRes);
                levelRes = new ArrayList<BinaryTreeNode>();
                q.add(null);
            }
        }
        return result;
        
    }
    
    public static void main(String args[]){
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left= new BinaryTreeNode(2);
        root.right= new BinaryTreeNode(3);
        root.left.left= new BinaryTreeNode(4);
        root.left.right= new BinaryTreeNode(5);
        root.right.left= new BinaryTreeNode(6);
        root.right.right= new BinaryTreeNode(7);
        System.out.println(Arrays.toString(levelOrder(root).toArray()));
    }
}
