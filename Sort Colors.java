public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int i0 = 0, i1 = 0;
        int i2 = n - 1;
        while(i1 <= i2){
            int val = A[i1];
            if(val == 0){
                swap(A, i0++, i1++);
            }else if(val == 1){
                i1++;
            }else{
                swap(A, i1, i2--);
            }
        }
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}