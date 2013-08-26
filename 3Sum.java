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


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int n = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> resSet = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            int target = -num[i];
            int s = i + 1;
            int e = n - 1;
            while(s < e){
                if (num[s] + num[e] == target){
                    ArrayList<Integer> items = new ArrayList<Integer>(); 
                    items.add(num[i]);
                    items.add(num[s]);
                    items.add(num[e]);
                    Collections.sort(items);
                    resSet.add(items);
                    e--;
                    s++;
                } else if(num[s] + num[e] > target){
                    e--;
                } else{
                    s++; 
                }
            }
        }
        res.addAll(resSet);
        return res;
    }
}

/**
 * @time: 2013-08-22
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        
        int n = num.length;
        Set<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int s = i + 1;
            int e = n - 1;
            while(s < e){
                int val = num[i] + num[s] + num[e];
                if(val == 0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[s]);
                    list.add(num[e]);
                    resultSet.add(list);
                    s++;
                    e--;
                } else if(val > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        resultList.addAll(resultSet);
        Collections.sort(resultList, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                for(int i = 0; i < a.size(); i++){
                    if(a.get(i) != b.get(i))
                        return a.get(i) - b.get(i);
                }
                return 0;
            }
        });
        return resultList;
    }
}

