public class Solution {
    public int searchInsert(int[] A, int target) {
        return bsearch(A, 0, A.length, target);
    }
    
    private int bsearch(int[] a, int s, int e, int target){
        if(s == e)
            return s;
        int mid = (s + e) / 2;
        int val = a[mid];
        if(val == target)
            return mid;
        else if(target > val)
            return bsearch(a, mid + 1, e, target);
        else 
            return bsearch(a, s, mid, target);
    }
}