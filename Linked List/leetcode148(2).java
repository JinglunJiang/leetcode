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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(head2));
    }

    public ListNode merge(ListNode head1, ListNode head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        if (head1.val < head2.val){
            head1.next = merge(head1.next, head2);
            return head1;
        }
        head2.next = merge(head2.next, head1);
        return head2;
    }
}