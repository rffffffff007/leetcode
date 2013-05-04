public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int oneStart = 0;
        int oneEnd = 0;
        int twoStart = n - 1;
        while (oneEnd <= twoStart) {
            while (twoStart >= oneEnd && A[twoStart] == 2) {
                twoStart--;
            }
            while (oneEnd <= twoStart && A[oneEnd] == 1) {
                oneEnd++;
            }
            if (oneEnd > twoStart) {
                break;
            }
            if (A[oneEnd] == 0) {
                if (oneEnd - oneStart > 0) {
                    A[oneStart] = 0;
                    A[oneEnd] = 1;
                }
                oneStart++;
                oneEnd++;
            } else if (A[twoStart] == 0) {
                swap(A, oneEnd, twoStart);
            } else {
                swap(A, oneEnd, twoStart);
            }
        }

    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}