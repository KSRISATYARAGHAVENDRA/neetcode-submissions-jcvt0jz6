class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        if(list.contain())
                        List<Integer> lt = Arrays.asList(nums[i] ,nums[j] ,nums[k]);

                        if(!list.contains(lt)){
                            list.add(new ArrayList<>(lt));
                        }
                    }
                }
            }
        }
        return list;
    }
}
