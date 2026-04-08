class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> mp = new HashSet<>();

        for(int i = 0; i< nums.length ; i++){
            if(!mp.add(nums[i])){
                return true;
            }
        }
        
        /*for(int i = 0; i < nums.length ; i++){
            mp.put(nums[i] , mp.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++){
            if(mp.get(nums[i]) > 1){
                return true;
            }
        }*/
        return false;
    }
}