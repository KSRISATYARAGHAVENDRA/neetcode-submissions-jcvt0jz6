class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq =  new PriorityQueue<>();
        
        for(int num : nums){
            pq.offer(num);
        }
        while(pq.size() > k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        pq.poll();
        return pq.peek();
    }
}
