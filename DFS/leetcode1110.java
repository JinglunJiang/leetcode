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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> delete = new HashSet<>();
        for (int node : to_delete){
            delete.add(node);
        }
        dfs(root, null, delete, result);
        if (!delete.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    public TreeNode dfs(TreeNode node, TreeNode parent, Set<Integer> delete, List<TreeNode> result){
        if (node == null){
            return null;
        }
        node.left = dfs(node.left, node, delete, result);
        node.right = dfs(node.right, node, delete, result);
        if (delete.contains(node.val)){
            if (node.left != null){
                result.add(node.left);
            }
            if (node.right != null){
                result.add(node.right);
            }
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } 
                else{
                    parent.right = null;
                }
            }
            return null;
        }
        return node;
    }
}