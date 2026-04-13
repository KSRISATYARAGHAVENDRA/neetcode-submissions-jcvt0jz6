class Solution {
    public int longestConsecutive(int[] nums) {
      Map<Integer, Integer> mp = new HashMap<>();
      
      int maxLen = 0;

      for(int num : nums){
        if(!mp.containsKey(num)){
            mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);

            mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
            mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));

            maxLen = Math.max(maxLen , mp.get(num));
        }
      }
      return maxLen;  
    }
}
