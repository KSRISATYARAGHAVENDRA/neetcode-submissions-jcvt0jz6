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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String val = Integer.toString(root.val) + ",";
        return val + serialize(root.left) + "," + serialize(root.right);
    }

    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data.length() == 0 || data.charAt(idx) == '#') {
            idx++;
            return null;
        }

        String value = "";
        while(data.charAt(idx) != ',') {
            value += data.charAt(idx);
            idx++;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        idx++;
        node.left = deserialize(data);
        idx++;
        node.right = deserialize(data);

        return node;
    }
}
