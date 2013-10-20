public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        combination(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void combination(int[] nums, int index, int target, List<Integer> list, List<ArrayList<Integer>> res){
        int n = nums.length;
        if(index == n){
            if(target == 0)
                res.add(new ArrayList<Integer>(list));
            return;
        }
        combination(nums, index + 1, target, list, res);
        if(target >= nums[index]){
            list.add(nums[index]);
            combination(nums, index, target - nums[index], list, res);
            list.remove(list.size() - 1);
        }
    }
}