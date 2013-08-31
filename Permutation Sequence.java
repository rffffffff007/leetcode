/**
 * @time: 2013-08-31
 */
public class Solution {
    public String getPermutation(int n, int k) {
        k = k - 1;
        StringBuffer result = new StringBuffer();
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++)
            nums.add(i);
        int[] fac = getFacArray(n);
        for (int i = 0; i < n; i++) {
            // choose one digit in each iteration.
            int d = k / fac[n - 1 - i];
            k = k % fac[n - 1 - i];
            result.append(nums.get(d));
            nums.remove(d);
        }
        return result.toString();
    }

    private int[] getFacArray(int n) {
        int[] fac = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                fac[i] = 1;
            else {
                fac[i] = fac[i - 1] * i;
            }
        }
        return fac;
    }
}