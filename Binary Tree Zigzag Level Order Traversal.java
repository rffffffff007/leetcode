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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		dfs(root, 0, res);
		for(int i = 0; i < res.size(); i++){
			if(i % 2 != 0)
				Collections.reverse(res.get(i));
		}
		return res;
	}

	public void dfs(TreeNode root, int depth, ArrayList<ArrayList<Integer>> res) {
		if (root == null)
			return;
		ArrayList<Integer> list = null;
		if (depth < res.size()) {
			list = res.get(depth);
		} else {
			list = new ArrayList<Integer>();
			res.add(list);
		}
		list.add(root.val);
		dfs(root.left, depth + 1, res);
		dfs(root.right, depth + 1, res);
	}
}