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
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode prev = empty;
        while(prev.next != null && prev.next.next != null){
            ListNode p = prev.next;
            ListNode q = p.next;
            p.next = q.next;
            q.next = p;
            prev.next = q;
            prev = p;
        }
        return empty.next;
    }
}