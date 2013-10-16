public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        Set<Character> dictSet = new HashSet<Character>();
        for (String word : dict)
            for (int i = 0; i < word.length(); i++)
                dictSet.add(word.charAt(i));
        for (int i = 0; i < s.length(); i++)
            if (!dictSet.contains(s.charAt(i)))
                return false;

        TrieNode root = null;
        for (String word : dict)
            root = insert(root, word);

        return dfsWord(s, "", root, root);
    }

    private boolean dfsWord(String s, String word, TrieNode curNode,
            TrieNode root) {
        if (curNode == null)
            return false;
        if (s.length() == 0)
            return word.length() == 0;
        char c = s.charAt(0);
        int ci = c - 'a';
        TrieNode nextNode = curNode.children[ci];
        word += c;
        boolean res = false;
        if (nextNode != null) {
            res = dfsWord(s.substring(1), word, nextNode, root);
            if (!res && nextNode.isKey)
                res = dfsWord(s.substring(1), "", root, root);
        }
        return res;
    }

    private class TrieNode {
        private static final int R = 26;
        TrieNode[] children;
        boolean isKey;

        public TrieNode() {
            children = new TrieNode[R];
        }
    }

    private TrieNode insert(TrieNode node, String s) {
        if (node == null) {
            node = new TrieNode();
        }
        if (s.length() == 0) {
            node.isKey = true;
        } else {
            int c = s.charAt(0) - 'a';
            node.children[c] = insert(node.children[c], s.substring(1));
        }
        return node;
    }
}