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
        ListNode leftDummy = new ListNode();
        ListNode rightDummy = new ListNode();
        
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        ListNode current = head;
        while (current != null){
            if (current.val < x){
                left.next = current;
                left = left.next;
            }
            else{
                right.next = current;
                right = right.next;
            }
            current = current.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}