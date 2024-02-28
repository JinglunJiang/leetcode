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
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        traversal(root);
        while (k > 1){
            queue.poll();
            k--;
        }
        return queue.peek();
    }

    public void traversal(TreeNode node){
        if (node == null){
            return;
        }
        queue.offer(node.val);
        traversal(node.left);
        traversal(node.right);
    }
}