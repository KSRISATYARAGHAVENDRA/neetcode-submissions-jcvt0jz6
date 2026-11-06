class Solution {
    public int missingNumber(int[] nums) {
        int n =  nums.length + 1;
        int sum = n * (n-1) / 2;
        int arrSum = 0;
        for(int n1 : nums)
            arrSum += n1;
        
        return sum - arrSum;
    }
}
