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
        if (head == null)
            return null;
        ListNode p = null;
        ListNode q = head;
        int index = 0;
        while (q != null) {
            index++;
            if (index > n) {
                if (p == null) {
                    p = head;
                } else {
                    p = p.next;
                }
            }
            q = q.next;
        }
        if (p == null) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }
        return head;
    }
}