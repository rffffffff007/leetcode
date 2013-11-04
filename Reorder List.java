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
    public void reorderList(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = seperate(head);
        l2 = reverse(l2);
        interleave(l1, l2);
    }
    
    private ListNode seperate(ListNode head){
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null && q.next.next != null) {
            q = q.next.next;
            p = p.next;
        }
        ListNode l2 = null;
        if(p != null){
            l2 = p.next;
            p.next = null;
        }
        return l2;
    }
    
    private ListNode reverse(ListNode head){
        ListNode p = null;
        ListNode q = head;
        while(q != null){
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        return p;
    }
    
    private ListNode interleave(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(h1 != null || h2 != null){
            if(h1 != null){
                cur.next = h1;
                h1 = h1.next;
                cur = cur.next;
            }
            if(h2 != null){
                cur.next = h2;
                h2 = h2.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}