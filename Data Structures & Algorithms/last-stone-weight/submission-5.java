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
            if(freqStones[first] % 2 == 0){
                first--;
                continue;
            }
            int j = Math.min(first - 1, second);  // used because if new first was between first and second and obvious second will be second when this runs

            while(j > 0 && freqStones[j] == 0){
                j--;
            }

            if(j == 0)  // when j > 0 is failed this runs
                return first;  
            
            second = j;
            freqStones[first]--;  // smash
            freqStones[second]--; // smash
            freqStones[first - second]++;  // new weight increase

            first = Math.max(second , first - second); //new first will be maximum between (second and first - second)
        } 
        return first;
    }
}
