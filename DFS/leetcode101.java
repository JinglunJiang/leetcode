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
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode left, TreeNode right){
        if (right == null && left == null){
            return true;
        }
        if (left == null && right != null){
            return false;
        }
        if (left != null && right == null){
            return false;
        }
        if (left.val == right.val && isEqual(left.left, right.right) && isEqual(left.right, right.left)){
            return true;
        }else{
            return false;
        }
    }
}