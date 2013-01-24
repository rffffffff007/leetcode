import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        int len = num.length;
        for(int i = 0; i < len - 2; i++){
            for(int j = i + 1; j < len - 1; j++){
                int k = bsearch(num, j + 1, len, -num[i] - num[j]);
                if(k >= 0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    set.add(list);
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.addAll(set);
        Collections.sort(res, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                for(int i = 0; i < a.size(); i++){
                    if(a.get(i) == b.get(i)){
                        continue;
                    }else{
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            } 
        });
        return res;
    }

    private int bsearch(int[] n, int start, int end, int target){
        if(end == start){
            return -1;
        }
        int mid = (start + end) / 2;
        if(n[mid] < target){
            return bsearch(n, mid + 1, end, target);
        }else if(n[mid] > target){
            return bsearch(n, start, mid, target);
        }else{
            return mid;
        }
    }
}