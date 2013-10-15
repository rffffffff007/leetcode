public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end,
            HashSet<String> dict) {
        // bfs get search path.
        Map<String, List<String>> last = bfsPaths(start, end, dict);
        // dfs get all shortest path
        ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        dfsPaths(end, start, last, new ArrayList<String>(), paths);
        return paths;
    }

    // Use builded graph to perform bfs.
    private Map<String, List<String>> bfsPaths(String start, String end,
            Set<String> dict) {
        Set<String> visited = new HashSet<String>();
        Set<String> newAdded = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int leftCount = 0;
        Map<String, List<String>> last = new HashMap<String, List<String>>();
        Map<String, List<String>> graph = buildGraph(dict);
        while (!queue.isEmpty()) {
            if (leftCount == 0) {
                leftCount = queue.size();
                if (newAdded.contains(end)) {
                    break;
                }
                visited.addAll(newAdded);
                newAdded.clear();
            }
            String node = queue.poll();
            leftCount--;
            List<String> adj = graph.get(node);
            if (adj != null)
                for (String str : adj)
                    if (!visited.contains(str)) {
                        if (!newAdded.contains(str)) {
                            queue.offer(str);
                            newAdded.add(str);
                        }
                        addMap(last, str, node);
                    }
        }
        return last;
    }

    // Iterate all possible path to perform bfs.
    private Map<String, List<String>> bfsPaths2(String start, String end,
            Set<String> dict) {
        Set<String> visited = new HashSet<String>();
        Set<String> newAdded = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int leftCount = 0;
        Map<String, List<String>> last = new HashMap<String, List<String>>();
        while (!queue.isEmpty()) {
            if (leftCount == 0) {
                leftCount = queue.size();
                if (newAdded.contains(end)) {
                    break;
                }
                visited.addAll(newAdded);
                newAdded.clear();
            }
            String node = queue.poll();
            leftCount--;
            char[] cs = node.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char tmp = cs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == tmp)
                        continue;
                    cs[i] = c;
                    String str = new String(cs);
                    if (dict.contains(str) && !visited.contains(str)) {
                        if (!newAdded.contains(str)) {
                            queue.offer(str);
                            newAdded.add(str);
                        }
                        addMap(last, str, node);
                    }
                }
                cs[i] = tmp;
            }
        }
        return last;
    }

    private void dfsPaths(String end, String start,
            Map<String, List<String>> last, ArrayList<String> path,
            ArrayList<ArrayList<String>> paths) {
        path.add(end);
        if (end.equals(start)) {
            ArrayList<String> cpath = new ArrayList<String>();
            cpath.addAll(path);
            Collections.reverse(cpath);
            paths.add(cpath);
        } else {
            if (last.containsKey(end))
                for (String next : last.get(end)) {
                    dfsPaths(next, start, last, path, paths);
                }
        }
        path.remove(path.size() - 1);
    }

    // use sort to build the graph
    private Map<String, List<String>> buildGraph(Set<String> dict) {
        List<String> nodes = new ArrayList<String>();
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        nodes.addAll(dict);
        int wordLen = nodes.get(0).length();
        int n = nodes.size();
        NodeComparator cmp = new NodeComparator();
        for (int maski = 0; maski < wordLen; maski++) {
            cmp.mask = maski;
            Collections.sort(nodes, cmp);
            int lasti = 0;
            for (int i = 0; i <= n; i++) {
                if (i == n || cmp.compare(nodes.get(i), nodes.get(lasti)) != 0) {
                    for (int x = lasti; x < i; x++)
                        for (int y = lasti; y < i; y++)
                            if (x != y)
                                addMap(graph, nodes.get(x), nodes.get(y));
                    lasti = i;
                }
            }
        }
        return graph;
    }
    
    private class NodeComparator implements Comparator<String> {
        int mask = -1;

        @Override
        public int compare(String a, String b) {
            for (int i = 0; i < a.length(); i++)
                if (i != mask && a.charAt(i) != b.charAt(i))
                    return a.charAt(i) - b.charAt(i);
            return 0;
        }
    }

    private void addMap(Map<String, List<String>> map, String a, String b) {
        if (map.containsKey(a)) {
            map.get(a).add(b);
        } else {
            List<String> list = new ArrayList<String>();
            list.add(b);
            map.put(a, list);
        }
    }
}