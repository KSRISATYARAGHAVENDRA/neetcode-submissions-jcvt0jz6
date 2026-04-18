class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] array = new int[256];
        Arrays.fill(array, -1);
        int l = 0;
        int maxLen = 0;

        for(int r = 0; r < s.length(); r++){
            int indexofChar = (int) s.charAt(r);

            l = Math.max(l , array[indexofChar] + 1);
            array[indexofChar] = r;
            maxLen = Math.max(maxLen , r - l + 1); 
        }
        return maxLen;
    }
}
