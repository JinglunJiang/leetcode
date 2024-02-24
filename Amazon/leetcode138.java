/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


// The reason for keeping a HashMap is to prevent from creating duplicated nodes
class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        if (map.containsKey(head)){
            return map.get(head);
        }
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        Node next = copyRandomList(head.next);
        Node random = copyRandomList(head.random);
        newNode.next = next;
        newNode.random = random;
        return newNode;
    }
}