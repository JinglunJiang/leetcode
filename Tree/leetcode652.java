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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        dfs(result, root, new HashMap<>());
        return result;
    }

    public String dfs(List<TreeNode> result, TreeNode root, HashMap<String, Integer> map){
        if (root == null){
            return "#";
        }
        String subTree = "left:" + dfs(result, root.left, map) + "," + root.val + "," + "right:" + dfs(result, root.right, map);
        int frequency = map.getOrDefault(subTree, 0);
        if (frequency == 1){
            result.add(root);
        }
        map.put(subTree, map.getOrDefault(subTree, 0) + 1);
        return subTree;
    }
}