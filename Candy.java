public class Solution {
    public int candy(int[] ratings) {
        // min value of the left point of current descending sequence.
        int minLeft = 1;
        int end = ratings.length;
        int sum = 0;
        int k = 1;
        for (int i = 0; i < end; i++, k++) {
            if (i == end - 1 || ratings[i] <= ratings[i + 1]) {
                // reach the end of a descending sequence.
                sum += Math.max(k, minLeft);
                if (i < end - 1 && ratings[i + 1] > ratings[i])
                    minLeft = (k == 1 ? minLeft : 1) + 1;
                else
                    minLeft = 1;
                k = 0;
            } else {
                sum += k;
            }
        }
        return sum;
    }
}