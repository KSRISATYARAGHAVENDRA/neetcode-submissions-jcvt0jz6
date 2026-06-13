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
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root);
        return count;
    }

    void dfs(TreeNode root,TreeNode curr){
        if(curr == null){
            return;
        }

        if(good(root, curr, Integer.MIN_VALUE)){
            count++;
        }
        dfs(root, curr.left);
        dfs(root, curr.right);
    }
    boolean good(TreeNode root, TreeNode target,int max){
        if(root == null){
            return false;
        }

        max = Math.max(root.val,max);
        
        if(target == root){
            return target.val >= max;
        }

        return good(root.left, target, max) || good(root.right, target, max);
    }

}
