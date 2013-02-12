public class Solution {
    static List<Pair> romans = new ArrayList<Pair>();
	static {
		romans.add(new Pair(1, 'I'));
		romans.add(new Pair(5, 'V'));
		romans.add(new Pair(10, 'X'));
		romans.add(new Pair(50, 'L'));
		romans.add(new Pair(100, 'C'));
		romans.add(new Pair(500, 'D'));
		romans.add(new Pair(1000, 'M'));
	}

	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == 0) {
			return "";
		}
		for (int i = romans.size() - 1; i >= 0; i--) {
			Pair p = romans.get(i);
			if (num >= p.a) {
				return "" + p.b + intToRoman(num - p.a);
			}
			if (i > 0) {
				Pair lastP = romans.get(i - 1 - ((i - 1) % 2));
				if (num >= p.a - lastP.a) {
					return "" + lastP.b + p.b
							+ intToRoman(num - (p.a - lastP.a));
				}
			}
		}
		return "";
	}

	static class Pair {
		int a;
		char b;

		public Pair(int a, char b) {
			this.a = a;
			this.b = b;
		}
	}

}