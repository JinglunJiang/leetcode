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
    int num = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return num;
    }

    public void helper(TreeNode root){
        if (root == null){
            return;
        }
        helper(root.left);
        count--;
        if (count == 0){
            num = root.val;
            return;
        }
        helper(root.right);
    }
}