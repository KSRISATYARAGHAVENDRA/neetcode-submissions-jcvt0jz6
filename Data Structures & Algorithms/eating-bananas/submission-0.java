class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1;

        while(true){
            long totaltime = 0;

            for(int pile : piles){
                totaltime += (int) Math.ceil((double) pile / speed );
            }
            if(totaltime <= h){
                return speed;
            }
            speed++;
        }
    }
}
