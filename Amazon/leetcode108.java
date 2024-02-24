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
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length);
    }

    public TreeNode toBST(int[] nums, int i, int j){
        if (i >= j){
            return null;
        }
        int mid = i + (j - i) / 2;
        TreeNode left = toBST(nums, i, mid);
        TreeNode right = toBST(nums, mid + 1, j);
        TreeNode current = new TreeNode(nums[mid]);
        current.left = left;
        current.right = right;
        return current;
    }
}