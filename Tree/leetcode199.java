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
    int level = 0;
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int current){
        if (root == null){
            return;
        }
        if (current == level){
            result.add(root.val);
            level++;
        }
        dfs(root.right, current + 1);
        dfs(root.left, current + 1);
    }
}