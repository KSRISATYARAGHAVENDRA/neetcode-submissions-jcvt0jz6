class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;

        for(int i = 0; i < n; i++){
            int height = heights[i];
            int width = 1;

            for(int l = i - 1; l >= 0; l--){
                if(heights[l] >= height){
                    width++;
                }
                else{
                    break;
                }
            }
            for(int r = i + 1; r < n; r++){
                if(heights[r] >= height){
                    width++;
                }
                else{
                    break;
                }
            }
            if(width != height){
                area = Math.max(area, width * height);
            }
        }
        return area;
    }
}
