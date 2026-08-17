class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        Arrays.sort(nums);

        backtrack(nums , target , new ArrayList<>() , 0);
        
        return res;
    }

    void backtrack(int[] nums , int target , List<Integer> cur , int index){

        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = index; i < nums.length; i++){

            if(target - nums[i] < 0){
                break;
            }

            cur.add(nums[i]);
            backtrack(nums , target - nums[i] , cur , i);
            cur.remove(cur.size() - 1);
        
        }
    }
}
