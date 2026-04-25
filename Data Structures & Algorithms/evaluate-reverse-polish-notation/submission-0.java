class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> res = new Stack<>();

        for(String s : tokens){
            
            if(s.equals("+")){
                res.push(res.pop() + res.pop());
            }
            else if(s.equals("-")){
                int a = res.pop();
                int b = res.pop();
                res.push(b - a);
            }
            else if(s.equals("*")){
                res.push(res.pop() * res.pop());
            }
            else if(s.equals("/")){
                int a = res.pop();
                int b = res.pop();
                res.push(b / a);
            }
            else{
                res.push(Integer.parseInt(s));
            }
        }
        return res.pop();
    }
}
