class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        
        backtrack(new int[nums.length] ,new ArrayList<>() ,nums);

        return res;

    }
    void backtrack(int[] used ,List<Integer> cur ,int[] nums)
    {
        if(cur.size() == nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(used[i] == 1)
                continue;
            
            used[i] = 1;
            cur.add(nums[i]);
            backtrack(used ,cur ,nums);
            used[i] = 0;
            cur.remove(cur.size()-1);

        }
    }
}
