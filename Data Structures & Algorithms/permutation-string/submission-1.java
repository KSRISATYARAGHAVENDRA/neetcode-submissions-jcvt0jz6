class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            Map<Character, Integer> count2 = new HashMap<>();
            boolean valid = true;
            
            for (int j = i; j < i + s1.length(); j++) {
                char c = s2.charAt(j);
                count2.put(c, count2.getOrDefault(c, 0) + 1);
            }
            for(Character c : count1.keySet()){
                if(count1.get(c) != count2.getOrDefault(c, 0)){
                    valid =  false;
                }
            }
            if (valid) return true;
        }
        return false;
    }
}
