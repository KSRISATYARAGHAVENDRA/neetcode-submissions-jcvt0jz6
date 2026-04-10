class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] array = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int product = 1;
            int j = 0;
            while(j < nums.length){
                if(j != i){
                    product *= nums[j];
                    j++;
                }
                else{
                    j++;
                }
            }
            array[i] = product;
        }
        return array;
    }
}  
