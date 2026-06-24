class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weights= new PriorityQueue<>((a,b) -> b-a );

        for(int stone : stones){
            weights.offer(stone);
        }

        while(weights.size() > 1){
            int heaviest = weights.poll();
            int nextHeaviest = weights.poll();
            int newStone = heaviest - nextHeaviest;

            if(newStone != 0){
                weights.offer(newStone);
            }
        }
        return weights.size() != 0? weights.peek() : 0;
    }
}
