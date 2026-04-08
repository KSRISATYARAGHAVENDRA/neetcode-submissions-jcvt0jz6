class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int val : nums){
            if(seen.contains(val)){
                return  true;
            }else{
                seen.add(val);
            }
        }
        return false;
        
    }
}