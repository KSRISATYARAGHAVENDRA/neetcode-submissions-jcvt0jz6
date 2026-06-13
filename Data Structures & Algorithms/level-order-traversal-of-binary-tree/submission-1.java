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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        depth(root,0);

        return res;    
    }
    void depth(TreeNode node, int depth){
        if(node == null){
            return;
        }
        if(res.size() == depth){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        depth(node.left, depth + 1);
        depth(node.right, depth + 1);
    }
}
