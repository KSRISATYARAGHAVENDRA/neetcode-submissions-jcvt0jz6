class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int num : nums) seen.add(num);

        int maxLen = 0;

        for(int num : seen){
            if(!seen.contains(num - 1)){
                int curr = num + 1;
                int streak = 1;

                while(seen.contains(curr)){
                    streak++;
                    curr++;
                }
                maxLen = Math.max(maxLen, streak);
            }
        }
        return maxLen;
    }
}
