class Solution {
    Queue<Integer> queue = new LinkedList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        while (k > 1){
            queue.poll();
            k--;
        }
        return queue.poll();
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        queue.offer(root.val);
        dfs(root.right);
    }
}