class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> mp = new HashMap<>();
        mp.put(')','(');
        mp.put('}', '{');
        mp.put(']', '[');

        for(char c : s.toCharArray()){
            if(mp.containsKey(c)){
                if(!stack.isEmpty() && mp.get(c) == stack.peek()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(c);
            }
        }
        return true;
    }
}
