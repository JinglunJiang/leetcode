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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        int count = 0;
        while (current != null){
            list.add(current.val);
            count++;
            current = current.next;
        }
        ListNode dummy2 = new ListNode();
        ListNode pointer = dummy2;
        int steps = k % count;
        for (int i = count - steps; i < count; i++){
            pointer.next = new ListNode(list.get(i));
            pointer = pointer.next;
        }
        for (int i = 0; i < count - steps; i++){
            pointer.next = new ListNode(list.get(i));
            pointer = pointer.next;
        }
        return dummy2.next;
    }
}