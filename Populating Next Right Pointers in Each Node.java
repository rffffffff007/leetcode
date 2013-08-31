/**
 * Use no extra space.
 * Time complexity is O(n)
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode node = null;
        TreeLinkNode last = null, curr = null;
        TreeLinkNode rowHead = root;

        while (node != null || rowHead != null) {
            if (node == null) {
                // go to next level.
                node = rowHead;
                last = null;
                curr = null;
                rowHead = null;
            }
            if (node.left != null && curr != node.left) {
                curr = node.left;
            } else if (node.right != null) {
                curr = node.right;
            }
            if (last != null && last != curr)
                last.next = curr;
            last = curr;
            if (rowHead == null)
                rowHead = curr;
            if (node.right == null || node.right == curr)
                node = node.next;
        }
    }
}

/**
 * @time: 2013-08-31
 * Use a queue to do bfs. 
 * Time complexity and space complexity are both O(n)
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int leftCount = 1;
        TreeLinkNode last = null;
        while(!queue.isEmpty()){
            if(leftCount == 0){
                leftCount = queue.size();
                last = null;
            }
            TreeLinkNode node = queue.poll();
            leftCount--;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
            if(last != null)
                last.next = node;
            last = node;
        }
    }
}