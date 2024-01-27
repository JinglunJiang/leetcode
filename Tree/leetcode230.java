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
        traverse(root);
        int size = queue.size();
        for (int i = 1; i < k; i++){
            queue.poll();
        }
        return queue.poll();
    }

    public void traverse(TreeNode root){
        if (root != null){
            queue.offer(root.val);
        }
        if (root.left != null){
            traverse(root.left);
        }
        if (root.right != null){
            traverse(root.right);
        }
    }
}