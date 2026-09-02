class Solution {

    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        backtrack(0 , 0 , new StringBuilder() , n);
        return res;
    }

    void backtrack(int open , int close ,StringBuilder cur ,int n){
        if(open == n && close == n){
            res.add(new String(cur));
        }
        if(open < n){
            cur.append("(");
            backtrack(open+1,close,cur,n);
            cur.deleteCharAt(cur.length()-1);
        }
        if(open > close){
            cur.append(")");
            backtrack(open, close+1, cur,n);
            cur.deleteCharAt(cur.length()-1);
        }
    }

}
