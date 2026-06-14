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
    int count = 0;
    public int goodNodes(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfs(root,path);
        return count;
    }
    void dfs(TreeNode root, List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        
        int max = Integer.MIN_VALUE;
        
        for(int val: path){
            max = Math.max(max, val);
        }

        if(root.val >= max){
            count++;
        }
        dfs(root.left, path);
        dfs(root.right, path);
        
        path.remove(path.size() - 1);
    }
}
