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
        ListNode p1;
        p1 = head;
        while (p1 != null) {
            if (p1.next != null && p1.val == p1.next.val) {
                p1.next = p1.next.next;
            } else {
                p1 = p1.next;
            }
        }
        return head;
    }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null){
            if(p2.val != p1.val){
                p1.next = p2;
                p1 = p1.next;
            }
            p2 = p2.next;
            p1.next = null;
        }
        return head;
    }
}