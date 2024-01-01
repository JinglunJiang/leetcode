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
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0){
            count++;
        }
        return count;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 2 && right == 2){
            return 0;
        }
        if (left == 0 || right == 0){
            count++;
            return 1;
        }
        return 2;
    }
}