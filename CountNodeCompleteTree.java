/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming;

/**
 *
 * @author bhkumari
 */

 
 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class CountNodeCompleteTree {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        
        if(lh == rh){
            int res = (1<<lh) - 1;
            return res;
        }
        else{
           int ress =  countNodes(root.left) + countNodes(root.right) + 1;
            return  ress;
        }
        
    }
    
    public int getLeftHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    } 
    
     public int getRightHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    } 
    
    
}
