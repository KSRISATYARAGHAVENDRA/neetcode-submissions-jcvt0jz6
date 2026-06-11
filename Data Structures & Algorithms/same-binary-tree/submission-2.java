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
    boolean balanced = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> stack = new LinkedList<>();
        
        stack.add(new TreeNode[]{p,q});

        while(!stack.isEmpty()){
            TreeNode[] node = stack.poll();
            TreeNode nodep = node[0];
            TreeNode nodeq = node[1];

            if(nodep == null && nodeq == null){
                continue;
            }
            else if(nodep == null || nodeq == null || nodep.val != nodeq.val){
                return false;
            }
            stack.offer(new TreeNode[]{nodep.left,nodeq.left});
            stack.offer(new TreeNode[]{nodep.right,nodeq.right});
        }
        return true;
    }
}
