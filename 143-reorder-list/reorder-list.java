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
        // split into 2 halves
        // 1 -> 2
        // 3 -> 4
        // reverse 3 -> 4
        // now walk through both merging them
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode first = head;

        ListNode prev = null;
        ListNode ptr = second;
        ListNode next = null;

        while(second != null) {
            next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        second = prev;

        ListNode res = first;
        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;
            first.next = second;
            second.next = next1;
            first = next1;
            second = next2;
        }

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}