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
    public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode llist = null, lp = null;
		ListNode rlist = null, rp = null;

		while (head != null) {
			if (head.val < x) {
				if (llist == null) {
					lp = llist = head;
				} else {
					lp.next = head;
					lp = lp.next;
				}
				head = head.next;
				lp.next = null;
			} else {
				if (rlist == null) {
					rp = rlist = head;
				} else {
					rp.next = head;
					rp = rp.next;
				}
				head = head.next;
				rp.next = null;
			}
		}
		if (lp != null) {
			lp.next = rlist;
			return llist;
		} else {
			return rlist;
		}
	}
}