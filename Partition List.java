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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode lp = left;
        ListNode rp = right;
        while (head != null) {
            if (head.val < x) {
                lp.next = head;
                lp = lp.next;
            } else {
                rp.next = head;
                rp = rp.next;
            }
            head = head.next;
            lp.next = rp.next = null;
        }
        
        lp.next = right.next;
        return left.next;
    }
}