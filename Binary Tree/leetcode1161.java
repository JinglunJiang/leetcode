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
    public int maxLevelSum(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            if (map.get(sum) == null){
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(level);
            max = Math.max(max, sum);
            level++;
        }
        return map.get(max).get(0);
    }
}