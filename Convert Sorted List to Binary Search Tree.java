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
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null)
            return null;
        ListNode preP = null;
        ListNode p = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            preP = p;
            p = p.next;
            p2 = p2.next.next;
        }
        ListNode left = head;
        if (preP != null) {
            preP.next = null;
        }
        ListNode right = p.next;

        TreeNode node = new TreeNode(p.val);
        if (preP != null) {
            node.left = sortedListToBST(left);
        }
        node.right = sortedListToBST(right);
        return node;
    }
}

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
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = 0;
        ListNode p = head;
        while(p != null){
            n++;
            p = p.next;
        }
        TreeNode node = new TreeNode(0);
        buildBst(head, n, node, true);
        return node.left;
    }
    
    private ListNode buildBst(ListNode head, int n, TreeNode root, boolean left){
        if(head == null || n == 0){
            return head;
        }
        TreeNode next = new TreeNode(0);
        if(left){
            root.left = next;
        }else{
            root.right = next;
        }
        head = buildBst(head, n / 2, next, true);
        next.val = head.val;
        head = head.next;
        head = buildBst(head, (n - 1) / 2, next, false);
        return head;
    }
}