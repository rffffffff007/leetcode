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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode mp = head;
        ListNode mpPrev = null;
        for(int i = 1; i < m; i++){
            mpPrev = mp;
            mp = mp.next;
        }
        mp = reverse(mp, n - m + 1);
        if(mpPrev != null){
            mpPrev.next = mp;
            return head;
        } else {
            return mp;
        }
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