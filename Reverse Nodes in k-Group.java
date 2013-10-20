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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = listLen(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 0; i < len / k; i++){
            ListNode q = reverse(p.next, k);
            ListNode next = p.next;
            p.next = q;
            p = next;
        }
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