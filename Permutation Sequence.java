public class Solution {
	private int[][] fac;

	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		fac = new int[n + 1][n + 1];
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
		}
		
		for (int i = n - 1; i > 0; i--) {
			int facII = factorialStore(i, i);
			while (k > facII) {
				nextPermutation(array, n - i, 0, n);
				k -= facII;
				if (k == 1) {
					break;
				}
			}
		}
		
		char[] charArray = new char[n];
		for (int i = 0; i < n; i++) {
			charArray[i] = (char) ('0' + array[i]);
		}
		return new String(charArray);
	}

	/**
	 * 
	 * @param array: {1, 2, 3, 4}
	 * @param r: nPr, select r numbers from n numbers.
	 * @param s: start index.
	 * @param e: end index. 
	 * @return whether there is a next permutation.
	 */
	public boolean nextPermutation(int[] array, int r, int s, int e) {
		reverse(array, s + r, e - 1);
		int i = s + r - 1, j;
		for (; i >= s; i--) {
			for (j = e - 1; j > i; j--) {
				if (array[j] > array[i]) {
					swap(array, i, j);
					break;
				}
			}
			if (j > i) {
				break;
			}
		}
		reverse(array, i + 1, e - 1);
		return i >= s;
	}

	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private void reverse(int[] array, int a, int b) {
		while (a < b) {
			swap(array, a++, b--);
		}
	}

	private int factorialStore(int n, int m) {
		if (fac[n][m] == 0) {
			fac[n][m] = factorial(n, m);
		}
		return fac[n][m];
	}

	private int factorial(int n, int m) {
		int sum = 1;
		for (int i = n; i > n - m; i--) {
			sum *= i;
		}
		return sum;
	}
}
