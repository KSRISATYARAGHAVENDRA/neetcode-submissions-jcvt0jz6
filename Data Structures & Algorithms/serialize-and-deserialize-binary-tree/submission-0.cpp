/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Codec {
public:
    int idx = 0;
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (root == nullptr) {
            return "#";
        }
        string val = to_string(root->val) + ",";
        return val + serialize(root->left) + "," + serialize(root->right);  
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data.length() == 0 or data[idx] == '#') {
            idx++;
            return nullptr;
        }

        string value;
        while(data[idx] != ',') {
            value += data[idx];
            idx++;
        }
        TreeNode* node = new TreeNode(stoi(value));
        idx++;
        node->left = deserialize(data);
        idx++;
        node->right = deserialize(data);

        return node;
    }
};
