public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int len = num.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int value = target - num[i] - num[j];
                int k = bsearch1(num, j + 1, len, value);
                if (k < j + 1) {
                    k = j + 1;
                }
                if (k + 1 < len
                        && Math.abs(value - num[k + 1]) < Math.abs(value
                                - num[k])) {
                    k++;
                }
                value -= num[k];
                if (Math.abs(value) < Math.abs(min)) {
                    min = value;
                }
            }
        }
        return target - min;
    }

    private int bsearch(int[] n, int start, int end, int target) {
        if (end - start == 1) {
            return target >= n[start] ? start : start - 1;
        }
        int mid = (start + end) / 2;
        if (n[mid] <= target) {
            return bsearch(n, mid, end, target);
        } else {
            return bsearch(n, start, mid, target);
        }
    }

    private int bsearch1(int[] n, int start, int end, int target) {
        int mid = start;
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (n[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return target >= n[start] ? start : start - 1;
    }
    
    private int bsearch2(int[] n, int start, int end, int target){
        int mid;
        while(start < end){
            mid = (start + end) / 2;
            if (n[mid] < target){
                start = mid + 1;
            } else if(n[mid] > target){
                end = mid;
            } else{
                return mid;
            }
        }
        return start - 1;
    }

}

/** 
 * Second version.
 * @time: 20130822
 */
public class Solution {
	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(num);

		int minDiff = Integer.MAX_VALUE;
		int n = num.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int diff = minDiff(num, j + 1, n, target - num[i] - num[j]);
				if (Math.abs(diff) < Math.abs(minDiff))
					minDiff = diff;
			}
		}
		return target - minDiff;
	}

	private int minDiff(int[] array, int s, int e, int target) {
		int i = bsearch(array, s, e, target);
		int minDiff = Integer.MAX_VALUE;
		for (int j = 0; j < 2; j++, i++) {
			if (i >= s && i < e) {
				if (Math.abs(target - array[i]) < Math.abs(minDiff)) {
					minDiff = target - array[i];
				}
			}
		}
		return minDiff;
	}

	public int bsearch(int[] array, int s, int e, int target) {
		if (e - s == 0) {
			return s - 1;
		}
		int mid = (e + s) / 2;
		int val = array[mid];
		if (target == val) {
			return mid;
		} else if (target > val) {
			return bsearch(array, mid + 1, e, target);
		} else {
			return bsearch(array, s, mid, target);
		}
	}
}