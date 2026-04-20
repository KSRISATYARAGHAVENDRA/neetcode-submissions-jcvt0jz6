class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1freq[s1.charAt(i) - 'a']++;
            s2freq[s2.charAt(i) - 'a']++;
        }

        int matched = 0;
        for(int i = 0; i < 26; i++){
            if(s1freq[i] == s2freq[i]){
                matched++;
            }
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            
            if(matched == 26){
                return true;
            }

            int index = s2.charAt(r) - 'a';
            
            s2freq[index]++;
            if(s1freq[index] == s2freq[index]){
                matched++;
            }
            else if(s1freq[index] + 1 == s2freq[index]){
                matched--;
            }
            
            int indexL = s2.charAt(l) - 'a';
            s2freq[indexL]--;
            if(s1freq[indexL] == s2freq[indexL]){
                matched++;
            }
            else if(s1freq[indexL] - 1 == s2freq[indexL]){
                matched--;
            }
            l++;
        }
        return matched == 26;
    }
}
