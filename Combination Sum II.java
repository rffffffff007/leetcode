import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
            int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = candidates.length;
        Node[][] nodes = new Node[n][target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < target + 1; j++) {
                nodes[i][j] = new Node(i, j);
                // 0-1 package problem.
                // nodes[i][j] = nodes[i - 1][j] + nodes[i][j - candidates[i]];
                if (notEmpty(i - 1, j, nodes)) {
                    nodes[i][j].addPair(i - 1, j, false);
                }
                if (notEmpty(i - 1, j - candidates[i], nodes)) {
                    nodes[i][j].addPair(i - 1, j - candidates[i], true);
                }
            }
        }

        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(candidates, nodes, nodes[n - 1][target], set, list);
        res.addAll(set);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int lena = a.size();
                int lenb = b.size();
                int n = Math.max(lena, lenb);
                for (int i = 0; i < n; i++) {
                    if (i >= lena || i >= lenb) {
                        return lena - lenb;
                    }
                    if (a.get(i) != b.get(i))
                        return a.get(i) - b.get(i);
                }
                return 0;
            }

        });
        return res;
    }

    private void dfs(int[] c, Node[][] nodes, Node root,
            Set<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if (root == null || root.j == 0) {
            if (list.size() > 0) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.addAll(list);
                Collections.reverse(l);
                res.add(l);
            }
            return;
        }

        for (Pair p : root.list) {
            Node node = null;
            if (p.x >= 0 && p.y >= 0)
                node = nodes[p.x][p.y];
            if (p.self) {
                list.add(c[root.i]);
            }
            dfs(c, nodes, node, res, list);
            if (p.self) {
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean notEmpty(int i, int j, Node[][] nodes) {
        if (j == 0)
            return true;
        boolean valid = i >= 0 && i < nodes.length && j >= 0
                && j < nodes[i].length;
        return valid && nodes[i][j].notEmpty();
    }

    class Node {
        List<Pair> list;
        int i;
        int j;

        public void addPair(int i, int j, boolean self) {
            list.add(new Pair(i, j, self));
        }

        public boolean notEmpty() {
            return list.size() > 0;
        }

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
            list = new ArrayList<Pair>();
        }
    }

    class Pair {
        int x;
        int y;
        boolean self;

        public Pair(int x, int y, boolean self) {
            this.x = x;
            this.y = y;
            this.self = self;
        }
    }
}