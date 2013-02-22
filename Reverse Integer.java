public class Solution {
    public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int sum = 0;
		int y = x;
		while (y != 0) {
			sum *= 10;
			sum += y % 10;
			y /= 10;
		}
		if (y < 0)
			sum *= -1;
		return sum;
	}

}