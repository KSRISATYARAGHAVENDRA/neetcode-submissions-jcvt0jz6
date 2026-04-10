class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] array = new int[nums.length];
        int product = 1; 
        int zeroCnt = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCnt++;
            }
            else{
                product *= nums[i];
            }
        }
        if(zeroCnt > 1) return array;
        for(int i = 0; i < nums.length; i++){
            if(zeroCnt == 1){
                array[i] = (nums[i] == 0) ? product : 0;
            }
            else{
                array[i] = (int) (product / nums[i]);
            }
        }
        return array;
    }
}  
