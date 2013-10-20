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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = listLen(head);
        n %= len;
        ListNode p = dummy, q = dummy;
        int i = 0;
        while(q.next != null){
            if(i >= n)
                p = p.next;
            q = q.next;
            i++;
        }
        q.next = dummy.next;
        dummy.next = p.next;
        p.next = null;
        return dummy.next;
    }
    
    private int listLen(ListNode p){
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        return len;
    }
}