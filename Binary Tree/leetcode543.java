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
        int result = maxDiameter(root);
        return max;
    }

    public int maxDiameter(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = maxDiameter(root.left);
        if (root.left != null){
            left += 1;
        }
        int right = maxDiameter(root.right);
        if (root.right != null){
            right += 1;
        }
        max = Math.max(left + right, max);
        return Math.max(left, right);
    }
}