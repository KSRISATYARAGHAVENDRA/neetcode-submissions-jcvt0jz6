class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Idx = new HashMap<>();

        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        for(int i = 0; i < nums1.length; i++){
            nums1Idx.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums2.length; i++){
            int cur = nums2[i];

            while(!stack.isEmpty() && cur > stack.peek()){
                int ele = stack.pop();
                int Idx = nums1Idx.get(ele);
                result[Idx] = cur;
            }
            if(nums1Idx.containsKey(cur)){
                stack.push(cur);
            }
        }
        return result; 
    }
}