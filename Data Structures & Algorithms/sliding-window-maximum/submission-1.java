class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        for(int i = 0; i < nums.length; i++){
            maxheap.offer(new int[]{nums[i], i});

            if(i >= k - 1){
                //delete top if presnt outside window
                while(maxheap.peek()[1] <= i - k){
                    maxheap.poll();
                }
                res[idx++] = maxheap.peek()[0];
            }
        }
        return res;
    }
}
