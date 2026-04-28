class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n;

        while(l < h){
            int m = l + ((h - l) / 2);
            if(nums[m] > target){
                h = m;
            }
            else{
                l = m + 1;
            }
            
        }
        return (l > 0 && nums[l -1] == target)? l - 1 : -1;
    }
}
