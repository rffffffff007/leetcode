/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while(q != null){
            p = p.next;
            q = q.next;
            if(q == null)
                return null;
            q = q.next;
            if(p == q)
                break;
        }
        if(q == null)
            return null;
        p = head;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}