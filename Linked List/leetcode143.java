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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = reverseList(slow);
        slow.next = null;
        ListNode pointer = head;
        while (pointer != null && second.next != null){
            ListNode after = pointer.next;
            pointer.next = second;
            second = second.next;
            pointer = pointer.next;
            pointer.next = after;
            pointer = pointer.next;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode after = cur.next;
            cur.next = prev;
            prev = cur;
            cur = after;
        }
        return prev;
    }
}