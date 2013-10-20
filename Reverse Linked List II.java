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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 1; i < m; i++)
            p = p.next;
        
        p.next = reverse(p.next, n - m + 1);
        return dummy.next; 
    }
    
    private ListNode reverse(ListNode head, int n){
        ListNode node = head, prev = null, next = null;
        for(int i = 0; i < n; i++){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = node;
        return prev;
    }
}