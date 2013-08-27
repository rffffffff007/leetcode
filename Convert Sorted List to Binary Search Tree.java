/**
 * @time: 2013-08-27
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode root = new ListNode(0);
        root.next = head;
        int len = getListLen(head);
        return listToBST(root, len);
    }
    
    private int getListLen(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    private TreeNode listToBST(ListNode root, int len){
        if(len == 0 || root.next == null)
            return null;
        int leftLen = (len - 1) / 2;
        int rightLen = len - 1 - leftLen;
        
        TreeNode left = listToBST(root, leftLen);
        TreeNode node = new TreeNode(root.next.val);
        root.next = root.next.next;
        node.left = left;
        node.right = listToBST(root, rightLen);
        return node;
    }
}