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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q = dummy;
        int count = 0;
        while(p.next != null){
            if(count >= n)
                q = q.next;
            p = p.next;
            count++;
        }
        if(q.next != null)
            q.next = q.next.next;
        return dummy.next;
    }
}