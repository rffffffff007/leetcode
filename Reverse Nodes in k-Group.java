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
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = 0;
        ListNode p = head;
        while(p != null){
            len++;
            p = p.next;
        }
        p = head;
        ListNode tail = null;
        for(int i = 0; i < len / k; i++){
            ListNode start = reverse(p, k);
            if(i == 0)
                head = start;
            if(tail != null)
                tail.next = start;
            tail = p;
            p = p.next;
        }
        return head;
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