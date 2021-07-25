/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList();        
        TreeNode rootTemp = root;
        //result.add(root.val);
        leftNodes(rootTemp, result);
        leafNodes(rootTemp.left, result);
        leafNodes(rootTemp.right, result);
        rightNodes(rootTemp, result);
        return result;
    }
    
    private void leftNodes(TreeNode rootTemp, List<Integer> result){
        if(rootTemp == null){
            return;
        }
        if(rootTemp.left == null){
            result.add(rootTemp.val);
            return;
        }
        while(rootTemp != null){
            if(rootTemp.left != null || rootTemp.right != null){
                result.add(rootTemp.val);
            }
            if(rootTemp.left != null){
               rootTemp = rootTemp.left; 
            }
            else{
                rootTemp = rootTemp.right;
            }
        }
    }
    
    private void leafNodes(TreeNode rootTemp, List<Integer> result){  
        if(rootTemp == null){
            return;
        }
         if(rootTemp.left != null){
             leafNodes(rootTemp.left, result);
         }
         if(rootTemp.left == null && rootTemp.right == null){
                result.add(rootTemp.val);
        }
        if(rootTemp.right != null){
             leafNodes(rootTemp.right, result);
         }
    }
    
    private void rightNodes(TreeNode rootTemp, List<Integer> result){
        if(rootTemp == null){
            return;
        }
        Stack<Integer> st = new Stack();
        if(rootTemp.right !=null){
            rootTemp = rootTemp.right;
            
        }
        else{
            return;
        }
        
        while(rootTemp != null){
            if(rootTemp.left != null || rootTemp.right != null){
                st.add(rootTemp.val);
            }
            if(rootTemp.right != null){
               rootTemp = rootTemp.right; 
            }
            else{
                rootTemp = rootTemp.left;
            }
        }
        
        while(!st.isEmpty()){
            result.add(st.pop());
        }
    }
}
