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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null) return false;
        
        if(p.val != q.val){
            return false;
        }
 
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);

        return left && right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean issub = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) continue;
            if(node.val != subRoot.val){
                stack.push(node.left);
                stack.push(node.right);
                continue;
            }
            else{
                issub = isSameTree(node,subRoot);
                break;
            }
        }
        return issub;
    }
}
