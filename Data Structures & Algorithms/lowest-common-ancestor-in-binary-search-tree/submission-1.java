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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();

        findpath(pathp, root, p);
        findpath(pathq, root, q);

        int i = 0;
        TreeNode lca = null;
        while(i < pathp.size() && i < pathq.size()){
            if(pathp.get(i) == pathq.get(i)){
                lca = pathp.get(i);
            }
            else{
                break;
            }
            i++;
        }
        return lca;
    }
    boolean findpath(List<TreeNode> path, TreeNode node, TreeNode target){
        if(node == null){
            return false;
        }
        path.add(node);
        if(node.val == target.val){
            return true;
        }
        if(findpath(path, node.left ,target) || findpath(path, node.right, target)){
            return true;
        }
        path.remove(path.size() - 1);

        return false;
    }
}
