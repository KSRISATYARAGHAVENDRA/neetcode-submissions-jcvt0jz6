class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int dist = x*x + y*y;

            pq.offer(new int[]{dist, x ,y});

            if(pq.size() > k)
                pq.poll();
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            
            res[i][0] = pq.peek()[1];
            res[i][1] = pq.poll()[2];

        }
        return res;
    }
}
