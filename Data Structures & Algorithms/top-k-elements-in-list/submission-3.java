class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer ,Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i] , mp.getOrDefault(nums[i] ,0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i = 0; i < nums.length + 1; i++){
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer ,Integer> entry : mp.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0; 
        for(int i = bucket.length - 1; i >= 0 && idx < k; i--){
            for(int num : bucket[i]){
                result[idx++] = num;
            } 
        }
        return result; 
    }
}
