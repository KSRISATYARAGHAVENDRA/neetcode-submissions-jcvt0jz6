class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[k];
        Map<Integer ,Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i] , mp.getOrDefault(nums[i] ,0) + 1);
        }
        for(int i = 0; i < k; i++){
            int max = Integer.MIN_VALUE;
            int MAX = 0 ;
            for(int key : mp.keySet()){
                int f = mp.get(key);
                if(f > max){
                    max = f;
                    MAX = key;
                }   
            }
            
            freq[i] = MAX;
            mp.remove(MAX);   
        
        }
        return freq;
    }
}
