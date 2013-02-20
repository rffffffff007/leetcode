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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null){
    		return head;
    	}
        ListNode p1, p2, p3;
        p1 = null;
        p2 = head;
        p3 = head.next;
        while(p3 != null){
        	p2.next = p3.next;
        	p3.next = p2;
        	if(p1 != null){
        		p1.next = p3;
        	}else{
        		head = p3;
        	}
        	p1 = p2;
        	p2 = p2.next;
        	p3 = p2 != null ? p2.next : null;
        }
        return head;
    }
}