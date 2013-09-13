/**
 * @time: 2013-08-27
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        searchSum(candidates, target, 0, new ArrayList<Integer>(), resultList);
        return resultList;
    }
    
    private void searchSum(int[] nums, int target, int index, ArrayList<Integer> choices, ArrayList<ArrayList<Integer>> result){
        if(target == 0){
            // success.
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(choices);
            result.add(list);
            return;
        } else if(index == nums.length || target < 0){
            return;
        }
        
        choices.add(nums[index]);
        searchSum(nums, target - nums[index], index, choices, result);
        choices.remove(choices.size() - 1);
        
        searchSum(nums, target, index + 1, choices, result);
    }
}

