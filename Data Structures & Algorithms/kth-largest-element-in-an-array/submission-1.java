class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums , 0 , nums.length - 1 , k);
    }

    int quickSelect(int[] nums , int l , int r ,int k){

        int p = l;
        int pivot = nums[r];

        for(int i = l; i < r; i++){
            if(nums[i]<=pivot){
                swap(nums , i , p);
                p++;
            }
        }
        swap (nums , r , p);

        if(p > k){
            return quickSelect(nums, l , p - 1 , k);
        }
        else if(p < k){
            return quickSelect(nums, p + 1 , r , k);
        }
        else{
            return nums[p];
        }
    }

    void swap(int[] nums , int l , int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
