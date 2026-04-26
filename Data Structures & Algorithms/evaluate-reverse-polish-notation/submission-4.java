class Solution {
    public int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>(Arrays.asList(tokens));

        return dfs(list);
    }
    private int dfs(List<String> tokens){
        String s = tokens.remove(tokens.size() - 1);

        if(!"+-*/".contains(s)){
            return Integer.parseInt(s);
        }

        int right = dfs(tokens);
        int left = dfs(tokens);

        switch(s){
            case "+" :
                return left + right;
            case "-" :
                return left - right;
            case "*" :
                return left * right;
            case "/" :
                return left / right;
        }
        return 0;
    }
}
