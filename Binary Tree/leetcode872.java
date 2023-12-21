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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> first = leaves(root1);
        List<TreeNode> second = leaves(root2);
        if (first.size() != second.size()){
            return false;
        }
        for (int i = 0; i < first.size(); i++){
            if (first.get(i).val != second.get(i).val){
                return false;
            }
        }
        return true;
    }

    public List<TreeNode> leaves(TreeNode root){
        if (root.left == null && root.right == null){
            List<TreeNode> result = new ArrayList<>();
            result.add(root);
            return result;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        if (root.left != null) {
            left = leaves(root.left);
        }
        if (root.right != null) {
            right = leaves(root.right);
        }
        List<TreeNode> last = new ArrayList<>(left);
        for (TreeNode node : right){
            last.add(node);
        }
        return last;
    }
}