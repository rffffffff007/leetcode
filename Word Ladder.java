/**
 * Time complexity: 26 * n * logn.
 */
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        dict.add(start);
        dict.add(end);
        Map<String, List<String>> graph = buildGraph(dict);

        // perform a bfs to get shortest steps.
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int leftCount = 0;
        int step = 0;
        Set<String> visited = new HashSet<String>();
        while (!queue.isEmpty()) {
            if (leftCount == 0) {
                leftCount = queue.size();
                step++;
            }
            String node = queue.poll();
            leftCount--;
            List<String> adj = graph.get(node);
            if (adj != null)
                for (String s : adj)
                    if (!visited.contains(s)) {
                        if (s.equals(end))
                            return step + 1;
                        queue.offer(s);
                        visited.add(s);
                    }

        }
        return 0;
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

    private void addMap(Map<String, List<String>> map, String a, String b) {
        if (map.containsKey(a)) {
            map.get(a).add(b);
        } else {
            List<String> list = new ArrayList<String>();
            list.add(b);
            map.put(a, list);
        }
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
}

/**
 * Time complexity: n * 26 * wordlen^2
 */
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int step = 0;
        int leftCount = 0;
        while (!queue.isEmpty()) {
            if (leftCount == 0) {
                leftCount = queue.size();
                step++;
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
                    if(str.equals(end)){
                        return step + 1;
                    }
                    if (dict.contains(str) && !visited.contains(str)){
                        queue.offer(str);
                        visited.add(str);
                    }
                }
                cs[i] = tmp;
            }
        }
        return 0;
    }
}