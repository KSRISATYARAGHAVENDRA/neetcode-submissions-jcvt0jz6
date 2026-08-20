class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(0 , target ,new ArrayList<>(), candidates);
        
        return res;
        
    }
    void backtrack(int i ,int target ,List<Integer> cur ,int[] nums){
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || i == nums.length){
            return;
        }

        cur.add(nums[i]);
        backtrack(i + 1 ,target - nums[i] ,cur ,nums);

        cur.remove(cur.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        backtrack(i + 1 , target , cur, nums);
        
    }
}
