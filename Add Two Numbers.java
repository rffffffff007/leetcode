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
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null || n2 != null) {
            if (n2 != null) 
                n1.val += n2.val;
            if (n1.next == null && (n1.val >= 10 || n2 != null && n2.next != null)) 
                n1.next = new ListNode(0);
            if (n1.next != null) 
                n1.next.val += n1.val / 10;
            n1.val %= 10;
            n1 = n1.next;
            if (n2 != null) 
                n2 = n2.next;
        }
        return l1;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode cur = null, next = null;
        while(l1 != null || l2 != null){
            int val = 0;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            if(cur == null){
                cur = new ListNode(0);
            }
            if(root == null){
                root = cur;
            }
            cur.val += val;
            cur.next = new ListNode(0);
            cur.next.val += cur.val / 10;
            cur.val %= 10;
            if(l1 == null && l2 == null){
                // reach the last node, delete the last 0 node.
                if(cur.next.val == 0)
                    cur.next = null;
            }
            cur = cur.next;
        }
        return root;
    }
}