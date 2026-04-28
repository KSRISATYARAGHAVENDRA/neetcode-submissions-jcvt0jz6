class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n;

        while(l < h){
            int m = l + ((h - l) / 2);
            if(nums[m] >= target){
                h = m;
            }
            else{
                l = m + 1;
            }
            
        }
        return (l < n && nums[l] == target)? l : -1;
    }
}
