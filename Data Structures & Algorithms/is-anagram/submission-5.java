class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++){
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            if(array[curr] != 0){
                return false;
            }
        }
        return true;
    }
}
