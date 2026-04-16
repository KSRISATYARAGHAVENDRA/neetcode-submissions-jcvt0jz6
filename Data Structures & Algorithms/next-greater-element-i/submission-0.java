class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        //Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];

        for(int j = 0; j < nums2.length; j++){
            map.put(nums2[j], j + 1);
        }
        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            int j = map.get(num);
            
            while(j < nums2.length){
                if(nums2[j] > num){
                    res[i] = nums2[j];
                    break;
                }
                else{
                    j++;
                }
            }
            if(j == nums2.length){
                res[i] = -1;
            }
        }
        return res;
    }
}