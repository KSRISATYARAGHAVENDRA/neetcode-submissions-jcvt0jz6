class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int l = 0, r = 0;
        while(r < n){
            while(!dq.isEmpty() && nums[r] > nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(r);

            if(r >= k - 1){
                while(l > dq.peekFirst()){
                    dq.pollFirst();
                }
                res[l] = nums[dq.peekFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
