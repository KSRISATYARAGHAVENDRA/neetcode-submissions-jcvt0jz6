class Solution {
    public int trap(int[] height) {
        int water = 0;
        for(int i = 0; i < height.length; i++){
            int leftMax = 0, rightMax = 0;
            
            for(int l = 0; l <= i; l++){
                leftMax = Math.max(leftMax, height[l]);
            }
            for(int r = i; r < height.length; r++){
                rightMax = Math.max(rightMax, height[r]);
            }

            water += Math.min(leftMax ,rightMax) - height[i];
        }
        return water;
    }
}
