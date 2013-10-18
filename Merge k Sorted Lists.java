/**
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

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null)
                pq.offer(minNode.next);
            p.next = minNode;
            p = p.next;
        }
        return dummy.next;
    }
}