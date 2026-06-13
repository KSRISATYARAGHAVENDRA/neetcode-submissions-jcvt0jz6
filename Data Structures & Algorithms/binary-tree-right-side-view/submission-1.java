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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        right(res, root,0);
        
        return res;
    }
    void right(List<Integer> res, TreeNode root, int depth){
        if(root == null){
            return ;
        }
        if(depth == res.size()){
            res.add(root.val);
        }
        right(res, root.right, depth + 1);
        right(res, root.left, depth + 1);
    } 

}
