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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode root = null, p = null;
        ListNode min;
        while(l1 != null || l2 != null){
            if(l1 == null){
                min = l2;
                l2 = l2.next;
            }else if(l2 == null){
                min = l1;
                l1 = l1.next;
            }else if(l1.val < l2.val){
                min = l1;
                l1 = l1.next;
            }else {
                min = l2;
                l2 = l2.next;
            }
            if(root == null){
                root = p = min;
            }else{
                p.next = min;
                p = p.next;
            }
        }
        return root;
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