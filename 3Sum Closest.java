public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int len = num.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len - 2; i++){
            for(int j = i + 1; j < len - 1; j++){
                int value = target - num[i] - num[j];
                int k = bsearch(num, j + 1, len, value);
                if(k < j + 1){
                    k = j + 1;
                }
                if(k + 1 < len && Math.abs(value - num[k + 1]) < Math.abs(value - num[k])){
                    k++;
                }
                value -= num[k];
                if(Math.abs(value) < Math.abs(min)){
                    min = value;
                }
            }
        }
        return target - min;
    }
    
    private int bsearch(int[] n, int start, int end, int target){
        if(end - start <= 2){
            if(target >= n[end - 1]){
                return end - 1;
            }else if(target >= n[start]){
                return start;
            }else{
                return start - 1;
            }
        }
        int mid = (start + end) / 2;
        if(n[mid] <= target){
            return bsearch(n, mid, end, target);
        }else{
            return bsearch(n, start, mid, target);
        }
    }
}