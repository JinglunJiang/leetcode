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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root, 1);
        int maxWidth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                int position = map.get(current);
                if (i == 0){
                    left = position;
                }
                if (i == size - 1){
                    right = position;
                }
                if (current.left != null){
                    queue.offer(current.left);
                    map.put(current.left, 2 * position);
                }
                if (current.right != null){
                    queue.offer(current.right);
                    map.put(current.right, position * 2 + 1);
                }
            }
            maxWidth = Math.max(right - left + 1, maxWidth);
        }
        return maxWidth;
    }
}