class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i = 1; i < res.length; i++){
            res[i] = numOfBits(i);
        }

        return res;
    }
    int numOfBits(int n){
        int res = 0;
        while(n > 0){
            res = (n&1) == 1?res+1 : res;
            n = n>>>1;
        }

        return res;
    }
}
