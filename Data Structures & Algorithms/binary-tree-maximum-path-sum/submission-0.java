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
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        
        maxSum(root);

        return ans;
    }
    int maxSum(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftgain = Math.max(0 , maxSum(root.left));
        int rightgain = Math.max(0 , maxSum(root.right));

        ans = Math.max(ans , root.val + leftgain + rightgain);

        return root.val + Math.max(leftgain , rightgain);
    }
}
