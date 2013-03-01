public class Solution {
    public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = numbers.length;
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i + 1, numbers[i]);
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return a.val - b.val;
			}
		});
		int a = 0;
		int b = n - 1;
		int[] res = new int[2];
		int val;
		while (a < b) {
			val = nodes[a].val + nodes[b].val;
			if (val > target) {
				b--;
			} else if (val < target) {
				a++;
			} else {
				break;
			}
		}
		res[0] = nodes[a].index;
		res[1] = nodes[b].index;
		if (res[0] > res[1]) {
			int tmp = res[0];
			res[0] = res[1];
			res[1] = tmp;
		}
		return res;
	}

	class Node {
		int val;
		int index;

		public Node(int i, int v) {
			index = i;
			val = v;
		}
	}
}