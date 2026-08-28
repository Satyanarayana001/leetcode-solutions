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
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {

            ListNode next = curr.next;
            ListNode remaining = next.next;

            next.next = curr;
            curr.next = remaining;
            prev.next = next;

            prev = curr;
            curr = remaining;
        }

        return dummy.next;
    }
}