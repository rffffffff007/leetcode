/**
 * @time: 2013-08-30
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        ListNode node = null;
        if(l1.val < l2.val){
            node = l1;
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node = l2;
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode root = new ListNode(0);
        ListNode tail = root;
        while(l1 != null || l2 != null){
            if (l1 == null) {
                tail.next = l2;
                l2 = null;
            } else if (l2 == null){
                tail.next = l1;
                l1 = null;
            } else {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
        }
        return root.next;
    }
    
}