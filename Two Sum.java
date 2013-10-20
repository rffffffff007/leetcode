public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            int num = numbers[i];
            if(!map.containsKey(num))
                map.put(num, new ArrayList<Integer>());
            map.get(num).add(i);
        }
        for(int i = 0; i < n; i++){
            int num = numbers[i];
            if(map.containsKey(target - num)){
                List<Integer> list = map.get(target - num);
                if(num == target - num && list.size() < 2)
                    continue;
                int[] res = new int[]{i + 1, list.get(list.size() - 1) + 1};
                Arrays.sort(res);
                return res;
            }
        }
        return null;
    }
}