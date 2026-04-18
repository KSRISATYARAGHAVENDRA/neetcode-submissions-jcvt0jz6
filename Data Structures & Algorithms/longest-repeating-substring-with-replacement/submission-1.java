class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();

        for(char c : s.toCharArray()){
            mp.put(c ,mp.getOrDefault(c, 0) + 1);
        }
        int greatest = 0;
        for(char c : mp.keySet()){
            if(mp.get(c) > greatest){
                greatest = mp.get(c);
            }
        }

        for(int i = 1; i <= k; i++){
            if(greatest < s.length()){
                greatest++;
            }
            else{
                break;
            }
        }
        return greatest;
    }
}
