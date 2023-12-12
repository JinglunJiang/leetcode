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
        return sort(nums, 0, nums.length);
    }
    public TreeNode sort(int[] nums, int start, int end){
        if (start >= end){
            return null;
        }
        int index = (start + end) / 2;
        TreeNode current = new TreeNode(nums[index]);
        current.left = sort(nums, start, index);
        current.right = sort(nums, index + 1, end);
        return current;
    }
}