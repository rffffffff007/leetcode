/**
 * Use no extra space.
 * Time complexity is O(n)
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node;
        TreeLinkNode last = null, curr = null;
        while (root != null) {
            node = root;
            last = null;
            curr = null;
            while (node != null) {
                if (node.left != null && curr != node.left) 
                    curr = node.left;
                else if (node.right != null) 
                    curr = node.right;
                if (last != null) {
                    if (last != curr)
                        last.next = curr;
                } else 
                    root = curr;
                last = curr;
                if (node.right == null || curr == node.right) 
                    node = node.next;
            }
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