/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode p = head, q = dummyHead;
        RandomListNode pnext, qnext;
        // create clone list.
        while (p != null) {
            q.next = new RandomListNode(p.label);
            p = p.next;
            q = q.next;
        }

        p = head;
        q = dummyHead.next;
        // create connections between the two lists.
        // p.next <-> q.random
        while (p != null) {
            pnext = p.next;
            p.next = q;
            q.random = p;
            p = pnext;
            q = q.next;
        }

        p = head;
        q = dummyHead.next;
        // clone random link.
        while (p != null) {
            q.random = p.random != null ? p.random.next : null;
            qnext = q.next;
            p = qnext != null ? qnext.random : null;
            q.next = p;
            q = qnext;
        }

        // restore original list
        p = head;
        q = dummyHead.next;
        while (p != null) {
            p.next = q.next;
            q.next = q.next != null ? q.next.next : null;
            p = p.next;
            q = q.next;
        }
        return dummyHead.next;
    }
}