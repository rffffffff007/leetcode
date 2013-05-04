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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur = head, pre = null;
        ListNode duplicate = null;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                duplicate = cur;
                cur.next = cur.next.next;
            } else if (duplicate != null && cur.val == duplicate.val) {
                cur = cur.next;
                if (pre != null) {
                    pre.next = cur;
                } else {
                    head = cur;
                }
            } else {
                duplicate = null;
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}