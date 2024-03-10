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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<TreeNode>();
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if (start > end){
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> leftTrees = generate(start, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);
            for (TreeNode left : leftTrees){
                for (TreeNode right : rightTrees){
                    TreeNode current = new TreeNode(i);
                    current.left = left;
                    current.right = right;
                    list.add(current);
                }
            }
        }
        return list;
    }
}