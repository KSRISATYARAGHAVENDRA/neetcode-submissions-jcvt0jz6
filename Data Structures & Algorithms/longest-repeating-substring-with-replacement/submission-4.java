class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        
        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(i);
            sb.append(c);
            int opr = 0;
            for(int j = 0; j < s.length() && j != i; j++){ 
                if(s.charAt(j) != c){
                    if(opr >= k) break;
                    sb.append(c);
                    opr++;
                }
                else{
                    sb.append(c);
                }
            }
            maxLen = Math.max(maxLen ,sb.length());
        }
        return maxLen;
    }
}
