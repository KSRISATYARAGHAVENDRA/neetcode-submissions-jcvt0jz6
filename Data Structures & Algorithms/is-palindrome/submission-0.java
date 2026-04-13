class Solution {
    public boolean isPalindrome(String s) {
        String S = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = S.length() - 1;

        

        while(left < right && S.charAt(left) == S.charAt(right)) {
	        left++;
	        right--;
	    }
        if(left < right){
            return false;
        }
        return true;
    }
}
