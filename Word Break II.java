
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> senList = new ArrayList<String>();

        Set<Character> dictSet = new HashSet<Character>();
        for (String word : dict)
            for (int i = 0; i < word.length(); i++)
                dictSet.add(word.charAt(i));
        for (int i = 0; i < s.length(); i++)
            if (!dictSet.contains(s.charAt(i)))
                return senList;

        TrieNode root = null;
        for (String word : dict)
            root = insert(root, word);

        dfsWord(s, "", "", senList, root, root);
        return senList;
    }

    private void dfsWord(String s, String sentence, String word,
            List<String> senList, TrieNode curNode, TrieNode root) {
        if (curNode == null)
            return;
        if (s.length() == 0) {
            if (word.length() == 0) 
                senList.add(sentence);
            return;
        }
        char c = s.charAt(0);
        int ci = c - 'a';
        TrieNode nextNode = curNode.children[ci];
        word += c;
        if (nextNode != null) {
            dfsWord(s.substring(1), sentence, word, senList, nextNode, root);
            if (nextNode.isKey) {
                if (sentence.length() > 0)
                    sentence += " ";
                dfsWord(s.substring(1), sentence + word, "", senList, root,
                        root);
            }
        }
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