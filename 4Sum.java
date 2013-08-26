import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        List<Node> nodes = new ArrayList<Node>();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                nodes.add(new Node(i, j, num[i] + num[j]));
            }
        }
        Collections.sort(nodes);
        
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        
        int nodeLen = nodes.size();
        for(int i = 0; i < nodeLen - 1; i++){
            Node ni = nodes.get(i);
            int j = bsearch(nodes, i + 1, nodeLen, target - ni.value);
            if(j >= 0){
                searchSameValue(set, num, nodes, i, j, 1);
                searchSameValue(set, num, nodes, i, j, -1);
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
    
    private void searchSameValue(Set<ArrayList<Integer>> set, int[] num, List<Node> nodes, int i, int j, int dir){
        int njv = nodes.get(j).value;
        Node ni = nodes.get(i);
        while(j > i && j < nodes.size() && nodes.get(j).value == njv){
            Node nj = nodes.get(j);
            ArrayList<Integer> list = new ArrayList<Integer>();
            Set<Integer> intSet = new HashSet<Integer>();
            intSet.add(ni.i);
            intSet.add(ni.j);
            intSet.add(nj.i);
            intSet.add(nj.j);
            if(intSet.size() == 4){
                list.add(num[ni.i]);
                list.add(num[ni.j]);
                list.add(num[nj.i]);
                list.add(num[nj.j]);
                Collections.sort(list);
                set.add(list);
            }
            j += dir;
        }
    }
    

    class Node implements Comparable<Node>{
        public Node(int x, int y, int value){
            this.i = x;
            this.j = y;
            this.value = value;
        }
        
        public int compareTo(Node n){
            return value - n.value;
        }
        
        int i;
        int j;
        int value;
    }
    
    private int bsearch(List<Node> n, int start, int end, int target){
        if(end == start){
            return -1;
        }
        int mid = (start + end) / 2;
        Node node = n.get(mid);
        if(node.value < target){
            return bsearch(n, mid + 1, end, target);
        }else if(node.value > target){
            return bsearch(n, start, mid, target);
        }else{
            return mid;
        }
    }
}


/**
 * @time: 2013-08-26
 * use a hashMap to change 4sum to 2sum.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        Map<Integer, ArrayList<Pair>> numMap = new HashMap<Integer, ArrayList<Pair>>();
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                Pair p = new Pair(i, j);
                int sum = num[i] + num[j];
                ArrayList<Pair> pairs = numMap.get(sum);
                if(pairs == null){
                    pairs = new ArrayList<Pair>();
                    numMap.put(sum, pairs);
                }
                pairs.add(p);
                
            }
        }
        
        Set<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();
        for(int keya : numMap.keySet()){
            int keyb = target - keya;
            ArrayList<Pair> listA = numMap.get(keya);
            ArrayList<Pair> listB = numMap.get(keyb);
            if(keya == keyb){
                int lena = listA.size();
                for(int i = 0; i < lena; i++){
                    for(int j = i + 1; j < lena; j++){
                        Pair pa = listA.get(i);
                        Pair pb = listA.get(j);
                        if(!pa.overlap(pb))
                            resultSet.add(toList(num, pa, pb));
                    }
                }
            } else if(listB != null){
                for(Pair pa : listA){
                    for(Pair pb : listB){
                        if(!pa.overlap(pb))
                            resultSet.add(toList(num, pa, pb));
                    }
                }
            }

        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.addAll(resultSet);
        return result;
    }
    
    private ArrayList<Integer> toList(int[] num, Pair pa, Pair pb){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(num[pa.a]);
        list.add(num[pa.b]);
        list.add(num[pb.a]);
        list.add(num[pb.b]);
        Collections.sort(list);
        return list;
    }
    
    private class Pair{
        int a;
        int b;
        
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        public boolean overlap(Pair p){
            if(p == null)
                return false;
            return a == p.a || a == p.b || b == p.a || b == p.b;
        }
    }
}