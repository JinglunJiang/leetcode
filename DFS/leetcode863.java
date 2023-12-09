/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        buildGraph(root, null, map);
        dfs(target.val, k, map, visited, result);
        return result;
    }
    public void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> map){
        if (node == null){
            return;
        }
        if (parent != null) {
            map.computeIfAbsent(node.val, key -> new ArrayList<>()).add(parent.val);
            map.computeIfAbsent(parent.val, key -> new ArrayList<>()).add(node.val);
        }
        buildGraph(node.left, node, map);
        buildGraph(node.right, node, map);
    }
    public void dfs(int node, int k, Map<Integer, List<Integer>> map, Set<Integer> visited, List<Integer> result){
        if (visited.contains(node)){
            return;
        }
        visited.add(node);
        if (k == 0){
            result.add(node);
            return;
        }
        List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());
        for (int neighbor : neighbors){
            dfs(neighbor, k - 1, map, visited, result);
        }
    }

}