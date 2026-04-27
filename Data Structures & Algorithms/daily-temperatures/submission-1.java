class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int []> stack = new Stack<>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int curr = temperatures[i];
            while(!stack.isEmpty() && curr > stack.peek()[0]){
                int[] top = stack.pop();
                res[top[1]] = i - top[1];
            }
            stack.push(new int[]{curr, i});
        }
        return res;
    }
}
