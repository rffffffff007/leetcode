/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null){
            ListNode q = p.next.next;
            p.next.next = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
        }
        return dummy.next;
    }
}