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

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mp = new HashMap<>();
        mp.put(null, null);
        Node curr = head;
        while(curr != null) {
            if(!mp.containsKey(curr))
                mp.put(curr, new Node(0));
            mp.get(curr).val = curr.val;

            if(!mp.containsKey(curr.next))
                mp.put(curr.next, new Node(0));
            mp.get(curr).next = mp.get(curr.next);
            
            if(!mp.containsKey(curr.random))
                mp.put(curr.random, new Node(0));
            mp.get(curr).random = mp.get(curr.random);
            curr = curr.next;
        }
        return mp.get(head);
    }
}