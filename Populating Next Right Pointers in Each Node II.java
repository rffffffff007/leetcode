public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode node;
        TreeLinkNode last = null, curr = null;
        while (root != null) {
            node = root;
            last = null;
            curr = null;
            while (node != null) {
                if (node.left != null && curr != node.left) {
                    curr = node.left;
                } else if (node.right != null) {
                    curr = node.right;
                }
                if (last != null) {
                    if (last != curr)
                        last.next = curr;
                } else {
                    // root is the left-most node of next row.
                    root = curr;
                }
                last = curr;
                if (node.right == null || curr == node.right) {
                    node = node.next;
                }
            }
        }
    }
}