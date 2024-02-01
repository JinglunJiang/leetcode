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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (current1 != null && current2 != null){
            if (current1.val < current2.val){
                cur.next = current1;
                cur = cur.next;
                current1 = current1.next;
            }
            else{
                cur.next = current2;
                cur = cur.next;
                current2 = current2.next;
            }
        }
        if (current1 != null){
            cur.next = current1;
        }
        if (current2 != null){
            cur.next = current2;
        }
        return head.next;
    }
}