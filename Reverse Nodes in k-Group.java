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

        // prevNi, ni, ..., nj, nextNj
        ListNode ni = null, nj = head, prevNi = null, nextNj = head, tmp = null;
        for (int i = 1; i < k; i++) {
            if (nj == null) {
                return head;
            }
            nj = nj.next;
        }

        while (nj != null) {
            if (prevNi == null) {
                ni = nextNj;
            } else {
                ni = prevNi.next;
            }
            if (ni == nextNj) {
                nextNj = nj.next;
                nj.next = null;
                reverseList(ni);
                if (prevNi != null) {
                    prevNi.next = nj;
                } else {
                    head = nj;
                }
                ni.next = nextNj;
                tmp = ni;
                ni = nj;
                nj = tmp;
            }

            prevNi = ni;
            nj = nj.next;
        }

        return head;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head, q = head.next, r;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }


}