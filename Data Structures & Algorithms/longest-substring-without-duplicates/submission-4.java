// brute force with hash set 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for(int l = 0; l < s.length(); l++){
            Set<Character> set = new HashSet<>();
            for(int r = l; r < s.length(); r++){
                if(set.contains(s.charAt(r))){
                    break;
                }
                set.add(s.charAt(r));
            }
            maxLen = Math.max(maxLen ,set.size());
        }
        return maxLen;
    }
}
