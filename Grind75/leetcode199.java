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
    List<Integer> result = new ArrayList<>();
    int maxLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        right(root, 1);
        return result;
    }

    public void right(TreeNode root, int level){
        if (root == null){
            return;
        }
        if (maxLevel < level){
            result.add(root.val);
            maxLevel++;
        }
        right(root.right, level + 1);
        right(root.left, level + 1);
    }
}