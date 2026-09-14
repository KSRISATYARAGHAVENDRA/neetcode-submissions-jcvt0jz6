class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int l = 1; l <= n; l++){
            for(int i = 0; i <= n - l; i++){
                dp[i][i + l - 1] = s.charAt(i) == s.charAt(i+l-1) && 
                                   ( i + 1 > i + l - 2 || dp[i+1][i+l-2]);
            }
        } 
        
        partition(0 , new ArrayList<>(), s ,dp);
        
        return res;
    }
    void partition(int st ,List<String> cur, String s,boolean[][] dp){
        if(st == s.length()){
            res.add(new ArrayList(cur));
            return;
        }
        for(int end = st; end < s.length(); end++){
            if(dp[st][end]){
                cur.add(s.substring(st,end+1));
                partition(end+1,cur,s,dp);
                cur.remove(cur.size() - 1);
            }
        }
    } 
}
