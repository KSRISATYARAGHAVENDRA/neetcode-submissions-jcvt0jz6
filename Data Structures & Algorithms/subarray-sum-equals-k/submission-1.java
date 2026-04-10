class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long ,Integer> mp = new HashMap<>();
        mp.put(0L, 1);
        long sum = 0;
        int subCnt = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            subCnt += mp.getOrDefault(sum - k , 0);

            mp.put(sum , mp.getOrDefault(sum, 0) + 1);
        }
        return subCnt;
    }
}
