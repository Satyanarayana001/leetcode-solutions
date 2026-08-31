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
        ListNode Before = new ListNode(0);
        ListNode After = new ListNode(0);
        ListNode before_curr = Before;
        ListNode after_curr = After;
        while(head != null){
            if(head.val < x){
                before_curr.next = head;
                before_curr = before_curr.next;
            }
            else{
                after_curr.next = head;
                after_curr = after_curr.next;
            }
            head = head.next;
        }
        after_curr.next = null;
        before_curr.next = After.next;
        
        return Before.next;
    }
}