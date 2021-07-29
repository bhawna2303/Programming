// https://leetcode.com/problems/diameter-of-binary-tree/
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
    int maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return maxDiameter;
    }
    
    private int getDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftGain = getDiameter(root.left);
        int rightGain = getDiameter(root.right);
        
        maxDiameter = Math.max(maxDiameter, (leftGain+rightGain));
        
        return 1 + Math.max(leftGain ,rightGain);
    }
}
