class Solution {
    public String minWindow(String s, String t) {
        String res = new String();

        List<Character> original = new ArrayList<>();
        for(char c : t.toCharArray()){
            original.add(c);
        }

        for(int i = 0; i < s.length(); i++){
            if(!original.contains(s.charAt(i))) continue;

            List<Character> copy = new ArrayList<>(original);
            for(int j = i; j < s.length(); j++){
                
                copy.remove(Character.valueOf(s.charAt(j)));

                if(copy.isEmpty()){
                    int len = j - i + 1; 
                    if(res.isEmpty()){
                        res = s.substring(i, j + 1);
                    }
                    else if(len < res.length()){
                        res = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return res;
    }
}
