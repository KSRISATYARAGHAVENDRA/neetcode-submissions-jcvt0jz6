class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {

        backTrack(0 , new ArrayList<>() , nums);

        return res;
    }

    void backTrack(int i , List<Integer> path , int[] nums){

        if(i == nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }

        path.add(nums[i]);
        backTrack(i + 1 , path , nums);

        path.remove(path.size() - 1);

        backTrack(i + 1 , path , nums);

    }
}
