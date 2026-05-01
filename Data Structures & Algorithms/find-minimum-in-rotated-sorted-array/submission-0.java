class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if(nums[l] <= nums[r]) return nums[l];

        while(l < r){
            int m = l + ((r - l) / 2);

            if(nums[r] > nums[m]){
                r = m; 
            }
            else{
                l = m + 1;
            }
        }
        return nums[l];
    }
}
