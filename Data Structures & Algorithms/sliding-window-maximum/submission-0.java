class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxawindow = new int[nums.length - k + 1];
        int index = 0;
        int l = 0;

        for(int i = 0; i < nums.length - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int r = i; r < i + k; r++){
                max = Math.max(max, nums[r]);
            }
            maxawindow[index++]= max;
        }
        return maxawindow;
    }
}
