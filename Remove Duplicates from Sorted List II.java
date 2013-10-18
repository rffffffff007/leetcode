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

/**
 * @time: 2013-08-31
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode empty = new ListNode(Integer.MIN_VALUE);
        empty.next = head;
        ListNode p = empty;
        ListNode q = empty;
        while(p != null && p.next != null){
            q = p.next;
            while(q.next != null && q.val == q.next.val){
                q = q.next;
            }
            if(q != p.next){
                p.next = q.next;
            } else
                p = p.next;
        }
        
        return empty.next;
    }
}