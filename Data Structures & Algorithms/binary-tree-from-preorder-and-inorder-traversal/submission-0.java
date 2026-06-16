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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return subtreeBuild(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }
    TreeNode subtreeBuild(int[] preorder, int[] indorder,
    int pStart, int pEnd, int iStart, int iEnd){
        
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);

        int idx = iStart;

        while(indorder[idx] != root.val){
            idx++;
        }

        int leftSize = idx - iStart;

        root.left = subtreeBuild(preorder, indorder,
                                 pStart + 1, pStart + leftSize,
                                 iStart, idx - 1);
        root.right = subtreeBuild(preorder, indorder,
                                  pStart + leftSize + 1, pEnd,
                                  idx + 1, iEnd);
        return root;
    }
}
