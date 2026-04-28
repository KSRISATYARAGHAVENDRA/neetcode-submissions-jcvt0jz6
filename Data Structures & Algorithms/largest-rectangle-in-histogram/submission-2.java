class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int area = 0;

        int[] leftmost = new int[n];
        for(int i = 0; i < n; i++){
            leftmost[i] = -1;

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                leftmost[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        int[] rightmost = new int[n];
        for(int i = n - 1; i >= 0; i--){
            rightmost[i] = n;
            
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                rightmost[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i = 0; i < n; i++){
            area = Math.max(area, heights[i] * (rightmost[i] - leftmost[i] - 1));
        }
        return area;
    }
}
