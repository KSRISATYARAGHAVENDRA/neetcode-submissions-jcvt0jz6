class Solution {
    public String minWindow(String s, String t) {
        int[] res = {-1 ,-1};
        int resLen = Integer.MAX_VALUE;

        Map<Character, Integer> tmap = new HashMap<>();
        int tcount = 0;
        for(int i = 0; i < t.length(); i++){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
            tcount++;
        }

        Map<Character, Integer> smap = new HashMap<>();
        int scount = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            if(tmap.containsKey(s.charAt(i))){
                l = i;
                break;
            }
        }
        
        for(int r = l; r < s.length(); r++){
            char c = s.charAt(r);
            if(tmap.containsKey(c)){
                smap.put(c, smap.getOrDefault(c, 0) + 1);
                scount++;
            }

            while(smap.getOrDefault(c, 0) > tmap.getOrDefault(c, 0)){
                smap.put(s.charAt(l), smap.get(s.charAt(l)) - 1);
                l++;
                scount--;
                while(l < s.length() && !tmap.containsKey(s.charAt(l))) l++;
            }

            if(scount == tcount && r - l + 1 < resLen){
                resLen = r - l + 1;
                res[0] = l;
                res[1] = r;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
