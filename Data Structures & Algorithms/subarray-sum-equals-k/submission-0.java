class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long ,Integer> mp = new HashMap<>();
        long sum = 0;
        int subCnt = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(sum == k) subCnt++;

            long req = sum - k;
            if(mp.containsKey(req)){
                subCnt++;
            }

            mp.put(sum ,i);
        }
        return subCnt;
    }
}
