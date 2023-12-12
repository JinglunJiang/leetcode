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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, null, low, high);
    }

    public TreeNode dfs(TreeNode root, TreeNode parent, int low, int high){
        if (root == null){
            return null;
        }
        root.left = dfs(root.left, root, low, high);
        root.right = dfs(root.right, root, low, high);
        if (root.val < low){
            if (parent != null){
                parent.left = root.right;
                root = null;
                return parent.left;
            }
            else{
                root = root.right;
            }
        }
        if (root.val > high){
            if (parent != null){
                parent.right = root.left;
                root = null;
                return parent.right;
            }
            else{
                root = root.left;
            }
        }
        return root;
    }
}