/**
 * @time: 2013-08-30
 * Use a PriorityQueue(a min heap) to solve this. O(n * k * log(k))
 * 
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = Math.max(lists.size(), 1);
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(n,
                new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b) {
                        return a.val - b.val;
                    }
                });


        for (ListNode node : lists)
            if (node != null)
                pq.offer(node);

        ListNode root = null;
        ListNode rootPointer = null;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null)
                pq.offer(minNode.next);
            if (root == null) {
                root = rootPointer = minNode;
            } else {
                rootPointer.next = minNode;
                rootPointer = minNode;
            }
        }
        return root;
    }
}