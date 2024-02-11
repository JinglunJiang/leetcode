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
    public int rob(TreeNode root) {
        int[] result = help(root);
        return Math.max(result[0], result[1]);
    }

    public int[] help(TreeNode root){
        if (root == null){
            return new int[2];
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        int[] current = new int[2];
        current[0] = root.val + left[1] + right[1];
        current[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return current;
    }
}