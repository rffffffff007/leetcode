/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1, n);
    }

    public ArrayList<TreeNode> generateTrees(int start, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (n == 0) {
            res.add(null);
        } else if (n == 1) {
            res.add(new TreeNode(start));
        } else {
            for (int i = start; i < start + n; i++) {
                ArrayList<TreeNode> left = generateTrees(start, i - start);
                ArrayList<TreeNode> right = generateTrees(i + 1, n + start - 1
                        - i);
                for (TreeNode lNode : left) {
                    for (TreeNode rNode : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = lNode;
                        node.right = rNode;
                        res.add(node);
                    }
                }
            }
        }

        return res;
    }
}