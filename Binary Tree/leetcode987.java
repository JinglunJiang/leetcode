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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(result, (a, b) -> 
            (a.get(2) == b.get(2)) ? ((a.get(1) == b.get(1)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1)) : a.get(2) - b.get(2)
        );
        List<List<Integer>> finalResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++){
            if (i == 0 || result.get(i).get(2) != result.get(i - 1).get(2)){
                List<Integer> list = new ArrayList<>();
                finalResult.add(list);
            }
            finalResult.get(finalResult.size() - 1).add(result.get(i).get(0));
        }
        return finalResult;
    }

    public void dfs(TreeNode root, int i, int j){
        if (root == null){
            return;
        }
        dfs(root.left, i + 1, j - 1);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.add(i);
        list.add(j);
        result.add(list);
        dfs(root.right, i + 1, j + 1);
    }
}