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
    Queue<Integer> queue = new LinkedList<>();

    public int kthSmallest(TreeNode root, int k) {
        traversal(root);
        while (k > 1){
            queue.poll();
            k--;
        }
        return queue.poll();
    }

    private void traversal(TreeNode root){
        if (root.left != null){
            traversal(root.left);
        }
        queue.offer(root.val);
        if (root.right != null){
            traversal(root.right);
        }
        return;
    }
}