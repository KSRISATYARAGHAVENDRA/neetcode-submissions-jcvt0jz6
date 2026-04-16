class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        for(int j = 0; j < nums2.length; j++){
            map.put(nums2[j], j + 1);
        }

        for(int i = 0; i < nums1.length; i++){
            
            int num = nums1[i];
            
            for(int j = map.get(num); j < nums2.length; j++){
                if(nums2[j] > num){
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}