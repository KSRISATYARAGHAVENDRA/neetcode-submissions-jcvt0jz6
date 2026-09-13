class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        partition(0 , new ArrayList<>(), s);
        return res;
    }
    void partition(int st ,List<String> cur, String s){
        if(st == s.length()){
            res.add(new ArrayList(cur));
            return;
        }
        for(int end = st; end < s.length(); end++){
            if(isPalin(s.substring(st , end+1))){
                cur.add(s.substring(st,end+1));
                partition(end+1,cur,s);
                cur.remove(cur.size() - 1);
            }
        }
    }
    boolean isPalin(String s){
        int i = 0 , j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    } 
}
