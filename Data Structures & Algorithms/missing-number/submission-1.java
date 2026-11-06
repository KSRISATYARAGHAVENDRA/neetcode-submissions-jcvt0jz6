class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int n = 0; n < nums.length;n++)
            res ^= nums[n] ^ n+1;
        
        return res;
    }
}
