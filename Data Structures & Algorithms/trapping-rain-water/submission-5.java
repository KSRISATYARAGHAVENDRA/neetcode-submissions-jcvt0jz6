// stack
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int water = 0;

        for(int i = 0; i < n; i++){
            
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();

                if(stack.isEmpty()) break;

                int left = stack.peek();
                int right = i;

                int width = right - left - 1;

                int length = Math.min(height[left], height[right]) - height[top];
                
                water += length * width;

            }
            stack.push(i);
        }
        return water;
    }
}
