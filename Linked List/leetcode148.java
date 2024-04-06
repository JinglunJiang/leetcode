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
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            list.add(current.val);
            current = current.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode();
        current = dummy;
        for (int i = 0; i < list.size(); i++){
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return dummy.next;
    }
}