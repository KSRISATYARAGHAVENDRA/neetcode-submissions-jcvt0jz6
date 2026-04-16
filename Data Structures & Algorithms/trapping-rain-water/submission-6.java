// two pointer
class Solution {
    public int trap(int[] height) {
        int water = 0;
        int l =0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];

        while(l < r){
            if(leftMax <= rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                water += leftMax - height[l];
            }
            else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                water += rightMax - height[r];
            }
        }
        return water;
    }
}
