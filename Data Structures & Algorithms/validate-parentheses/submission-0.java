class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;
        int l = 0, r = s.length() - 1;
         
        while(l < r){
            char c = s.charAt(l);
            char d = s.charAt(r);

            if(c == '(' && d == ')' 
            || c == '{' && d == '}' 
            || c == '[' && d == ']'){
                l++;
                r--;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
