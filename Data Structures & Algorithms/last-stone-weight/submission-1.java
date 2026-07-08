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
            while(freqStones[first] % 2 == 0){
                first--;
                continue;
            }
            int j = Math.min(first - 1, second);  // to get new second

            while(j > 0 && freqStones[j] == 0){
                j--;
                continue;
            }
            if(j == 0)
                return first; // when only possible element
            
            second = j;
            freqStones[first]--;
            freqStones[second]--;
            freqStones[first - second]++;

            first = Math.max(second , first - second); //new first will be maximum between (second and first - second)
        } 
        return first;
    }
}
