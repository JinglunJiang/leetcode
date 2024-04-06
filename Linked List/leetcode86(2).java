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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode pointer1 = dummy1;
        ListNode dummy2 = new ListNode();
        ListNode pointer2 = dummy2;
        ListNode current = head;
        while (current != null){
            if (current.val < x){
                pointer1.next = new ListNode(current.val);
                pointer1 = pointer1.next;
            }
            else{
                pointer2.next = new ListNode(current.val);
                pointer2 = pointer2.next;
            }
            current = current.next;
        }
        pointer1.next = dummy2.next;
        return dummy1.next;
    }
}