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
    public int longestZigZag(TreeNode root) {
        foo(root.left, false, 1);
        foo(root.right, true, 1);
        return max;
    }

    public void foo(TreeNode node, boolean isRight, int counter){
        if (node == null){
            return;
        }
        max = Math.max(max, counter);
        foo(node.left, false, isRight ? counter + 1 : 1);
        foo(node.right, true, !isRight ? counter + 1 : 1);
    }
}