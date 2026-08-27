class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums , new ArrayList() ,0);

        return res;
    }
    void backtrack(int[] nums ,List cur , int i){
        if(i == nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums , cur ,i+1);

        cur.remove(cur.size() - 1);
        while(i < nums.length - 1 && nums[i] == nums[i+1] ) i++;
        backtrack(nums , cur , i + 1);
    }
}
