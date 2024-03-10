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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy, current = dummy, next = dummy;
        int count = 0;
        while (current.next != null){
            current = current.next;
            count++;
        }
        while (count >= k){
            current = previous.next;
            next = current.next;
            for (int i = 1; i < k; i++){
                current.next = next.next;
                next.next = previous.next;
                previous.next = next;
                next = current.next;
            }
            previous = current;
            count -= k;
        }
        return dummy.next;
    }
}