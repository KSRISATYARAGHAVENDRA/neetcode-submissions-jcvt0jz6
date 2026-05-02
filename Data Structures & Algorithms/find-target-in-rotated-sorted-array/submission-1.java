class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while(l < r){
            int m = l + ((r -l) / 2);

            if(nums[m] > nums[r]){
                l = m + 1;
            }
            else{
                r = m;
            }
        }
            int pivot = l;
            l = 0;
            r = n - 1;

            if(nums[pivot] <= target && nums[r] >= target ){
                l = pivot;
            }
            else{
                r = pivot - 1;
            }

            while(l <= r){
                int m = l + ((r - l) / 2);

                if(nums[m] == target){
                    return m;
                }
                else if(nums[m] > target){
                    r = m - 1;
                }
                else{
                    l = m + 1;
                }
            }
    return -1;
    }
}
