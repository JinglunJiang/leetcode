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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        int count = 1;
        while (count < k){
            slow = slow.next;
            count++;
        }
        ListNode fast = slow;
        ListNode current = head;
        while (fast.next != null){
            current = current.next;
            fast = fast.next;
        }
        int temp = slow.val;
        slow.val = current.val;
        current.val = temp;
        return head;
    }
}