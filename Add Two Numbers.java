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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode n1 = l1;
		ListNode n2 = l2;
		while (n1 != null || n2 != null) {
			if (n2 != null) {
				n1.val += n2.val;
			}
			if (n1.next == null && (n1.val >= 10 || n2 != null && n2.next != null)) {
				n1.next = new ListNode(0);
			}
			if (n1.next != null) {
				n1.next.val += n1.val / 10;
			}
			n1.val %= 10;
			n1 = n1.next;
			if (n2 != null) {
				n2 = n2.next;
			}
		}
		return l1;
	}
}