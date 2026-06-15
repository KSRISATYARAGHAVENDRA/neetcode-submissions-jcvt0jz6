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
    int cur = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return cur;
    }
    int dfs(TreeNode node, int k){
        if(node == null){
            return 0;
        }
        dfs(node.left, k);

        count++;

        if(count == k){
            cur = node.val;
        }

        return dfs(node.right, k);
    }
}
