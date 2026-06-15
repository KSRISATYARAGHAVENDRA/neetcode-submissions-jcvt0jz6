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
    int kthsmallest = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return kthsmallest;
    }
    int dfs(TreeNode node, int k){
        if(kthsmallest != 0) return 0;
        if(node == null){
            return 0;
        }
        dfs(node.left, k);

        count++;

        if(count == k){
            kthsmallest = node.val;
        }

        return dfs(node.right, k);
    }
}
