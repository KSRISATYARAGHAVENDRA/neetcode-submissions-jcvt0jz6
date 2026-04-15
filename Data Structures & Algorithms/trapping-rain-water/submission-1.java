class Solution {
    public int trap(int[] height) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        int water = 0;

        int leftMax = 0 , rightMax = 0;
        for(int l = 0 ; l < height.length; l++){
            leftMax = Math.max(height[l] , leftMax);
            leftMap.put(l, leftMax);
        }
        for(int r = height.length - 1 ; r >= 0; r--){
            rightMax = Math.max(height[r] , rightMax);
            rightMap.put(r, rightMax);
        }
        for(int i = 0; i < height.length; i++){
            water += Math.min(leftMap.get(i), rightMap.get(i)) - height[i];
        }
        return water;
    }
}
