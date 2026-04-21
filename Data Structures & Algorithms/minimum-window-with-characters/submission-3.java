// sliding window with hash map
class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        int[] res = {-1, -1};
        int reslen = Integer.MAX_VALUE;

        Map<Character ,Integer> tcount = new HashMap<>();
        Map<Character ,Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            tcount.put(c, tcount.getOrDefault(c, 0) + 1);
        }
        
        int need = tcount.size();
        int have = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(tcount.containsKey(c) && tcount.get(c).equals(window.get(c))){
                have++;
            }

            while(have == need){
                if(r - l + 1 < reslen){
                    reslen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if(tcount.containsKey(left) && tcount.get(left) > window.get(left)){
                    have--;
                }
                l++;
            }
        }
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
