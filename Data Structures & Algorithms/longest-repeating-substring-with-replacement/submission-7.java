class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, l = 0, maxCnt = 0;
        Map<Character, Integer> mp = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            maxCnt = Math.max(maxCnt, mp.get(s.charAt(r)));

            while(r - l + 1 - maxCnt > k){
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
