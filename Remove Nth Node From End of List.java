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
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = head, qPrev = null, q = head;
        int count = 0;
        while(p != null){
            p = p.next;
            if(count >= n){
                qPrev = q;
                q = q.next;
            }
            count++;
        }
        if(qPrev != null){
            qPrev.next = qPrev.next.next;
        } else if(q != null && head != null){
            head = head.next;
        }
        
        return head;
    }
}