class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = Integer.MIN_VALUE;

        for(int weight : stones){
            max = Math.max(max , weight);
        }

        int[] freqStones = new int[max+1];

        for(int weight : stones){
            freqStones[weight]++;
        }

        int first = max , second = max;
        while(first > 0){
            while(first > 0 && freqStones[first] % 2 == 0)
                first--;
            
            second = first - 1;  // to get new second

            while(second > 0 && freqStones[second] == 0)
                second--;
            
            if(second < 1)
                return first; // when only possible element
            
            freqStones[first]--;
            freqStones[second]--;
            freqStones[first - second]++;

            first = Math.max(second , first - second); //new first will be maximum between (second and first - second)
        } 
        return first;
    }
}
