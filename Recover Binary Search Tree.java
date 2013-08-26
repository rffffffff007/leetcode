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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode node1 = null, node2 = null;
        // last visited node.
        TreeNode lastNode = null;
        // predecessor in inorder traversal.
        TreeNode preNode = null;
        while (root != null) {
            if (root.left == null) {
                // visit root node.
                if (lastNode != null && lastNode.val > root.val) {
                    if (node1 == null) {
                        node1 = lastNode;
                    }
                    node2 = root;
                }
                lastNode = root;

                root = root.right;
            } else {
                // preNode of root is the right-most node of its left sub tree.
                preNode = root.left;
                while (preNode.right != null && preNode.right != root) {
                    preNode = preNode.right;
                }
                if (preNode.right == null) {
                    // thread the tree.
                    preNode.right = root;
                    root = root.left;
                } else {
                    // visit root node.
                    if (lastNode != null && lastNode.val > root.val) {
                        if (node1 == null) {
                            node1 = lastNode;
                        }
                        node2 = root;
                    }
                    lastNode = root;
                    
                    // restore the tree.
                    preNode.right = null;
                    root = root.right;
                }
            }
        }

        if (node1 != null && node2 != null) {
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
    }
}

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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode first = null, second = null;
        TreeNode cur = root, last = null;
        while(cur != null){
            // traverse the tree using threading tree.
            TreeNode pre = findPredecessor(cur);
            if(pre == null || pre.right == cur) {
                // visit cur
                if (last != null && last.val > cur.val) {
                    if(first == null){
                        first = last;
                        second = cur;
                    } else{
                        second = cur;
                    }
                }
                last = cur;
                
                cur = cur.right;
                if (pre != null) {
                    pre.right = null;
                }
            } else {
                pre.right = cur;
                cur = cur.left;
            }
        }
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private TreeNode findPredecessor(TreeNode root){
        if(root == null || root.left == null)
            return null;
        TreeNode p = root.left;
        while(p.right != null && p.right != root){
            p = p.right;
        }
        return p;
    }
}