class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, res = 0;
        int r = Arrays.stream(piles).max().getAsInt();

        while(l <= r){
            long totaltime = 0;
            int k = l + ((r - l) / 2);

            for(int pile : piles){
                totaltime += (int) Math.ceil((double) pile / k);
            }
            if(totaltime <= h){
                res = k;
                r = k - 1;
            }
            else{
                l = k + 1;
            }
        }
        return res;
    }
}
