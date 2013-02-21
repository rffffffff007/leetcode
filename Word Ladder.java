public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<Node> dicts = new ArrayList<Node>();
		int n = 0;
		Node startNode = new Node(n++, start);
		dicts.add(startNode);
		for (String s : dict) {
			dicts.add(new Node(n++, s));
		}
		Node endNode = new Node(n++, end);
		dicts.add(endNode);

		List<ArrayList<Node>> passMap = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < n; i++) {
			passMap.add(new ArrayList<Node>());
		}

		ArrayList<Node> sortArray = new ArrayList<Node>();
		sortArray.addAll(dicts);
		int wordLen = start.length();
		NodeComparator comparator = new NodeComparator();
		for (int maskIndex = 0; maskIndex < wordLen; maskIndex++) {
			comparator.mask = maskIndex;
			Collections.sort(sortArray, comparator);
			int lastj = 0;
			for (int i = 1; i <= n; i++) {
				if (i == n
						|| comparator.compare(sortArray.get(i),
								sortArray.get(lastj)) != 0) {
					for (int j = lastj; j < i; j++) {
						for (int k = j + 1; k < i; k++) {
							passMap.get(sortArray.get(j).index).add(
									sortArray.get(k));
							passMap.get(sortArray.get(k).index).add(
									sortArray.get(j));
						}
					}
					lastj = i;
				}
			}
		}

		Queue<Node> queue = new LinkedList<Node>();
		startNode.visited = true;
		startNode.step = 1;
		queue.offer(startNode);

		Node nodei = null;
		while (queue.size() > 0) {
			nodei = queue.poll();
			if (nodei.index == n - 1) {
				endNode = nodei;
				break;
			}
			for (Node nodej : passMap.get(nodei.index)) {
				if (!nodej.visited) {
					nodej.visited = true;
					nodej.step = nodei.step + 1;
					queue.offer(nodej);
				}
			}
		}
		return endNode != null ? endNode.step : 0;
	}

	class NodeComparator implements Comparator<Node> {
		int mask = -1;

		@Override
		public int compare(Node a, Node b) {
			char ca, cb;
			for (int i = 0; i < a.val.length(); i++) {
				ca = a.val.charAt(i);
				cb = b.val.charAt(i);
				if (i != mask && ca != cb) {
					return ca - cb;
				}
			}
			return 0;
		}
	}

	private class Node {
		int index;
		String val;
		int step;
		boolean visited;

		public Node(int index, String val) {
			this.index = index;
			this.val = val;
			this.step = 0;
			visited = false;
		}

		@Override
		public String toString() {
			return val;
		}
	}
}