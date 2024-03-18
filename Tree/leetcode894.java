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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0){
            return new ArrayList<>();
        }
        if (n == 1){
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i < n; i += 2){
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(n - i - 1);
            for (TreeNode left : leftNodes){
                for (TreeNode right : rightNodes){
                    TreeNode current = new TreeNode(0);
                    current.left = left;
                    current.right = right;
                    result.add(current);
                }
            }
        }
        return result;
    }
}