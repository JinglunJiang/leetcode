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
    int m;
    public int kthSmallest(TreeNode root, int k) {
        m = k;
        dfs(root);
        while (k > 1){
            queue.poll();
            k--;
        }
        return queue.peek();
    }

    private void dfs(TreeNode root){
        if (root.left != null){
            dfs(root.left);
        }
        queue.offer(root.val);
        if (queue.size() == m){
            return;
        }
        if (root.right != null){
            dfs(root.right);
        }
    }
}