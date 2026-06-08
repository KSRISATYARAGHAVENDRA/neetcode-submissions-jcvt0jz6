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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Stack<TreeNode> nodestack = new Stack<>();
        Stack<Integer> depthstack = new Stack<>();

        nodestack.push(root);
        depthstack.push(1);

        int maxdepth = 0;

        while(!nodestack.isEmpty()){
            TreeNode node = nodestack.pop();
            int depth = depthstack.pop();

            maxdepth = Math.max(depth, maxdepth);

            if(node.left != null){
                nodestack.push(node.left); 
                depthstack.push(depth + 1);
            }
            if(node.right != null){
                nodestack.push(node.right);
                depthstack.push(depth + 1);
            }
        }
        return maxdepth;
    }
}
