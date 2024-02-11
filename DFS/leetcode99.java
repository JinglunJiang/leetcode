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
    List<TreeNode> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        traversal(root);
        int count = 0;
        TreeNode a = null;
        TreeNode b = null;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i - 1).val > list.get(i).val){
                if (count == 1){
                    b = list.get(i);
                    break;
                }
                a = list.get(i - 1);
                b = list.get(i);
                count++;
            }
        }
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        list.add(root);
        traversal(root.right);
    }
}