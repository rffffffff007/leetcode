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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode root = null;
        ListNode res = null;
        ListNode min = null;
        int mini = 0;
        boolean allNull = false;
        while(!allNull){
            allNull = true;
            min = null;
            for(int i = 0; i < lists.size(); i++){
                ListNode node = lists.get(i);
                if(node != null){
                    allNull = false;
                    if(min == null || node.val < min.val){
                        min = node;
                        mini = i;
                    }
                }
            }
            if(min != null){
                lists.set(mini, min.next);
            }
            if(res == null){
                root = res = min;
            }else{
                res.next = min;
                res = res.next;
            }
        }
        return root;
    }
}