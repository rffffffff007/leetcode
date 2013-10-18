/**
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
        int len = length(head);        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        return buildTree(dummy, len);
    }
    
    private TreeNode buildTree(ListNode dummy, int len){
        if(dummy.next == null || len <= 0)
            return null;
        int leftLen = len / 2;
        TreeNode node = new TreeNode(0);
        node.left = buildTree(dummy, leftLen);
        node.val = dummy.next.val;
        dummy.next = dummy.next.next;
        node.right = buildTree(dummy, len - leftLen - 1);
        return node;
    }
    
    private int length(ListNode root){
        int len = 0;
        while(root != null){
            len++;
            root = root.next;
        }
        return len;
    }
}