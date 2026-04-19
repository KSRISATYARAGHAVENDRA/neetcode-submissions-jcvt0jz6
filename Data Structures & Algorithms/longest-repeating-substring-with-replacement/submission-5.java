class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            Map<Character, Integer> mp = new HashMap<>();
            int maxCnt = 0;
            for(int j = i; j < s.length(); j++){
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j) ,0) + 1);
                maxCnt = Math.max(mp.get(s.charAt(j)), maxCnt);

                if(j - i + 1 - maxCnt <= k){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
