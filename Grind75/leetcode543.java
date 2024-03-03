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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findLength(root);
        return max;
    }

    public int findLength(TreeNode root){
        if (root == null){
            return -1;
        }
        int left = findLength(root.left) + 1;
        int right = findLength(root.right) + 1;
        max = Math.max(left + right, max);
        return Math.max(left, right);
    }
}