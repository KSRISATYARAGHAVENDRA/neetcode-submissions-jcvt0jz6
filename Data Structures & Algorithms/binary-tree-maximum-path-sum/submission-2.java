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
    Map<TreeNode ,TreeNode> parentMap = new HashMap<>();
    List<TreeNode> nodes = new ArrayList<>();
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        build(root , null);

        for(TreeNode node : nodes){
        int sum = 0;
        pathSum(node , null ,sum);
        }

        return ans;
    }

    void build(TreeNode root ,TreeNode parent)
    {
        if(root == null)
        {
            return;
        }

        parentMap.put(root ,parent);
        nodes.add(root);

        build(root.left ,root);
        build(root.right, root);
    }

    void pathSum(TreeNode node ,TreeNode prev ,int sum)
    {
        if(node == null){
            return;
        }

        sum += node.val;
        ans = Math.max(ans ,sum);

        if(node.left != prev)
        {
            pathSum(node.left ,node ,sum);
        }

        if(node.right != prev)
        {
            pathSum(node.right ,node ,sum);
        }

        TreeNode par = parentMap.get(node);
        if(par != prev)
        {
            pathSum(par ,node ,sum);
        }
    }
}
