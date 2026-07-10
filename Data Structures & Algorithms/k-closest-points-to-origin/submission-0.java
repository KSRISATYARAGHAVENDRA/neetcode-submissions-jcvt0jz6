class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int[] point : points){
            int x = point[0] * point[0];
            int y = point[1] * point[1];
            int dist = x + y;

            pq.offer(new int[] {dist, point[0], point[1]} );

            if(pq.size() > k)
                pq.poll();
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            
            int j = 0;
            res[i][j++] = pq.peek()[1];
            res[i][j] = pq.poll()[2];

        }
        return res;
    }
}
