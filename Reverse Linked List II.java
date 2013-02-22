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
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode mNode = null;
		ListNode mNodePrev = null;
		ListNode nNode = head;
		ListNode nNodeNext = null;

		for (int i = 0; i < n - m; i++) {
			nNode = nNode.next;
		}

		for (int i = 1; i < m; i++) {
			nNode = nNode.next;
			if (mNodePrev == null)
				mNodePrev = head;
			else
				mNodePrev = mNodePrev.next;
		}

		if (mNodePrev == null) {
			mNode = head;
		} else {
			mNode = mNodePrev.next;
		}
		nNodeNext = nNode.next;
		nNode.next = null;

		reverseList(mNode);
		if (mNodePrev != null) {
			mNodePrev.next = nNode;
		} else {
			head = nNode;
		}
		mNode.next = nNodeNext;

		return head;
	}

	private void reverseList(ListNode head) {
		if (head == null)
			return;
		ListNode p = head, q = head.next, r;
		while (q != null) {
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
	}
}