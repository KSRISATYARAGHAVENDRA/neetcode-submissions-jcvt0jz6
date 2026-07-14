class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
            count[task-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int cnt : count){
            if(cnt > 0)
                maxHeap.offer(cnt);
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;  // only effective if heap is not empty

            if(maxHeap.isEmpty()){
                time = q.peek()[1]; // directly going to cooldown
            }
            else{
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0)
                    q.offer(new int[]{cnt , time + n});
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.offer(q.poll()[0]); //next in task to heap 
            }
        }
        return time;
    }
}
