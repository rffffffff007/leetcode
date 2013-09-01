/**
 * @time: 2013-09-01
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int left = bsearchCeil(A, target, 0, n);
        int right = bsearchFloor(A, target, 0, n);
        if(left >= n || A[left] != target){
            left = -1;
        }
        if(right < 0 || A[right] != target){
            right = -1;
        }
        int[] res = new int[2];
        res[0] = left;
        res[1] = right;
        return res;
    }
    
    // return the min index, that a[index] >= target
    private int bsearchCeil(int[] a, int target, int s, int e){
        if(s == e){
            return e;
        }
        int mid = (s + e) / 2;
        int val = a[mid];
        if(target > val){
            return bsearchCeil(a, target, mid + 1, e);
        } else {
            return bsearchCeil(a, target, s, mid);
        }
    }
    
    // return the max index that a[index] <= target
    private int bsearchFloor(int[] a, int target, int s, int e){
        if(s == e){
            return s - 1;
        }
        int mid = (s + e) / 2;
        int val = a[mid];
        if(target >= val){
            return bsearchFloor(a, target, mid + 1, e);
        } else {
            return bsearchFloor(a, target, s, mid);
        }
    }
}