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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode current = head.next;
        ListNode previous = head;
        while (current != null){
            if (current.val == previous.val){
                previous.next = current.next;
                current = current.next;
            }else{
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}