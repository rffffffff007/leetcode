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
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || n == 0)
            return head;
        ListNode p, end = null, rp1 = null, rp2 = null;
        p = head;
        int len = 0;
        while(p != null){
            len++;
            if(p.next == null){
                end = p;
            }
            p = p.next;
        }
        if(len == 0){
            return head;
        }
        n %= len;
        n = len - n;
        p = head;
        int k = 1;
        while(rp1 == null){
            if(k++ == n){
                rp1 = p;
                if(p.next != null){
                    rp2 = p.next;
                }else{
                    rp2 = head;
                }
            }
            p = p.next;
        }
        end.next = head;
        rp1.next = null;
        
        return rp2;
    }
}