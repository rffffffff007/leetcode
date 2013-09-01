/**
 * @time: 2013-08-31
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
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return null;
        ListNode p = head, q = head, end;
        int len = 0;
        while(p != null){
            len++;
            end = p;
            p = p.next;
        }
        n %= len;
        int count = 0;
        p = head;
        q = null;
        while(p != null){
            if(count >= n){
                if(q == null)
                    q = head;
                else
                    q = q.next;
            }
            count++;
            p = p.next;
        }
        
        ListNode tail = q.next;
        q.next = null;
        if(tail == null)
            return head;
        else{
            end.next = head;
            return tail;
        }
    }
}