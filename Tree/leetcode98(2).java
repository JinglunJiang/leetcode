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
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        return isValid(root.left, Long.MIN_VALUE, root.val) && isValid(root.right, root.val, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val >= max || root.val <= min){
            return false;
        }
        return isValid(root.left, min, Math.min(max, root.val)) && isValid(root.right, Math.max(root.val, min), max);
    }
}