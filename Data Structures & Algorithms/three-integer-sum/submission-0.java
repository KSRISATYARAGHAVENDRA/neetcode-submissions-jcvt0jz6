class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i -1]) continue;
            int num = nums[i];
            int l = i + 1, r = nums.length - 1;

            while(l < r){
                int sum = num + nums[l] + nums[r];
                if(sum < 0){
                    l++;
                }
                else if(sum > 0){
                    r--;
                }
                else{
                    res.add(Arrays.asList(num, nums[l], nums[r]));
                    l++;
                    r--;

                    while(l < r && nums[l] == nums[l - 1]) l++;
                    while(r > l && nums[r] == nums[r + 1]) r--;
                }
            }
        }
        return res;
    }
}
