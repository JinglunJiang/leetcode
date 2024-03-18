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
    List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        traversal(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) - list.get(i - 1) < min){
                min = list.get(i) - list.get(i - 1);
            }
        }
        return min;
    }

    public void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}