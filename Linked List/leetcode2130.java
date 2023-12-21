/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current.next != null){
            list.add(current.val);
            current = current.next;
        }
        list.add(current.val);
        int max = 0;
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            int val = list.get(i) + list.get(j);
            max = Math.max(val, max);
            i++;
            j--;
        }
        return max;
    }
}