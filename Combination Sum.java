
/**
 * @time: 2013-08-27
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        searchSum(candidates, target, 0, new ArrayList<Integer>(), result);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        resultList.addAll(result);
        return resultList;
    }
    
    private void searchSum(int[] nums, int target, int index, ArrayList<Integer> choices, Set<ArrayList<Integer>> result){
        if(target == 0){
            // success.
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(choices);
            result.add(list);
            return;
        } else if(index == nums.length || target < 0){
            return;
        }
        
        choices.add(nums[index]);
        searchSum(nums, target - nums[index], index, choices, result);
        searchSum(nums, target - nums[index], index + 1, choices, result);
        choices.remove(choices.size() - 1);
        
        searchSum(nums, target, index + 1, choices, result);
    }
}

/**
 * Ugly code. Using a dp matrix cannot improve the performance. 
 * This piece is same with the next solution.
 */ 
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
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
                if (notEmpty(i, j - candidates[i], nodes)) {
                    nodes[i][j].addPair(i, j - candidates[i], true);
                }
            }
        }

        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(candidates, nodes, nodes[n - 1][target], set, list);
        res.addAll(set);
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
            Node node = nodes[p.x][p.y];
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
        boolean valid = i >= 0 && i < nodes.length && j >= 0
                && j < nodes[i].length;
        return valid && (j == 0 || nodes[i][j].notEmpty());
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
