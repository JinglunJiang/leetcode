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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int value = carry;
            if (l1 != null){
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                value += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(value % 10);
            carry = value / 10;
            current = current.next;
        }
        if (carry != 0){
            current.next = new ListNode(1);
        }
        return dummy.next;
    }
}